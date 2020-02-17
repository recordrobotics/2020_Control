/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class BeltControl extends Command {
  private boolean[] ballSensors = new boolean[5];
  private double beltSpeed = 0.6;
  public BeltControl() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.belt);
  }
  private void controlBelt(){
    if(ballSensors[0] && !ballSensors[4]){
      //timer code to stop mechanicald issues of the belt stopping immediately
      Robot.belt.moveBelt(Beltspeed);
    }
   
  } 

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute(){
  controlBelt();
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
