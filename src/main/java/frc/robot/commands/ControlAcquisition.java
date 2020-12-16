/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
/**import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;*/
import frc.robot.Robot;
import frc.robot.OI;


public class ControlAcquisition extends CommandBase {
    /**
     * acqSpeed This is how fast the aquisition spins.
     * uperAngle lowerAngle UNUSED.
     */
    private double acqSpeed = -0.5;
    private double upperAngle = 5, lowerAngle = 0;
    /**
     * Creates a ControlAcquisition object.
     */
    public ControlAcquisition() {
        /** Use requires() here to declare subsystem dependencies*/
        addRequirements(Robot.acq);
    }
    /**
     * Method to spin and tilt acquisition.
     */
    private void controlAcq() {
        //control the acqusition wheels
        /**
         * IF: if the aquisition button is pressed, move the aquisition by acqSpeed.
         * ELSE IF: if the reverse button is pressed, move the aquisition by acqSpeed in the other direction.
         * ELSE: the aquisition shouldn't spin if either button is not pressed.
         */
        if (OI.getXboxButtonState(acqButton)){
            Robot.acq.moveAcq(acqSpeed);
        } else if (OI.getXboxButtonState(reverseButton)){
            Robot.acq.moveAcq(-acqSpeed);
        } else {
            Robot.acq.moveAcq(0);
        }
        /**
         * IF: if the right bumper is pressed, tilt the aquisition up by acq.getTiltSpeed().
         * ELSE IF: if the left bumper is pressed, tilt the aquisition down by acq.getTiltSpeed().
         * ELSE: the aquisition shouldn't tilt if either bumper is not pressed.
         */
        if (OI.getXboxButtonState("RB")){
            Robot.acq.moveTilt(Robot.acq.getTiltSpeed());
        } else if (OI.getXboxButtonState("LB")){
            Robot.acq.moveTilt(-Robot.acq.getTiltSpeed());
        } else {
            Robot.acq.moveTilt(0);
        }
    }

    /** Called just before this Command runs the first time*/
    

    /**
     * @param prevButton Get whether toggleButton has just been pressed to avoid the aquisition being raised multiple times.
     * @param toggleButton Which button raises the tilt of the aquisition.
     * @param reverseButton Which button lowers the tilt of the aquisition.
     * @param acqButton Which button spins the aquisition.
     */
    boolean prevButton = false;
    String toggleButton = "A";
    String reverseButton = "A";
    String acqButton = "LT";

    /** Called repeatedly when this Command is scheduled to run*/
    @Override
    public void execute() {
        /**control the toggle, this will invert inputPosition when "A" is pressed*/
        /*
        if (prevButton != OI.getXboxButtonState(toggleButton) && OI.getXboxButtonState(toggleButton)) {
            Robot.acq.setTiltPosition(!Robot.acq.getTiltPosition());
        }
        */
        controlAcq();
        /**controlTilt();*/

        /**SmartDashboard.putNumber("tilt angle", Robot.acq.getAngle());*/

        prevButton = OI.getXboxButtonState(toggleButton);
    }

    /** Make this return true when this Command no longer needs to run execute()*/
    @Override
    public boolean isFinished() {
        return false;
    }

    /** Called once after isFinished returns true*/
    

/**
*     Called when another command which requires one or more of the same
*     subsystems is scheduled to run
*/
    
}