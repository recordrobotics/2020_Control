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
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveMonolith extends DriveTrain {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Spark frontRight = new Spark(RobotMap.driveFrontRightPortMonolith);
  Spark backRight = new Spark(RobotMap.driveBackRightPortMonolith);
  Spark frontLeft = new Spark(RobotMap.driveFrontLeftPortMonolith);
  Spark backLeft = new Spark(RobotMap.driveBackLeftPortMonolith);

  //voltage values for each motor. Should probably all be the same!
  private double frontLeftVoltage = 11.5;
  private double frontRightVoltage = 11.5;
  private double backLeftVoltage = 11.5;
  private double backRightVoltage = 11.5;

  public DriveMonolith(){
    //set and enable the voltages of the motors
    frontLeft.enableVoltageCompensation(true);
    backLeft.enableVoltageCompensation(true);
    frontRight.enableVoltageCompensation(true);
    backRight.enableVoltageCompensation(true);

    frontLeft.setVoltage(frontLeftVoltage);
    backLeft.setVoltage(backLeftVoltage);
    frontRight.setVoltage(frontRightVoltage);
    backRight.setVoltage(backRight);
  }

  public void moveLeftWheels(double amount){
    frontLeft.set(-amount);
    backLeft.set(-amount);
  }


  public void moveRightWheels(double amount){
    frontRight.set(amount);
    backRight.set(amount);
  }

  public double getLeftEncoder(){
    return 0.0;
  }

  public double getRightEncoder(){
    return 0.0;
  }

  public void resetEncoders(){}

  public DifferentialDrive getDrive() {return null;}

}
