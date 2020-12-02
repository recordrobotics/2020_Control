/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

/**import frc.robot.RobotMap;*/

/**If this is throwing an error - you need to install ctre Pheonix stuff, it's a pain, sorry :(*/
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

public class Drive2020 extends DriveTrain {

    /**
     * Objects defining the motor controller objects.
     * Victor SPX for the 2020 robot
     */
    WPI_VictorSPX frontLeft = new WPI_VictorSPX(2);
    WPI_VictorSPX frontRight = new WPI_VictorSPX(1);
    WPI_VictorSPX backLeft = new WPI_VictorSPX(4);
    WPI_VictorSPX backRight = new WPI_VictorSPX(3);

    /**
     * Objects for left and right encoders
     */
    Encoder rightEnc = new Encoder(RobotMap.rightDriveEncoder[0], RobotMap.rightDriveEncoder[1]);
    Encoder leftEnc = new Encoder(RobotMap.leftDriveEncoder[0], RobotMap.leftDriveEncoder[1]);
    double ticksPerRotation = 20 * 10.71;
    double wheelCirc = 6 * Math.PI;

    private double frontLeftVoltage = 11.5;
    private double frontRightVoltage = 11.5;
    private double backLeftVoltage = 11.5;
    private double backRightVoltage = 11.5;

    /**
     * Library Differential Drive object
     */
    private DifferentialDrive drive = new DifferentialDrive(frontLeft, frontRight);

/**
*    setting to false may help with crash, but ya know... saftey!? I don't exactly know what this turns on/off...
*    alternative solution: see if chaning the timeout value using motor.setExpiration​(seconds) will fix it
*/
    private boolean useSafety = false; 
    private double timeout = 600;  /**600s, 10min*/
/**
*    setting to false may help with crash, but ya know... saftey!? I don't exactly know what this turns on/off...
*    alternative solution: see if chaning the timeout value using motor.setExpiration​(seconds) will fix it
*/

    public Drive2020(){
        /**set the back motors to use the same speeds as the front ones*/
        backRight.follow(frontRight);
        backLeft.follow(frontLeft);

        /**Set the encoders to automatically convert ticks to distance*/
        rightEnc.setDistancePerPulse(wheelCirc / ticksPerRotation);
        leftEnc.setDistancePerPulse(wheelCirc / ticksPerRotation);

        /**Set saftey system*/
        frontLeft.setSafetyEnabled(useSafety);
        backLeft.setSafetyEnabled(useSafety);
        frontRight.setSafetyEnabled(useSafety);
        backRight.setSafetyEnabled(useSafety);

        /**set timeout*/
        frontLeft.setExpiration(timeout);
        backLeft.setExpiration(timeout);
        frontRight.setExpiration(timeout);
        backRight.setExpiration(timeout);

        //set and enable the voltages of the motors
        frontLeft.enableVoltageCompensation(true);
        backLeft.enableVoltageCompensation(true);
        frontRight.enableVoltageCompensation(true);
        backRight.enableVoltageCompensation(true);

        frontLeft.setVoltage(frontLeftVoltage);
        backLeft.setVoltage(backLeftVoltage);
        frontRight.setVoltage(frontRightVoltage);
        backRight.setVoltage(backRightVoltage);
    }

    /**
     * @param amount amount to move the wheel. Depends on contex, is usually percent output
     */
    public void moveLeftWheels(double amount){
        frontLeft.set(ControlMode.PercentOutput, amount);
    }

    /**
     * @param amount amount to move the wheel. Depends on contex, is usually percent output
     */
    public void moveRightWheels(double amount){
        frontRight.set(ControlMode.PercentOutput, -amount);
    }

   /**
   * @return The Value of the right encoder in INCHES
   */   
    public double getRightEncoder(){
        return rightEnc.getDistance();
    }

    /**
     * @return The Value of the left encoder in INCHES
     */
    public double getLeftEncoder(){
        return -leftEnc.getDistance();
    }

    public DifferentialDrive getDrive() {return drive;}

    /**
     * Reset both encoders to zero
     */
    public void resetEncoders(){
        leftEnc.reset();
        rightEnc.reset();
    }
}