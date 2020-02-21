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
import edu.wpi.first.wpilibj.Encoder;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

public class Acquisition2020 extends Subsystem {

    private WPI_VictorSPX acquireMotor = new WPI_VictorSPX(RobotMap.acquireMotorPort);
    private WPI_VictorSPX tiltMotor = new WPI_VictorSPX(RobotMap.tiltMotorPort);

    DigitalInput limitTop;
    DigitalInput limitBottom;

    Encoder acqEncoder = new Encoder(5, 30); //30 is placeholder value. Encoder only needs one port?

    public Acquisition2020(){
        //limitTop = new DigitalInput(3);
        //limitBottom = new DigitalInput(3);
        acqEncoder.reset();
    }

    public void moveAcq(double v) {
        acquireMotor.set(ControlMode.PercentOutput, v);
    }

    public void moveTilt(double v) {
        tiltMotor.set(ControlMode.PercentOutput, v);
    }

    public boolean getTopLimit(){
        return limitTop.get();
    }

    public boolean getBottomLimit(){
        return limitBottom.get();
    }
    
    public double getAngle(){
        return acqEncoder.get() * 360/174.9;
    }
    
    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ControlAcquisition());
    }
}