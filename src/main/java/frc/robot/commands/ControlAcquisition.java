/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ControlAcquisition extends Command {

    private double acqSpeed = 0.6;
    private double tiltSpeed = 0.6;

    public void ExampleCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.m_subsystem);
    }

    public void controlAquire(boolean spin) {
        if (spin) {
            Robot.acq.moveAcq(acqSpeed);
        }
        else {
             Robot.acq.moveAcq(0);
        }
    }

    private boolean isAcqUp = false;

    public void controlTilt(boolean spin) {
        if (spin && isAcqUp) {
            Robot.acq.moveTilt(tiltSpeed);
            isAcqUp = true;
        }
        else {
            Robot.acq.moveTilt(0);
            isAcqUp = false;
        }
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
