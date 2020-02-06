/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.OI;

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
    /*
    if the angle is up and should be up:
        do nothing
    if the angle is up and should be down:
        move until
    if the angle is down and should be up:
        move until
    if the angle is down and should be down:
        do nothing
    */
    boolean limitSwitchTop = true;
    boolean limitSwitchBottom = false;
    boolean inputPosition = true; //true is up, false is down
    double v = 0.5;

    public void setAcqPos() {
        if (!limitSwitchTop && inputPosition) {
            Robot.acq.moveTilt(v);
        }
        else if (!limitSwitchBottom && !inputPosition) {
            Robot.acq.moveTilt(-v);
        }
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    boolean prevButton = false;
    String toggleButton = "A";

    @Override
    protected void execute() {
        if (!prevButton && OI.getXboxButtonState(toggleButton)) {
            inputPosition = !inputPosition;
        }
        setAcqPos();

        prevButton = OI.getXboxButtonState(toggleButton);
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