package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class GalSearchA extends CommandGroup {

    private double velocity;
    private double initX = 0.5, initY = 2.3;
    private boolean redPath = false;

    

    public GalSearchA(){
        SmartDashboard.putBoolean("Acquistion", Robot.acq.isAcqOn());
        Robot.odometry.reset(initX, initY);
        velocity = SmartDashboard.getNumber("Autonomous Velocity", 2.0);

        addParallel(new TiltAcquisition());
        if (redPath) {
            initX = 0.0;
            initY = 2.286;
            redPath();
        }
        else {
            initX = 0.0;
            initY = 0.7;
            bluePath();
        }
    }

    private void bluePath() {
        addSequential(new MoveForward(132, -velocity));
        addSequential(new CircularTrajectory(-0.9, 5*Math.PI/6, velocity));
        addSequential(new CircularTrajectory(0.8, 5*Math.PI/6, velocity));
        addSequential(new CircularTrajectory(-3, Math.PI/3));
    }

    private void redPath() {
        addSequential(new CircularTrajectory(-2, Math.PI/12, velocity));
        addSequential(new CircularTrajectory(1.5, Math.PI/2.5, velocity));
        addSequential(new CircularTrajectory(-1.5, Math.PI/4, velocity));
        addSequential(new CircularTrajectory(-0.5, 11*Math.PI/12, velocity));
        addSequential(new CircularTrajectory(1.25, Math.PI/2, velocity));
        addSequential(new CircularTrajectory(1.75, Math.PI/2.75, velocity*1.25));
        addSequential(new CircularTrajectory(-4.5, Math.PI/6, velocity*1.25));
    }

    @Override
    protected void initialize() {
        velocity = SmartDashboard.getNumber("Autonomous Velocity", 2.0);    
        Robot.odometry.reset(initX, initY);
    }

    @Override
    protected void execute() {
        SmartDashboard.putBoolean("Acquistion", Robot.acq.isAcqOn());
    }
    
}
