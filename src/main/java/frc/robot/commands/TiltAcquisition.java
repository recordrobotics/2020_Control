/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

/**
 * An example command.  You can replace me with your own command.
 */
public class TiltAcquisition extends Command {
  private Timer acqTimer = new Timer();
  private double acqMoveTime = 3;
  public TiltAcquisition() {
    // Use requires() here to declare subsystem dependencies  
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    acqTimer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override 
  protected void execute() {
    if(Robot.acq.getTiltPosition()){
      Robot.acq.moveTilt(-Robot.acq.getTiltSpeed());
    }
    else{
      Robot.acq.moveTilt(Robot.acq.getTiltSpeed());
    }    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return acqTimer.get() > acqMoveTime && Robot.acq.getTiltLimit();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.acq.setTiltPosition(!Robot.acq.getTiltPosition());
    acqTimer.stop();
    acqTimer.reset();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
