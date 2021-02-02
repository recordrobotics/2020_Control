package frc.robot.commands;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class CircularTrajectory extends Command {

    private double velocity;
    private double radius;
    private double centerDist, leftDist, rightDist;
    private double initRightDist, initLeftDist;
    private double theta;
    private double time;

    //width of robot in meters (27")
    private DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(0.6858);
    private ChassisSpeeds chassisSpeeds;

    /**
     * 
     * @param r radius of trajectory in METERS. To turn left you need to have a negative radius
     * @param th angle of the circle to traverse in RADIANS
     * @param v how fast the robot should go in METERS PER SECOND
     */
    public CircularTrajectory(double r, double th, double v){
        if (v >= 0){
            velocity = SmartDashboard.getNumber("Autonomous Velocity", v);
        } else {
            velocity = -SmartDashboard.getNumber("Autonomous Velocity", -v);
        }
        radius = r;
        theta = th;

        centerDist = theta * radius;
        if (radius < 0){
            //left turn, left wheels = outer wheels, right wheels = inner wheels
            leftDist = theta * (Math.abs(radius) + 0.6858/2.0);
            rightDist = theta * (Math.abs(radius) - 0.6858/2.0);
        } else {
            //right turn, left wheels = inner wheels, right wheels = outer wheels
            leftDist = theta * (radius - 0.6858/2.0);
            rightDist = theta * (radius + 0.6858/2.0);
        }

        System.out.println("Left Distance = " + leftDist);
        System.out.println("Right Distance = " + rightDist);
    }

    public CircularTrajectory(double r, double th){
        this(r, th, 2);
    }

    /*
    CIM Motor max speed @ 5330rpm
    model: Output = 0.246 * Velocity (m/2) + 0.002
    
    TODO model might be causing imprecision, look into it at some point!
    */
    private double velocityToOutput(double v){
        double output = 0.246 * v + 0.002;
        
        //cap output magnitude at 98% for safety reasons
        if (output > 0.98){
            output = 0.98;
        }
        if (output < -0.98){
            output = -0.98;
        }

        return output;
    }

    /** Called just before this Command runs the first time*/
    @Override
    protected void initialize() {
        if (velocity >= 0){
            velocity = SmartDashboard.getNumber("Autonomous Velocity", velocity);
        } else {
            velocity = -SmartDashboard.getNumber("Autonomous Velocity", -velocity);
        }

        System.out.println("Command Speed = " + velocity);

        chassisSpeeds = new ChassisSpeeds(velocity, 0, velocity/radius);
        time = Math.abs(1.0/((1.0/theta) * chassisSpeeds.omegaRadiansPerSecond));

        initLeftDist = Robot.driveTrain.getLeftEncoder();
        initRightDist = Robot.driveTrain.getRightEncoder();
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
        //return timeSinceInitialized() >= time;
        return Math.abs(Robot.driveTrain.getLeftEncoder()) >= (leftDist * 39.37 + initLeftDist)
            && Math.abs(Robot.driveTrain.getRightEncoder()) >= (rightDist * 39.37 + initRightDist);
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
