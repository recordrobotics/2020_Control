/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import java.io.*;

public class MaintainCourse extends Command {
  
  //PID parameters
  double Kp;
  double Ki;
  double Kd;
  //PID declaration and constructor arguments
  PIDSource gyroSource;
  PIDOutput output;
  PIDController PID;

  double target;
  double tolerance;

  String outputPath = "\\logs\\PIDoutput.txt";
  BufferedWriter writer;

  public MaintainCourse() throws IOException{
    // Use requires() here to declare subsystem dependencies
    if (Robot.driveTrain != null){
      requires(Robot.driveTrain);
    }
    //create the writer
    writer = new BufferedWriter(new FileWriter("*\\logs\\PIDoutput.txt"));
    writer.write("interval \t output \t error \t angle \t target \n\r");
  }

  //method that generates output
  void writeOutput(int interval, double result, double error, double angle, double target) throws IOException {
    writer.write(interval + " \t" + result + " \t" + error + " \t" + angle + " \t" + target + "\n\r");
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    //set all the PID calibration variation, calibrate here
    Kp = 1;
    Ki = 0;
    Kd = 0;

    tolerance = 5; //Percent tolerance, 5.0 means 5%.
    target = Robot.gyro.getDeg(); //set the target to be the angle that the robot was at when the command was initialised

    gyroSource = new PIDSource() { //set up the angle of the gyroscope as the source of the PID. Due to a quirk of the library, a double cannot be used directly
    
      @Override
      public void setPIDSourceType(PIDSourceType pidSource) {} //ignore this, but do not delete
    
      @Override
      public double pidGet() {
        return Robot.gyro.getDeg();
      }
    
      @Override
      public PIDSourceType getPIDSourceType() {
        return null;
      }
    };
    //create the PID object and set Target, Tolerance, etc.
    PID = new PIDController(Kp, Ki, Kd, gyroSource, output);
    PID.setSetpoint(target);
    PID.setPercentTolerance(tolerance);
  }

  // Called repeatedly when this Command is scheduled to run
  int interval = 0;
  @Override
  protected void execute() {
    
  }

  void adjustCourse() {
    System.out.println(PID.get());

    //turn the robot around it's own axis by the amount indicated
    double leftAmount;
    double rightAmount;

    rightAmount = PID.get();
    leftAmount = -PID.get();

    Robot.driveTrain.moveLeftWheels(leftAmount);
    Robot.driveTrain.moveRightWheels(rightAmount);
    
    //write result to output for debugging and calibration
    try {
    writeOutput(interval, PID.get(), PID.getError(), Robot.gyro.getDeg(), PID.getSetpoint());
    } catch(IOException er) {
      System.out.println("Couldn't write to file because of " + er);
    }
    interval++;
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
