/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.*;
import frc.robot.control.ButtonMap;
import frc.robot.subsystems.Grabber;

/**
 * An example command.  You can replace me with your own command.
 */
public class GrabberControl extends Command {
  public GrabberControl() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.grabber);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    grabberPistons();  
    extenderPistons();
    motors();
  }

  private void grabberPistons(){
      //on red button press, open or close the grabber
      if (OI.getButtonState(ButtonMap.redLeft)){
        Robot.grabber.moveGrabber(Value.kForward);
    } else if (OI.getButtonState(ButtonMap.redRight)){
        Robot.grabber.moveGrabber(Value.kReverse);
    } else {
        Robot.grabber.moveGrabber(Value.kOff);
    }
  }

  private void extenderPistons(){
    //on blue button press, extend or retract the extender
    if (OI.getButtonState(ButtonMap.blueLeft)){
      Robot.grabber.moveExtender(Value.kForward);
      System.out.println("Blue Left");
    } else if (OI.getButtonState(ButtonMap.blueRight)){
      Robot.grabber.moveExtender(Value.kReverse);
    } else {
      Robot.grabber.moveExtender(Value.kOff);
    }
  }

  private void motors(){
    if (OI.getButtonState(ButtonMap.white)){
      System.out.println("White Button");
      Robot.grabber.moveLeftMotor(0.6);
      Robot.grabber.moveRightMotor(0.6);
    } else {
      Robot.grabber.moveLeftMotor(0.0);
      Robot.grabber.moveRightMotor(0.0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}