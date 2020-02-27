/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class MoveToRange extends Command {

    private double distance, speed = 0.3;
    private double tolerance = 3; //inches
    private double range;

    public MoveToRange(double dist){
        distance = dist;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override 
    protected void execute() {
        //Non PID implementation for now
        //TODO use PID controller
        range = Robot.rangeFinder.getDistance();

        int direction = 1;
        if (range < distance){
            direction = -1;
        }

        Robot.driveTrain.moveLeftWheels(speed * direction);
        Robot.driveTrain.moveRightWheels(speed * direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if (range < distance + tolerance || range > distance - tolerance){
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.driveTrain.moveLeftWheels(0);
        Robot.driveTrain.moveRightWheels(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}