package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoNav1 extends CommandGroup {
    /**start at edge of starting box
     */
    public AutoNav1() {
        addSequential(new CircularTrajectory(-3, 1.57));

    }
}
