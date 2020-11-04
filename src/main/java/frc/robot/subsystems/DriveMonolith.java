/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * Drivetrain subclass for Monolith
 * Controls the wheels and their motors
 */
public class DriveMonolith extends DriveTrain {

  /**
   * Objects representing the motors
   * @see RobotMap.java for the port numbers 
   */
  Spark frontRight = new Spark(RobotMap.driveFrontRightPortMonolith);
  Spark backRight = new Spark(RobotMap.driveBackRightPortMonolith);
  Spark frontLeft = new Spark(RobotMap.driveFrontLeftPortMonolith);
  Spark backLeft = new Spark(RobotMap.driveBackLeftPortMonolith);

  /**
   * @param amount percent output
   * Set the speed of the left motors
   */
  public void moveLeftWheels(double amount){
    frontLeft.set(-amount);
    backLeft.set(-amount);
  }

  /**
   * @param amount percent output
   * Set the speed of the right motors
   */
  public void moveRightWheels(double amount){
    frontRight.set(amount);
    backRight.set(amount);
  }

  /**
   * @return value of the encoder
   * PLACEHOLDER, no enoders on Monolith atm
   */
  public double getLeftEncoder(){
    return 0.0;
  }

  /**
   * @return value of the encoder
   * PLACEHOLDER, no enoders on Monolith atm
   */
  public double getRightEncoder(){
    return 0.0;
  }

  /**
   * reset the encoders to 0
   * PLACEHOLDER, no encoders on Monolith atm
   */
  public void resetEncoders(){}

  public DifferentialDrive getDrive() {return null;}

}
