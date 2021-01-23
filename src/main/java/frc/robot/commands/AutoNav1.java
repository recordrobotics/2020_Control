package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoNav1 extends CommandGroup {
    /**start at edge of starting box
     */
    public AutoNav1(double v) {
        double velocity = v;
        addSequential(new CircularTrajectory(-1.8, 0.45, velocity));
        addSequential(new CircularTrajectory(2.5, 0.9, velocity));
        addSequential(new CircularTrajectory(0.5, 2*Math.PI));
        addSequential(new CircularTrajectory(-3.6, 0.65, 3));
        addSequential(new CircularTrajectory(-0.5, 1.5*Math.PI));
        addSequential(new CircularTrajectory(-2.5, 0.4*Math.PI, velocity));
        addSequential(new CircularTrajectory(-0.6, 1.2*Math.PI));
        addSequential(new CircularTrajectory(4, Math.PI/4, velocity+1));
        addSequential(new CircularTrajectory(-5, Math.PI/4, velocity+1));

    }
}
