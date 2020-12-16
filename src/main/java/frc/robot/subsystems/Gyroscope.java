/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * This is the class that all Record Robotics gyroscopes should extend
 */
public abstract class Gyroscope extends SubsystemBase {
  public abstract double getDeg();

  public abstract double getRad();

  public abstract void gyroCalib();

  public abstract void gyroReset();
}
