/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new MySpecialCommand());
  }

  private DoubleSolenoid grabSolenoid = new DoubleSolenoid(2, 3);
  private DoubleSolenoid extendSolenoid = new DoubleSolenoid(0, 1);

  public void moveGrabber(DoubleSolenoid.Value v){
      grabSolenoid.set(v);
  }

  public void moveExtender(DoubleSolenoid.Value v){
      extendSolenoid.set(v);
  }

}