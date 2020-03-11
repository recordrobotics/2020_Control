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
import frc.robot.control.PID;

import java.util.ArrayList;

/**
 * An example command.  You can replace me with your own command.
 */
public class TurnToAngle extends Command {
  private double targetAngle = 0;
  private double tolerance = 3; //degrees
  private double angle;
  double speed = 0.15;

  private ArrayList<Double> angleData = new ArrayList<Double>();
  private PID pid;
  private double kp = 0.2, ki = 0, kd = 0;

  public TurnToAngle(double a){
    targetAngle = a;
  }

  public TurnToAngle(){
    this(0);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("init");
    pid = new PID(kp, ki, kd, 0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override 
  protected void execute() {
    angle = Robot.gyro.getDeg();
    //angle = smoothData();

    //speed = pid.control(angle);

    if (angle < 0 && speed > 0) speed *= -1;
    if (angle > 0 && speed < 0) speed *= -1;

    if (speed > 0.3) speed = 0.3; //saftey
    if (speed < -0.3) speed = -0.3;

    Robot.driveTrain.moveRightWheels(speed);
    Robot.driveTrain.moveLeftWheels(-speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if ((angle > targetAngle - tolerance && angle < targetAngle + tolerance) && angle != -1.0){
        return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.moveRightWheels(0);
    Robot.driveTrain.moveLeftWheels(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
