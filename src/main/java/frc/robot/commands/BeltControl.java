/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.Robot;


public class BeltControl extends CommandBase {
  private double beltSpeed;
  private boolean moveUp;
  private boolean moveDown;

  public BeltControl() {
    /** Use requires() here to declare subsystem dependencies*/
    addRequirements(Robot.belt);
    this.beltSpeed = 0.6;
    this.moveUp = false;
    this.moveDown = false;
  }

  
  /**new ball in the lift from acq*/
  private boolean checkNewBall(){
   return Robot.belt.getSlot(0) || (!Robot.belt.getSlot(1) && 
   moveUp && !checkInput()) && !Robot.belt.getSlot(3);
    /** 
    Move up if there is a ball in the lowest slot OR if the ball is already moving and there is no ball in slot 1
    NEVER move the ball if there is a ball in the top slot, unless due to user input

    May cause bug if there is an attempt to fire before any balls have been aquired
    maybe add timer when moving automatically, and time out to avoid movement when empty?
    or a flag when a ball has been recently aquired?
    */
  }
/**
 * checkInput checks for the button to move up
 * checkReverseInput checks for the button to move down
 */
  private boolean checkInput(){
    return OI.getXboxButtonState("RT");
  }

  private boolean checkReverseInput(){
return OI.getXboxButtonState("B");
  }

  /** Called just before this Command runs the first time*/
  

  /** Called repeatedly when this Command is scheduled to run*/
  @Override
  public void execute(){
    moveUp = checkInput(); /** || checkNewBall();*/
  /** Called repeatedly when this Command is scheduled to run*/
    
    /**
     * Checks whether to run forwards or in reverse, then runs belt either forwards or in reverse
     */
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

  /** Make this return true when this Command no longer needs to run execute()*/
  @Override
  public boolean isFinished() {
    return false;
  }
  
}
