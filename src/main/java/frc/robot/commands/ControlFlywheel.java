/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
//import frc.robot.control.ButtonMap;

public class ControlFlywheel extends Command {

  private String toggleButton = "X";
  private boolean prevToggle = false, flywheelIsOn = true;

  private double wheelSpeed = 1;

  public ControlFlywheel() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.flywheel);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //toggle
    if (OI.getXboxButtonState(toggleButton) != prevToggle){
      flywheelIsOn = !flywheelIsOn;
    }

    if (flywheelIsOn){
      Robot.flywheel.moveWheel(wheelSpeed);
    } else {
      Robot.flywheel.moveWheel(0);
    }

    prevToggle = OI.getXboxButtonState(toggleButton);
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
