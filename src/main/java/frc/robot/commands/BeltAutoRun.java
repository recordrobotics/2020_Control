/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

/**
 * ballTimer is a built in Timer function
 * beltSpeed the motor speed for the belt
 * flywheelSpeed the motor speed for the flywheel
 * ballTimeout the amount of time that the belt and flywheel run for 
 */
public class BeltAutoRun extends CommandBase {
  
  private Timer ballTimer = new Timer();
  private double beltSpeed = 0.5, flywheelSpeed = 0.80, ballTimeout = 5.0;

 /** Called just before this Command runs the first time*/
 
  @Override
  public void initialize() {
      /**
   * Starts the timer and turns on the flywheel motor at the set speed
   */
    ballTimer.start();
    Robot.flywheel.moveWheel(flywheelSpeed);
  }

  ///** Called rep Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    /**
     * Once again runs the flywheel motor at the set speed
     * If the timer has been running for at least 1 second runs the belt at the set speed
     */
    Robot.flywheel.moveWheel(flywheelSpeed);

    if (ballTimer.get() > 1)
      Robot.belt.moveBelt(beltSpeed);
  }
 /**
  * Ends the command when the timer value is greater than the timeout variable
  */
  /** Make this return true when this Command no longer needs to run execute()*/
  @Override
  public boolean isFinished() {
    return ballTimer.get() >= ballTimeout;
  }
/**
 * Stops the flywheel and belt when the command ends
 */
  /** Called once after isFinished returns true*/
  @Override
  public void end(boolean interrupted) {
    Robot.flywheel.moveWheel(0);
    Robot.belt.moveBelt(0);
  }

}
