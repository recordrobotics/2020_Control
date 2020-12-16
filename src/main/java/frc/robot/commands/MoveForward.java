/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class MoveForward extends CommandBase {

    private double distance;
    /** distance to travel in INCHES */
    /**
     * Called when another command which requires one or more of the same subsystems
     * is scheduled to run
     */
    private double speed;

    public MoveForward(double dist, double sp) {
        distance = dist;
        speed = sp;
    }

    public MoveForward() {
        distance = Robot.rangeFinder.getDistance();
        speed = 0.7;
    }

    /** Called just before this Command runs the first time */
    @Override
    public void initialize() {
        /** reset the encoders */
        Robot.driveTrain.resetEncoders();
        System.out.println("command move init");
    }

    /** Called repeatedly when this Command is scheduled to run */
    @Override
    public void execute() {
        Robot.driveTrain.moveLeftWheels(speed);
        Robot.driveTrain.moveRightWheels(speed);
    }

    /** Make this return true when this Command no longer needs to run execute() */
    @Override
    public boolean isFinished() {
        return Robot.driveTrain.getRightEncoder() >= distance || Robot.driveTrain.getLeftEncoder() >= distance;
    }

    /** Called once after isFinished returns true */
    @Override
    public void end(boolean intterupted) {
        Robot.driveTrain.moveLeftWheels(0);
        Robot.driveTrain.moveRightWheels(0);
    }
}