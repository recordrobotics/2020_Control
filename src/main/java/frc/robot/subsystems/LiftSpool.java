/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.RobotMap;
import frc.robot.commands.ControlSpool;

/**
 * Creates new instances of the lift spool motors
 */
public class LiftSpool extends SubsystemBase {
  public LiftSpool() {
    this.setDefaultCommand(new ControlSpool());
  }

  private WPI_VictorSPX robotSpoolMotorLeft = new WPI_VictorSPX(RobotMap.spoolLiftLeftMotor);
  private WPI_VictorSPX robotSpoolMotorRight = new WPI_VictorSPX(RobotMap.spoolLiftRightMotor);

  /**
   * Sets the left motor to run at the same speed as the right motor, then sets
   * the right motor to run at speed v
   * 
   * @param v the speed at which the motors are set to run
   */
  public void MoveSpool(double v) {
    robotSpoolMotorLeft.follow(robotSpoolMotorRight);
    robotSpoolMotorRight.set(ControlMode.PercentOutput, v);
  }
}
