/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMTalonFX;
import frc.robot.RobotMap;
import frc.robot.commands.ControlFlywheel;

public class Flywheel2020 extends Flywheel {
    /**
     * flywheelMotor Creates a motor object for the flywheel motor.
     * targetVoltage The target voltage of the flywheel.
     */
    private int falcon500port = 0;
    private PWMTalonFX flywheelMotor = new PWMTalonFX(falcon500port);
    
    private double targetVoltage = 11.5;

    /**
     * Creates an Object for the flywheel class.
     */
    public Flywheel2020(){
        flywheelMotor.setInverted(true);
        //flywheelMotor.enableVoltageCompensation(true);
        //flywheelMotor.setVoltage(targetVoltage);

        //flywheelEncoder = new Encoder();
    }
    
    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ControlFlywheel());
    }
    /**
     * Spins the flywheel motor.
     * @param v The speed at which the flywheel motor turns.
     */
    public void moveWheel(double v){
        flywheelMotor.set(v);
    }
    /**
     * Returns the flywheel's voltage output.
     * @return The flywheel's voltage output.
     */
    public double getVoltage(){
        //return flywheelMotor.getMotorOutputVoltage();
        return -1;
    }

    public double getVelocity(){
        double convFactor = ((6 * Math.PI * 0.0254)/2048) * 10 * 0.25;
        return -flywheelMotor.getSpeed();
    }

}
