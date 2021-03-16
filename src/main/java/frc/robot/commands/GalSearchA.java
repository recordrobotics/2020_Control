package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class GalSearchA extends CommandGroup {

    private double velocity;

    public GalSearchA(boolean redPath, double v){
        velocity = v;
        if (redPath) {
            redPath();
        }
        else {
            bluePath();
        }
    }
    public GalSearchA(boolean redPath) {
        this(redPath, 2.0);
    }

    private void bluePath() {
        addSequential(new CircularTrajectory(2, Math.PI/3, velocity));
        addSequential(new CircularTrajectory(-1.7, Math.PI/2, velocity));
        addParallel(new PickUpBall(2));
        addSequential(new CircularTrajectory(-1, Math.PI/2));
        addParallel(new PickUpBall(2));
        addSequential(new CircularTrajectory(0.8, 5*Math.PI/6, velocity));
        addParallel(new PickUpBall(2));
        addSequential(new CircularTrajectory(-3, Math.PI/3));
        
    }

    void redPath() {
        addSequential(new CircularTrajectory(-2, Math.PI/6, velocity));
        addParallel(new PickUpBall(2));
        addSequential(new CircularTrajectory(1.0, Math.PI/2.5, velocity));
        addParallel(new PickUpBall(3));
        addSequential(new CircularTrajectory(-1.8, Math.PI/6, velocity));
        addSequential(new CircularTrajectory(-0.5, 11*Math.PI/12, velocity));
        addParallel(new PickUpBall(2));
        addSequential(new CircularTrajectory(1.25, Math.PI/2, velocity));
        addSequential(new CircularTrajectory(1.75, Math.PI/5, velocity*1.25));
        addSequential(new CircularTrajectory(-4.5, Math.PI/4, velocity*1.25));
        
    }
    
}
