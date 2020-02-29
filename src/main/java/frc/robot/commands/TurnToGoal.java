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
import java.util.ArrayList;

/**
 * An example command.  You can replace me with your own command.
 */
public class TurnToGoal extends Command {
  
  private double targetAngle = 0;
  private double tolerance = 3; //degrees
  private double angle;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("init");
  }

  private ArrayList<Double> angleData = new ArrayList<Double>();

  private double smoothData(){
    angleData.add(angle);
    if (angleData.size() > 9){
      angleData.remove(0);
    }

    if(angleData.size() == 0){
      return -1;
    }

    double average = 0;
    for (int i = 0; i < angleData.size(); i++){
      average += angleData.get(i);
    }
    average /= angleData.size();

    return average;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override 
  protected void execute() {
    angle = SmartDashboard.getNumber("Angle to Goal", 0);
    angle = smoothData();

    double speed = 0.3;

    if (angle > 0){
        speed *= -1; 
    }

    Robot.driveTrain.moveRightWheels(speed);
    Robot.driveTrain.moveLeftWheels(-speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if ((angle > targetAngle - tolerance || angle < targetAngle + tolerance) && angle != -1.0){
        return true;
    }
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
