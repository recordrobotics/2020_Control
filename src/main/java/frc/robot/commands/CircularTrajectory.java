package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import frc.robot.Robot;

public class CircularTrajectory extends Command {

    private double velocity;
    private double radius;
    private double theta;
    private double time;

    //width of robot in meters (27")
    private DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(0.6858);
    private ChassisSpeeds chassisSpeeds;

    /**
     * 
     * @param r radius of trajectory in METERS
     * @param th angle of the circle to traverse in RADIANS
     * @param v how fast the robot should go in METERS PER SECOND
     */
    public CircularTrajectory(double r, double th, double v){
        velocity = v;
        radius = r;
        theta = th;

        chassisSpeeds = new ChassisSpeeds(velocity, 0, velocity/radius);
        time = 1.0/((1.0/theta) * chassisSpeeds.omegaRadiansPerSecond);
    }

    public CircularTrajectory(double r, double th){
        this(r, th, 2);
    }

    /*
    CIM Motor max speed @ 5330rpm
    model: Output = 0.246 * Velocity + 0.002
    */

    private double velocityToOutput(double v){
        return 0.246 * v + 0.002;
    }

    /** Called just before this Command runs the first time*/
    @Override
    protected void initialize() {
        
    }

    /** Called repeatedly when this Command is scheduled to run*/
    @Override 
    protected void execute() {
        Robot.driveTrain.moveLeftWheels(velocityToOutput(-kinematics.toWheelSpeeds(chassisSpeeds).leftMetersPerSecond));
        Robot.driveTrain.moveRightWheels(velocityToOutput(-kinematics.toWheelSpeeds(chassisSpeeds).rightMetersPerSecond));
    }

    /** Make this return true when this Command no longer needs to run execute()*/
    @Override
    protected boolean isFinished() {
        return timeSinceInitialized() >= time;
    }

    /** Called once after isFinished returns true*/
    @Override
    protected void end() {
        Robot.driveTrain.stop();
    }

    @Override
    protected void interrupted(){
        Robot.driveTrain.stop();
    }
    
}
