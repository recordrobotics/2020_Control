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

public class Drive2020 extends DriveTrain {

    WPI_VictorSPX left = new WPI_VictorSPX(RobotMap.driveLeft2020);
    WPI_VictorSPX right = new WPI_VictorSPX(RobotMap.driveRight2020);

    public void moveLeftWheels(double amount){
        left.set(ControlMode.PercentOutput, amount);
    }

    public void moveRightWheels(double amount){
        right.set(ControlMode.PercentOutput, amount);
    }

    public double getRightEncoder(){
        return 0.0;
    }

    public double getLeftEncoder(){
        return 0.0;
    }
}