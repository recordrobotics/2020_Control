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
import frc.robot.control.XboxJoystick;

public class ControlAcquisition extends Command {

    private double acqSpeed = 0.1;
    private double tiltSpeed = 0.5;

    public ControlAcquisition() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.acq);
    }

    boolean inputPosition = true; //true is up, false is down

    private void controlAcq() {
        //control the acqusition wheels
       
        if (OI.getXboxButtonState(acqButton)){
            Robot.acq.moveAcq(acqSpeed);
         
        } else {
            Robot.acq.moveAcq(0);
        }
    }

    private void controlTilt(){
        //control the tilting system
        if (!Robot.acq.getTopLimit() && inputPosition) {
            Robot.acq.moveTilt(tiltSpeed);
        }
        else if (!Robot.acq.getBottomLimit() && !inputPosition) {
            Robot.acq.moveTilt(-tiltSpeed);
        }
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }
    boolean prevButton = false;
    String toggleButton = "A";
    String acqButton = "LT";

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //control the toggle, this will invert inputPosition when "A" is pressed
        if (!prevButton && OI.getXboxButtonState(toggleButton)) {
            inputPosition = !inputPosition;
        }

        controlAcq();
        //controlTilt();

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