/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;
import frc.robot.control.PID;

public class MoveToRange extends CommandBase {
    /**
     * distance The current distance from the target. speed How fast the robot will
     * move. tolerance Total tolerance when moving to the location. range The range
     * the robot has to move to. pid Creates a PID Controller. kp, ki, kd Components
     * of PID Controller.
     */
    private double distance, speed = 0.25;
    private double tolerance = 3;
    /** inches */
    /**
     * addSequential(new TurnToAngle(-180+gyroAngle)); addSequential(new
     * MoveForward((120-firingDistance) + 48, 0.5));
     */
    private double range;

    private PID pid;
    private double kp = 0.1, ki = 0, kd = 0;

    /**
     * MoveToRange() Moves the robot to the set location.
     * 
     * @param dist Total distance to travel.
     */
    public MoveToRange(double dist) {
        distance = dist;
        pid = new PID(kp, ki, kd, dist);
    }

    /** Called just before this Command runs the first time */
    @Override
    public void initialize() {
    }

    /** Called repeatedly when this Command is scheduled to run */
    @Override
    public void execute() {
        range = Robot.rangeFinder.getDistance();

        int direction = 1;
        if (range < distance) {
            direction = -1;
        }

        /** speed = pid.control(range); */
        speed = 0.125;
        if (range > distance) {
            speed *= (range / distance);
        } else if (range < distance) {
            speed *= (distance / range);
        }

        if (speed > 0.35)
            speed = 0.35;
        if (speed < -0.35)
            speed = -0.35;

        Robot.driveTrain.moveLeftWheels(speed * -direction);
        Robot.driveTrain.moveRightWheels(speed * -direction);
    }

    /** Make this return true when this Command no longer needs to run execute() */
    @Override
    public boolean isFinished() {
        if (range < distance + tolerance && range > distance - tolerance) {
            return true;
        }
        return false;
    }

    /** Called once after isFinished returns true */
    @Override
    public void end(boolean intterupted) {
        Robot.driveTrain.moveLeftWheels(0);
        Robot.driveTrain.moveRightWheels(0);
        System.out.println("Moved TO Range, Target: " + distance + ", Actual: " + Robot.rangeFinder.getDistance());
    }
}