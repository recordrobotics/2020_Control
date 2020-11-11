package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class RangeFinder extends Subsystem {
    public abstract double getDistance();

  @Override
  public void initDefaultCommand() {
/**
*     Set the default command for a subsystem here.
*     setDefaultCommand(new MySpecialCommand());
*/
  }
}
