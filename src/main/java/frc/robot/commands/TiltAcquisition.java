/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class TiltAcquisition extends CommandBase {
  /**
   * acqTimer Timer to time the amount of time that has passed since the
   * acquisition started tilting. acqMoveTime How long it should take to tilt.
   * TiltAcquisition Creates new TiltAcquisition object.
   */
  private Timer acqTimer = new Timer();
  private double acqMoveTime = 2.5;

  public TiltAcquisition() {
    /** Use requires() here to declare subsystem dependencies */
  }

  /** Called just before this Command runs the first time */
  @Override
  public void initialize() {
    acqTimer.start();
  }

  /** Called repeatedly when this Command is scheduled to run */
  @Override
  public void execute() {
    if (Robot.acq.getTiltPosition()) {
      Robot.acq.moveTilt(-Robot.acq.getTiltSpeed());
    } else {
      Robot.acq.moveTilt(Robot.acq.getTiltSpeed());
    }
  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    return acqTimer.get() > acqMoveTime && Robot.acq.getTiltLimit();
  }

  /** Called once after isFinished returns true */
  @Override
  public void end(boolean intterupted) {
    Robot.acq.setTiltPosition(!Robot.acq.getTiltPosition());
    acqTimer.stop();
    acqTimer.reset();
  }
}
