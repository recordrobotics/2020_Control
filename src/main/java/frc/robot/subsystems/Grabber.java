package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.GrabberControl;
import edu.wpi.first.wpilibj.Spark;

public abstract class Grabber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new GrabberControl());
  }

  public abstract void moveGrabber(DoubleSolenoid.Value v);
  public abstract void moveExtender(DoubleSolenoid.Value v);

  public abstract void moveLeftMotor(double v);
  public abstract void moveRightMotor(double v);
}