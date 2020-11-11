package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.*;

public abstract class BallLift extends Subsystem {

    public abstract void moveBelt(double v);
    public abstract int lowestFullSlot();
    public abstract int highestFullSlot();
    public abstract int countBall();
    public abstract boolean getSlot(int slot);


    public void initDefaultCommand() {
      setDefaultCommand(new BeltControl());
  }

}