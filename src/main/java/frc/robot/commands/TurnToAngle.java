/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.control.PID;

import java.util.ArrayList;

public class TurnToAngle extends CommandBase {
  /**
   * targetAngle Angle the robot has to face. tolerance The error allowed in
   * turning. angle Current angle. speed How fast the robot should turn. angleData
   * ArrayList to store data on the current angle. pid Creates a PID controller.
   * kp, ki, kd Part of PID controller.
   */
  private double targetAngle = 0;
  private double tolerance = 3;
  /** degrees */
  /**
   * Called when another command which requires one or more of the same subsystems
   * is scheduled to run
   */
  private double angle;
  double speed = 0.15;

  private ArrayList<Double> angleData = new ArrayList<Double>();
  private PID pid;
  private double kp = 0.2, ki = 0, kd = 0;

  /**
   * Creates a TurnToAngle object.
   * 
   * @param a The current target angle.
   */
  public TurnToAngle(double a) {
    targetAngle = a;
  }

  /**
   * If TurnToAngle has no return value, the return value is 0.
   */
  public TurnToAngle() {
    this(0);
  }

  /** Called just before this Command runs the first time */
  @Override
  public void initialize() {
    System.out.println("init");
    pid = new PID(kp, ki, kd, 0);
  }

  /** Called repeatedly when this Command is scheduled to run */
  @Override
  public void execute() {
    angle = Robot.gyro.getDeg();
    /** angle = smoothData(); */

    /** speed = pid.control(angle); */

    if (angle < 0 && speed > 0)
      speed *= -1;
    if (angle > 0 && speed < 0)
      speed *= -1;

    if (speed > 0.3)
      speed = 0.3; /** saftey */
    /** speed = pid.control(angle); */
    if (speed < -0.3)
      speed = -0.3;

    Robot.driveTrain.moveRightWheels(speed);
    Robot.driveTrain.moveLeftWheels(-speed);
  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    if ((angle > targetAngle - tolerance && angle < targetAngle + tolerance) && angle != -1.0) {
      return true;
    }
    return false;
  }

  /** Called once after isFinished returns true */
  @Override
  public void end(boolean intterupted) {
    Robot.driveTrain.moveRightWheels(0);
    Robot.driveTrain.moveLeftWheels(0);
  }
}
