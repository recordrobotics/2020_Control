package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class AutoNav1 extends CommandGroup {

    private double initX = 1.2, initY = 1.9;
    private double velocity;

    /**start at edge of starting box
     */
    public AutoNav1() {
        Robot.odometry.reset(initX, initY);
        velocity = SmartDashboard.getNumber("Autonomous Velocity", 2.0);

        System.out.println("Velocity = " + velocity);

        addSequential(new CircularTrajectory(-1.8, 0.45, velocity));
        addSequential(new CircularTrajectory(2.5, 0.9, velocity));
        addSequential(new CircularTrajectory(0.5, 2*Math.PI));
        addSequential(new CircularTrajectory(-3.6, 0.65, 3));
        addSequential(new CircularTrajectory(-0.5, 1.5*Math.PI));
        addSequential(new CircularTrajectory(-2.5, 0.4*Math.PI, velocity));
        addSequential(new CircularTrajectory(-0.6, 1.2*Math.PI));
        addSequential(new CircularTrajectory(4, Math.PI/4, velocity*1.25));
        addSequential(new CircularTrajectory(-5, Math.PI/4, velocity*1.25));
    }

    @Override
    protected void initialize() {
        velocity = SmartDashboard.getNumber("Autonomous Velocity", 2.0);   
        Robot.odometry.reset(initX, initY);    
    }
}
