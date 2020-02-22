/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import frc.robot.RobotMap;

//If this is throwing an error - you need to install ctre Pheonix stuff, it's a pain, sorry :(
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive2020 extends DriveTrain {

    WPI_VictorSPX frontLeft = new WPI_VictorSPX(2);
    WPI_VictorSPX frontRight = new WPI_VictorSPX(1);
    WPI_VictorSPX backLeft = new WPI_VictorSPX(4);
    WPI_VictorSPX backRight = new WPI_VictorSPX(3);

    Encoder rightEnc = new Encoder(0, 1);
    Encoder leftEnc = new Encoder(2, 3);
    double ticksPerRotation = 20 * 10.71;
    double wheelCirc = 6 * Math.PI;

    private DifferentialDrive drive = new DifferentialDrive(frontLeft, frontRight);

    public Drive2020(){
        backRight.follow(frontRight);
        backLeft.follow(frontLeft);

        rightEnc.setDistancePerPulse(wheelCirc / ticksPerRotation);
        leftEnc.setDistancePerPulse(wheelCirc / ticksPerRotation);
    }

    public void moveLeftWheels(double amount){
        frontLeft.set(ControlMode.PercentOutput, amount);
    }

    public void moveRightWheels(double amount){
        frontRight.set(ControlMode.PercentOutput, -amount);
    }

    public double getRightEncoder(){
        return rightEnc.getDistance();
    }

    public double getLeftEncoder(){
        return -leftEnc.getDistance();
    }

    public DifferentialDrive getDrive() {return drive;}

    public void resetEncoders(){
        leftEnc.reset();
        rightEnc.reset();
    }
}