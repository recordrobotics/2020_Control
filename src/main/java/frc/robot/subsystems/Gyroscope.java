/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Gyroscope extends Subsystem {
  @Override
  public void initDefaultCommand() {;
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  private ADXRS450_Gyro gyro = new ADXRS450_Gyro(RobotMap.gyroPort);

  //get angle in degrees
  public double getDeg(){
      return gyro.getAngle();
  }

  //get angle in radians
  public double getRad(){
      return Math.toRadians(gyro.getAngle());
  }

  //initialization: calibrate the gyroscope and set the initial angle to be 0
  public void gyroCalib(){
    gyro.calibrate();
    gyro.reset();
  }

  //reset the gyro without recalibrating
  public void gyroReset(){
    gyro.reset();
  }
}
