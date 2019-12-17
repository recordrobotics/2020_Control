/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.GrabberControl;
import edu.wpi.first.wpilibj.Spark;

public class GrabberMonolith extends Grabber {
  
  private DoubleSolenoid grabSolenoid = new DoubleSolenoid(2, 3);
  private DoubleSolenoid extendSolenoid = new DoubleSolenoid(0, 1);

  private Spark leftMotor = new Spark(5);
  private Spark rightMotor = new Spark(6);

  public void moveGrabber(DoubleSolenoid.Value v){
      grabSolenoid.set(v);
  }

  public void moveExtender(DoubleSolenoid.Value v){
      extendSolenoid.set(v);
  }

  public void moveLeftMotor(double v){
    System.out.println("Left Grab");
    leftMotor.set(v);
  }

  public void moveRightMotor(double v){
    System.out.println("Right Grab");
    rightMotor.set(v);
  }
}