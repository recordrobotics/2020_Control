/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.control.*;

public class LiftControl extends Command {
  /**
   * Creates a LiftControl constructor.
   */
  public LiftControl() {
    /** Use requires() here to declare subsystem dependencies*/
    requires(Robot.lift);
  } 
  /**
   * speed the speed the lift moves.
   * position safety or no safety.
   */
  private double speed = 0.8;
  private double position = 0;  /**nonzero value kills the saftey mechanism*/
    /** Use requires() here to declare subsystem dependencies*/
   private boolean useEncoder = false;
   private boolean sentEncoderError = false;
/** Change the above variable to switch between using and not using an encoder */

  /** Called just before this Command runs the first time*/
  @Override
  protected void initialize() {
    if(useEncoder = false){
      position = 0;
    } /** If not using an encoder sets the position tracker to 0, DO NOT CHANGE THE DEFAULT POSITION VALUE */
  }

  /** Called repeatedly when this Command is scheduled to run*/
  @Override
  protected void execute() {
      liftControl();
  }
  /**
   * Moves lift based on GREEN PANEL BUTTONS OR YELLOW PANEL BUTTONS.
   */
  private void liftControl(){
/**
*    if the left green button is pressed, move up
*    if the right green button is pressed, move down
*/
    
      if((OI.getPanelButtonState(ButtonMap.liftRaise))  || OI.getPanelButtonState(ButtonMap.LiftOverrideUp)){
        Robot.lift.moveLift(speed);
        if(useEncoder = false){
        position++; 
        } /** moves the lift up when the correct buttons are pressed, if not using an encoder changes the position variable */
    } else if((OI.getPanelButtonState(ButtonMap.liftLower) && position >= 0) || OI.getPanelButtonState(ButtonMap.LiftOverrideDown)){
        Robot.lift.moveLift(-speed);
        if(useEncoder = false){
        position--;
        }/** moves the lift down when the correct buttons are pressed, if not using an encoder changes the position variable */
    } else {
        Robot.lift.moveLift(0);
    } /** Makes the lift not move under normal circumstances */
    if(useEncoder = true){
      try {
        position = Robot.lift.getPosition();
      } catch (NullPointerException ex){
       if(sentEncoderError =false){ System.out.println(ex);
        System.out.println("The Analog Encoder used as a lift safety mechanism not found");
        position = 0;
      sentEncoderError = true; }

      }
    } /**If using an encoder, sets the position variable to the position gotten by the encoder */

  
    SmartDashboard.putNumber("Lift position", position);
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
