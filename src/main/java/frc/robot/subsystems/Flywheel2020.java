/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ControlFlywheel;

public class Flywheel2020 extends Subsystem {

    private WPI_VictorSPX flywheelMotor = new WPI_VictorSPX (RobotMap.flywheelMotorPort);
    private double targetVoltage = 11.0;

    public Flywheel2020(){
        flywheelMotor.enableVoltageCompensation(true);
        flywheelMotor.setVoltage(targetVoltage);
    }
    
    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ControlFlywheel());
    }

    public void moveWheel(double v){
        flywheelMotor.set(ControlMode.PercentOutput, v);
    }
    
    public double getVoltage(){
        return flywheelMotor.getMotorOutputVoltage();
    }

}
