/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


import frc.robot.commands.ControlSpool;


public class LiftSpool extends Subsystem {
  private WPI_VictorSPX robotSpoolMotorLeft = new WPI_VictorSPX(11);
  private WPI_VictorSPX robotSpoolMotorRight = new WPI_VictorSPX(10);
  
  public void MoveSpool(double v){
    robotSpoolMotorLeft.follow(robotSpoolMotorRight);
    robotSpoolMotorRight.set(ControlMode.PercentOutput, v);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new ControlSpool());
  }
}
