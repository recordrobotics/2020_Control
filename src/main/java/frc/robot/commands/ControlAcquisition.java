/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.OI;

public class ControlAcquisition extends Command {

    private double acqSpeed = 0.5;
    private double tiltSpeed = 0.5;

    public ControlAcquisition() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.acq);
    }

    public void controlAquire(boolean spin) {
        if (spin) {
            Robot.acq.moveAcq(acqSpeed);
        }
        else {
             Robot.acq.moveAcq(0);
        }
    }
    
    DigitalInput io_limitTop = null;
    DigitalInput io_limitBottom = null;
    
    boolean limitSwitchTop = false;
    boolean limitSwitchBottom = false;

    private void setLimitSwitches(){
        limitSwitchBottom = io_limitBottom.get();
        limitSwitchTop = io_limitTop.get();
    }

    boolean inputPosition = true; //true is up, false is down

    public void setAcqPos() {
        //control the acqusition wheels
        if (OI.getXboxButtonState(acqButton)){
            Robot.acq.moveAcq(acqSpeed);
        } else {
            Robot.acq.moveAcq(0);
        }
        /*
        //control the tilting system
        if (!limitSwitchTop && inputPosition) {
            Robot.acq.moveTilt(tiltSpeed);
        }
        else if (!limitSwitchBottom && !inputPosition) {
            Robot.acq.moveTilt(-tiltSpeed);
        } else {
            Robot.acq.moveTilt(0);
        }
        */
        //TODO RESTORE LIMIT SWITCH BASED
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    boolean prevButton = false;
    String toggleButton = "A";
    String acqButton = "LT";

    @Override
    protected void execute() {
        //setLimitSwitches();

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