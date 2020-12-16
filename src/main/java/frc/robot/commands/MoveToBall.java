/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import frc.robot.commands.AutoTurn;
import frc.robot.commands.MoveForward;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveToBall extends SequentialCommandGroup {
  /**
   * pyangle The angle to the ball.
   */
  private static double pyangle = SmartDashboard.getNumber("Angle to Ball", 0);
  /**
   * MoveToBall() Moves the robot to a ball.
   */
  public MoveToBall(){
    addCommands(
      new AutoTurn(pyangle),
      new MoveForward()
    );
 
  }
 

}
