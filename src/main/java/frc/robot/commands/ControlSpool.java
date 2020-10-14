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
import frc.robot.control.ButtonMap;


public class ControlSpool extends Command {
  /**
   * spoolSpeed how fast the spool spins.
   */
  private double spoolSpeed = 0.5;
  /**
   * Creates a ControlSpool constuctor.
   */
  public ControlSpool() {
    /** Use requires() here to declare subsystem dependencies*/
    requires(Robot.spool);
  }

  /** Called just before this Command runs the first time*/
  @Override
  protected void initialize() {
  }

  /** Called repeatedly when this Command is scheduled to run*/
  @Override
  protected void execute() {
    if(OI.getPanelButtonState(ButtonMap.winchUp)){
      Robot.spool.MoveSpool(spoolSpeed);
    } else if(OI.getPanelButtonState(ButtonMap.winchDown)){
     Robot.spool.MoveSpool(-spoolSpeed);
    } else {
      Robot.spool.MoveSpool(0);
    }
  }

  /** Make this return true when this Command no longer needs to run execute()*/
  @Override
  protected boolean isFinished() {
    return false;
  }

  /** Called once after isFinished returns true*/
  @Override
  protected void end() {
  }

/**
*   Called when another command which requires one or more of the same
*   subsystems is scheduled to run
*/
  @Override
  protected void interrupted() {
  }
}
