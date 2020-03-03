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


public class BeltControl extends Command {
  private double beltSpeed = 0.6;
  private boolean moveUp = false;
  private boolean moveDown = false;

  public BeltControl() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.belt);
  }

  
  //new ball in the lift from acq
  private boolean checkNewBall(){
   return Robot.belt.getSlot(0) || (!Robot.belt.getSlot(1) && moveUp && !checkInput()) && !Robot.belt.getSlot(3);
    /*
    Move up if there is a ball in the lowest slot OR if the ball is already moving and there is no ball in slot 1
    NEVER move the ball if there is a ball in the top slot, unless due to user input

    May cause bug if there is an attempt to fire before any balls have been aquired
    maybe add timer when moving automatically, and time out to avoid movement when empty?
    or a flag when a ball has been recently aquired?
    */
  }

  private boolean checkInput(){
    return OI.getXboxButtonState("RT");
  }

  private boolean checkReverseInput(){
return OI.getXboxButtonState("B");
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute(){
    moveUp = checkInput();// || checkNewBall();
    
    
    moveDown = checkReverseInput();

    if (moveUp) { 
      Robot.belt.moveBelt(beltSpeed);
    } else if (moveDown){
      Robot.belt.moveBelt(-beltSpeed);
    }
    else {
      Robot.belt.moveBelt(0);
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
