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
/**import frc.robot.control.ButtonMap;*/

public class ControlFlywheel extends CommandBase {
  /**
   * prevToggle if it was last on or off.
   * flywheelIsOn if the flywheel is currently on or off.
   * useXboxController use xbox controller to toggle flywheel.
   * xboxButton which button on the xbox controller toggles the flywheel.
   * panelButton which button on the panel toggles the flywheel.
   * wheelSpeed how fast the flywheel spins.
   */
  private boolean prevToggle = false, flywheelIsOn = false;
  private boolean useXboxController = true;
  private String xboxButton = "X";
  private int panelButton = 6;

  private double wheelSpeed = Robot.flywheelSpeed;
  /**
   * Create a ControlFlywheel constructor.
   */
  public ControlFlywheel() {
    /** Use requires() here to declare subsystem dependencies*/
    addRequirements(Robot.flywheel);
  }

  /** Called just before this Command runs the first time*/
  

  /** Called repeatedly when this Command is scheduled to run*/
  @Override
  public void execute() {
    /**toggle*/
    if ((getButton() != prevToggle) && getButton()){
      flywheelIsOn = !flywheelIsOn;
      System.out.println("toggle! " + flywheelIsOn);
    }
    /**hold y to slow down flywheel*/
    if (flywheelIsOn){
      if (OI.getXboxButtonState("Y")){
        Robot.flywheel.moveWheel(wheelSpeed - 0.15);
      } else {
        Robot.flywheel.moveWheel(wheelSpeed);
      }
    } else {
      Robot.flywheel.moveWheel(0);
    }

    prevToggle = getButton();
  }
  /**
   * Returns the button used to toggle the flywheel.
   * @return the button used to toggle the flywheel.
   */
  private boolean getButton(){
    if (useXboxController){
      return OI.getXboxButtonState(xboxButton);
    } else {
      return OI.getPanelButtonState(panelButton);
    }
  }

  /** Make this return true when this Command no longer needs to run execute()*/
  @Override
  public boolean isFinished() {
    return false;
  }

  /** Called once after isFinished returns true*/
  

/**
*   Called when another command which requires one or more of the same
*   subsystems is scheduled to run
*/
  
}
