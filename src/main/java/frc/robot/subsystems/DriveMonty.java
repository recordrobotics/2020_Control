/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;



/**If this is throwing an error - you need to install ctre Pheonix stuff, it's a pain, sorry :(*/
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/*
* Drive Train for Monty
*/
public class DriveMonty extends DriveTrain {

  /**If this is throwing an error - you need to install ctre Pheonix stuff, it's a pain, sorry :(*/
  WPI_VictorSPX frontRight = new WPI_VictorSPX(RobotMap.driveFrontRightPortMonty);
  WPI_VictorSPX backRight = new WPI_VictorSPX(RobotMap.driveBackRightPortMonty);
  WPI_VictorSPX frontLeft = new WPI_VictorSPX(RobotMap.driveFrontLeftPortMonty);
  WPI_VictorSPX backLeft = new WPI_VictorSPX(RobotMap.driveBackLeftPortMonty);

  /**
   * Constructor
   * Sets the back right/left motors to always have the same speed as the front right/left motors
   */
  public DriveMonty(){
    backRight.follow(frontRight);
    backLeft.follow(frontLeft);
  }

  /**
   * @param amount percent output
   * Set the speed of the left motors
   */
  public void moveLeftWheels(double amount){
    frontLeft.set(ControlMode.PercentOutput, amount);
  }

  /**
   * @param amount percent output
   * Set the speed of the left motors
   */
  public void moveRightWheels(double amount){
    frontRight.set(ControlMode.PercentOutput, amount);
  }

  /**
   * @return value of left encoder
   * PLACEHOLDER, no encoders set up
   */
  public double getLeftEncoder(){
    return 0.0;
  }

  /**
   * @return value of right encoder
   * PLACEHOLDER, no encoders set up
   */
  public double getRightEncoder(){
    return 0.0;
  }
  
  /**
   * @return the differential drive object
   * Placeholder! no differential drive object used here
   */
  public DifferentialDrive getDrive() {return null;}

  /**
   * reset the encoders
   * PLACEHOLDER, no encoders set up
   */
  public void resetEncoders(){}
}
