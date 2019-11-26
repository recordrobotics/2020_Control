/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoTurn extends Command {
    //declare variables
    double inputAngle; //number of degrees to turn
    double initAngle;   //angle when command is started
    double targetAngle; //angle robot is trying to be at
    double precision = 1;

    //constructor
  public AutoTurn(double angle) {
    // Use requires() here to declare subsystem dependencies
    if (Robot.driveTrain != null){
      requires(Robot.driveTrain);
    }
    //assigns argument to variable
    this.inputAngle = angle; //input should be an angle from -180 to positive 180
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    initAngle = Robot.gyro.getDeg(); //is a value representing the angle the robot is at
    targetAngle = initAngle + inputAngle; //sets the target angle, there is a risk of the angle being less than 360 or greater than 0
    System.out.println("init autoturn, target: " + targetAngle);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println(Robot.gyro.getDeg());
    double increment = 0.5; //the amount that the robot will turn every execution
    double leftAmount;
    double rightAmount;

    //determine which way to turn the wheels
    boolean turnRight;

    if (targetAngle > initAngle){
      turnRight = false;
    } else {
      turnRight = true;
    }

    if (turnRight){
      leftAmount = increment;
      rightAmount = -increment;
    } else {
      leftAmount = -increment;
      rightAmount = increment;
    }

    //move the robot around it's own axis
    Robot.driveTrain.moveLeftWheels(leftAmount);
    Robot.driveTrain.moveRightWheels(rightAmount);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (Robot.gyro.getDeg() > targetAngle - precision && Robot.gyro.getDeg() < targetAngle + precision){
        System.out.println("Done turing at angle: " + Robot.gyro.getDeg());
        return true;
    } else{
        return false;
    }
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
