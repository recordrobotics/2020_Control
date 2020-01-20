/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;



//If this is throwing an error - you need to install ctre Pheonix stuff, it's a pain, sorry :(
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;



/*
* Drive Train for Monty
*/
public class DriveMonty extends DriveTrain {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  
  //If this is throwing an error - you need to install ctre Pheonix stuff, it's a pain, sorry :(
  WPI_VictorSPX frontRight = new WPI_VictorSPX(RobotMap.driveFrontRightPortMonty);
  WPI_VictorSPX backRight = new WPI_VictorSPX(RobotMap.driveBackRightPortMonty);
  WPI_VictorSPX frontLeft = new WPI_VictorSPX(RobotMap.driveFrontLeftPortMonty);
  WPI_VictorSPX backLeft = new WPI_VictorSPX(RobotMap.driveBackLeftPortMonty);

  public DriveMonty(){
    backRight.follow(frontRight);
    backLeft.follow(frontLeft);
  }


  public void moveLeftWheels(double amount){
    frontLeft.set(ControlMode.PercentOutput, amount);
  }


  public void moveRightWheels(double amount){
    frontRight.set(ControlMode.PercentOutput, amount);
  }


  public double getLeftEncoder(){
    return 0.0;
  }

  public double getRightEncoder(){
    return 0.0;
  }
  
  public DifferentialDrive getDrive() {return null;}

}
