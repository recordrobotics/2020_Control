package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class AutoNav2 extends CommandGroup {

    private double velocity;

    private double initX = 1.1, initY = 0.65;

    public AutoNav2(){
        velocity = SmartDashboard.getNumber("Autonomous Velocity", 2.0);
        Robot.odometry.reset(initX, initY);

        addSequential(new CircularTrajectory(-1.3, 1.5*(Math.PI)/5, velocity));
        addSequential(new CircularTrajectory(2.3, 0.8 * Math.PI, velocity));
        
        addSequential(new CircularTrajectory(-1, 1.9 * Math.PI, velocity));

        addSequential(new CircularTrajectory(2.35, 0.8 * Math.PI, velocity));
        addSequential(new CircularTrajectory(-1, (Math.PI)/2, velocity));
    }

    @Override
    protected void initialize() {
        velocity = SmartDashboard.getNumber("Autonomous Velocity", 2.0);
        Robot.odometry.reset(initX, initY);
    }
    
}
