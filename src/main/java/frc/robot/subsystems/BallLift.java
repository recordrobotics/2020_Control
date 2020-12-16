package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.*;

public abstract class BallLift extends SubsystemBase {
    
    public BallLift() {
        setDefaultCommand(new BeltControl());
    }

    public abstract void moveBelt(double v);
    public abstract int lowestFullSlot();
    public abstract int highestFullSlot();
    public abstract int countBall();
    public abstract boolean getSlot(int slot);
}