package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
//import frc.robot.commands.*;
//import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.Robot.CurrentRobot;
import frc.robot.commands.AutoTurn;
import frc.robot.commands.MoveForward;
import frc.robot.commands.TiltAcquisition;
import frc.robot.commands.MoveToRange;
import frc.robot.commands.TurnToGoal;
import frc.robot.control.ButtonMap;

public class Dashboard extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private CurrentRobot cRobot;
  public Dashboard(CurrentRobot r){
    cRobot = r;

    SmartDashboard.putData("Move 3ft", new MoveForward(24, 0.2));
    SmartDashboard.putData("Turn Left", new AutoTurn(-90));
    SmartDashboard.putData("Turn Right", new AutoTurn(90));
    SmartDashboard.putData("Tilt Acquisition", new TiltAcquisition());
    SmartDashboard.putData("Move to 3ft", new MoveToRange(36));
    SmartDashboard.putData("Turn to Goal", new TurnToGoal());

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
    SmartDashboard.putNumber("Gyro Angle", Robot.gyro.getDeg());
    //SmartDashboard.putNumber("Flywheel Speed", Robot.flywheel.getSpeed());
    
    SmartDashboard.putNumber("Range Found", Robot.rangeFinder.getDistance());
    SmartDashboard.putBoolean("Green Button", OI.getPanelButtonState(ButtonMap.liftRaise));
  }

  /*
  SmartDashboard.putData("Move 3ft", new MoveForward(24, 0.2));
    SmartDashboard.putData("Turn Left", new AutoTurn(-90));
    SmartDashboard.putData("Turn Right", new AutoTurn(90));
    SmartDashboard.putData("Tilt Acquisition", new TiltAcquisition());
    SmartDashboard.putData("Move to 3ft", new MoveToRange(36));
    SmartDashboard.putData("Turn to Goal", new TurnToGoal());
  */

}