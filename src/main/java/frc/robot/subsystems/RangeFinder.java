package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class RangeFinder extends SubsystemBase {
  public abstract double getDistance();
}
