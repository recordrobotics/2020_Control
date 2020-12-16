/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.ManualDrive;

/**
 * This is the class that all Record Robotics drive trains should extend
 */
public abstract class DriveTrain extends SubsystemBase {
  public DriveTrain() {
    setDefaultCommand(new ManualDrive());
  }

  private long disabled_time = 0;
  private long disabled_start_time = 0;

  /**
   * @param amount amount to move the wheel. Depends on contex, is usually percent
   *               output
   */
  public abstract void moveLeftWheels(double amount);

  /**
   * @param amount amount to move the wheel. Depends on contex, is usually percent
   *               output
   */
  public abstract void moveRightWheels(double amount);

  /**
   * @return The Value of the right encoder in INCHES
   */
  public abstract double getRightEncoder();

  /**
   * @return The Value of the right encoder in INCHES
   */
  public abstract double getLeftEncoder();

  /**
   * Reset both encoders to zero
   */
  public abstract void resetEncoders();

  /**
   * @return The differential drive object used, if any
   */
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
