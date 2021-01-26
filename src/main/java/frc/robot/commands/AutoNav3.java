package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class AutoNav3 extends CommandGroup{
    
    double velocity;

    private double initX = 1.15, initY = 2.3;

    public AutoNav3(double v){
        velocity = v;
        Robot.odometry.reset(initX, initY);

        addSequential(new CircularTrajectory(-1, Math.PI/2.0, velocity));
        addSequential(new MoveForward(24, -0.5)); //this command is configured in Inches and Motor Output %. We should probably make it consistent at some point
        addSequential(new CircularTrajectory(4, Math.PI/4.0, -velocity));
        addSequential(new CircularTrajectory(0.7, 2.4*Math.PI/3.0, -velocity));
        addSequential(new MoveForward(80, 0.7));
        addSequential(new MoveForward(48, -0.7));
        addSequential(new CircularTrajectory(-1, Math.PI, velocity));
        addSequential(new MoveForward(72, -0.7));
        addSequential(new CircularTrajectory(1.5, Math.PI/2.0, -velocity));
        
    }

}
