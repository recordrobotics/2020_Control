package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.*;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.Robot.CurrentRobot;

public class Dashboard extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private CurrentRobot cRobot;
  public Dashboard(CurrentRobot r){
    cRobot = r;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic(){
      switch (cRobot){
        case MONOLITH:
          displayMonolith();
          break;
        case MONTY:
          break;
        case ROBOT2020:
          display2020();
          break;
      }
  }

  private void displayMonolith(){
    //write gyro angle to dashboard
    
  }

  private void display2020(){
    SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.getRightEncoder());
    SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.getLeftEncoder());

    SmartDashboard.putData("Move 3ft", new MoveForward(36, 0.2));
    SmartDashboard.putData("Turn Left", new AutoTurn(-90));
    SmartDashboard.putData("Turn Right", new AutoTurn(90));

    SmartDashboard.putNumber("Gyro Angle", Robot.gyro.getDeg());
  }
}