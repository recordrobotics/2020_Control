/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.ManualDrive;

/**
 * This is the class that all Record Robotics drive trains should extend
 */
public abstract class DriveTrain extends Subsystem {

  private long disabled_time = 0;
  private long disabled_start_time = 0;
  
  public void initDefaultCommand(){
    setDefaultCommand(new ManualDrive());
  }

  /* 
  * amount is ambiguous, if it is inconsistant accross robots, 
  * change the appropriate subclass of DriveTrain, NOT the command
  */
  public abstract void moveLeftWheels(double amount);
  public abstract void moveRightWheels(double amount);


  public abstract double getRightEncoder();
  public abstract double getLeftEncoder();
  public abstract void resetEncoders();

  public abstract DifferentialDrive getDrive();

  public boolean isDisabled() {
    return System.currentTimeMillis() - disabled_start_time < disabled_time; 
  }

  /*
  * disables for t millis
  */
  public void disable(long t) {
    disabled_time = t;
    disabled_start_time = System.currentTimeMillis();
  }

  public void stop() {
    moveLeftWheels(0);
    moveRightWheels(0);
  }
}
