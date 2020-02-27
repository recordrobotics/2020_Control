/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.OI;
//import frc.robot.control.XboxJoystick;

public class ControlAcquisition extends Command {

    private double acqSpeed = -0.5;
    private double upperAngle = 5, lowerAngle = 0;

    public ControlAcquisition() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.acq);
    }

    private void controlAcq() {
        //control the acqusition wheels
       
        if (OI.getXboxButtonState(acqButton)){
            Robot.acq.moveAcq(acqSpeed);
        } else if (OI.getXboxButtonState(reverseButton)){
            Robot.acq.moveAcq(-acqSpeed);
        } else {
            Robot.acq.moveAcq(0);
        }

        if (OI.getXboxButtonState("RB")){
            Robot.acq.moveTilt(Robot.acq.getTiltSpeed());
        } else if (OI.getXboxButtonState("LB")){
            Robot.acq.moveTilt(-Robot.acq.getTiltSpeed());
        } else {
            Robot.acq.moveTilt(0);
        }
    }

    private void controlTilt(){
        boolean tiltPosition = Robot.acq.getTiltPosition();

        if (!tiltPosition && Robot.acq.getAngle() < upperAngle){
            Robot.acq.moveTilt(-Robot.acq.getTiltSpeed());
        } else if (tiltPosition && Robot.acq.getAngle() > lowerAngle){
            Robot.acq.moveTilt(Robot.acq.getTiltSpeed());
        } else {
            Robot.acq.moveTilt(0);
        }
    }
    
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }
    boolean prevButton = false;
    String toggleButton = "A";
    String reverseButton = "A";
    String acqButton = "LT";

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //control the toggle, this will invert inputPosition when "A" is pressed
        /*
        if (prevButton != OI.getXboxButtonState(toggleButton) && OI.getXboxButtonState(toggleButton)) {
            Robot.acq.setTiltPosition(!Robot.acq.getTiltPosition());
        }
        */
        controlAcq();
        //controlTilt();

        SmartDashboard.putNumber("tilt angle", Robot.acq.getAngle());

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