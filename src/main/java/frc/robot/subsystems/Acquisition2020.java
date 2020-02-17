/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ControlAcquisition;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

public class Acquisition2020 extends Subsystem {

    private WPI_VictorSPX acquireMotor = new WPI_VictorSPX(8);
    private WPI_VictorSPX tiltMotor = new WPI_VictorSPX(7);

    DigitalInput limitTop;
    DigitalInput limitBottom;

    public Acquisition2020(){
        //limitTop = new DigitalInput(3);
        //limitBottom = new DigitalInput(3);
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

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ControlAcquisition());
    }
}