/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class Flywheel extends Subsystem {

    public abstract void moveWheel(double v);
	public abstract double getVoltage();
	public abstract double getVelocity();

	public void initDefaultCommand() {
  		setDefaultCommand(new ControlFlywheel());
	}
}
