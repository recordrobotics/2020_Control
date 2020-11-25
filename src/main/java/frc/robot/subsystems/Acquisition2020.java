/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ControlAcquisition;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

public class Acquisition2020 extends Subsystem {

    private WPI_VictorSPX acquireMotor = new WPI_VictorSPX(RobotMap.acquireMotorPort);
    private WPI_VictorSPX tiltMotor = new WPI_VictorSPX(RobotMap.tiltMotorPort);
    private double aquireMotorVoltage = 11.5;
    private double tiltMotorVoltage = 11.5;
    DigitalInput tiltLimit;

    //AnalogInput encoderInput = new AnalogInput(0);
    //AnalogEncoder acqEncoder = new AnalogEncoder(encoderInput);

    private double tiltSpeed = 0.5;
    boolean tiltPosition = true; //true is up, false is down

    public Acquisition2020(){
        //limitTop = new DigitalInput(3);
        //limitBottom = new DigitalInput(3);
        tiltLimit = new DigitalInput(7);
        //acqEncoder.reset();
    }

    public double getTiltSpeed(){
        return tiltSpeed;
    }

    public boolean getTiltPosition() {
        return tiltPosition;
    }
    
    public void setTiltPosition(boolean pos){
        tiltPosition = pos;
    }

    public void moveAcq(double v) {
        acquireMotor.set(ControlMode.PercentOutput, v);
    }

    public void moveTilt(double v) {
        tiltMotor.set(ControlMode.PercentOutput, v);
    }
     
    public boolean getTiltLimit(){
        return tiltLimit.get();
     }
     /*
    public double getAngle(){
        return acqEncoder.get() * 360/174.9;
    }
    */
    public boolean isAcqOn(){
        return acquireMotor.get() > 0;
    }
    
    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ControlAcquisition());
    }
    public double getAcquireVoltage(){
        return acquireMotor.getMotorOutputVoltage();
    }
    public double getTiltVoltage(){
        return tiltMotor.getMotorOutputVoltage();
    }
}