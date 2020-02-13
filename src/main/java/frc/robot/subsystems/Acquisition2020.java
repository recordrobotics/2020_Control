/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ControlAcquisition;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

public class Acquisition2020 extends Subsystem {

    //TODO set motor channels
    private WPI_VictorSPX acquireMotor = new WPI_VictorSPX(-1);
    private WPI_VictorSPX tiltMotor = new WPI_VictorSPX(-1);

    public void moveAcq(double v) {
        acquireMotor.set(ControlMode.PercentOutput, v);
    }

    public void moveTilt(double v) {
        tiltMotor.set(ControlMode.PercentOutput, v);
    }

    @Override
    public void initDefaultCommand() {
        //setDefaultCommand(new ControlAcquisition());
    }
}