/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.RobotMap;
import frc.robot.commands.ControlFlywheel;

public class Flywheel2020 extends Flywheel {
    /**
     * flywheelMotor Creates a motor object for the flywheel motor. targetVoltage
     * The target voltage of the flywheel.
     */
    private WPI_VictorSPX flywheelMotor = new WPI_VictorSPX(RobotMap.flywheelMotorPort);
    private double targetVoltage = 11.0;

    /**
     * Creates an Object for the flywheel class.
     */
    public Flywheel2020() {
        setDefaultCommand(new ControlFlywheel());
        flywheelMotor.enableVoltageCompensation(true);
        flywheelMotor.setVoltage(targetVoltage);
    }

    /**
     * Spins the flywheel motor.
     * 
     * @param v The speed at which the flywheel motor turns.
     */
    public void moveWheel(double v) {
        flywheelMotor.set(ControlMode.PercentOutput, v);
    }

    /**
     * Returns the flywheel's voltage output.
     * 
     * @return The flywheel's voltage output.
     */
    public double getVoltage() {
        return flywheelMotor.getMotorOutputVoltage();
    }

}
