package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class AutoNav2 extends CommandGroup {

    private double velocity;

    private double initX = 1.1, initY = 0.65;

    public AutoNav2(double v){
        velocity = v;
        Robot.odometry.reset(initX, initY);

        addSequential(new CircularTrajectory(-1.4, 1.8*(Math.PI)/5, velocity));
        addSequential(new CircularTrajectory(2.5, 0.75 * Math.PI, velocity));
        
        addSequential(new CircularTrajectory(-0.6, 1.75 * Math.PI, velocity));

        addSequential(new CircularTrajectory(2.9, 0.7 * Math.PI, velocity));
        addSequential(new CircularTrajectory(-0.5, 1.8*(Math.PI)/5, velocity));
    }
    
}
