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

public class Flywheel2020 extends Subsystem {

    //TODO set port number
    private WPI_VictorSPX flywheelMotor = new WPI_VictorSPX(-1);

    @Override
    public void initDefaultCommand() {
        //init default command
    }

    public void moveWheel(double v){
        flywheelMotor.set(ControlMode.PercentOutput, v);
    }

}
