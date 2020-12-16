/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.CamStream;

/**
 * Class meant to switch cameras at the press of a button Written frantically
 * just before competition, function questionably understood USE AT OWN RISK
 */
public class CamControl extends CommandBase {

    private String switchButton = "Y";

    public CamControl() {
        addRequirements(Robot.camStream);
    }

    /** Called just before this Command runs the first time */
    @Override
    public void initialize() {
        Robot.camStream.setCamera(0);
    }

    private boolean prevButton = false;
    private int count = 0;

    /** Called repeatedly when this Command is scheduled to run */
    @Override
    public void execute() {

        if (OI.getXboxButtonState(switchButton) && (OI.getXboxButtonState(switchButton) != prevButton)) {
            count++;
            Robot.camStream.setCamera(count % 2);
        }

        prevButton = OI.getXboxButtonState(switchButton);
    }

    /** Make this return true when this Command no longer needs to run execute() */
    @Override
    public boolean isFinished() {
        return false;
    }
}
