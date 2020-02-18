/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoTurn;
import frc.robot.commands.MoveForward;
/**
 * An example command.  You can replace me with your own command.
 */
public class CenterRobot extends SequentialCommandGroup {
  //TODO: Set distances to correct values
  private static double distanceOffCenter = 1;
  private static double distanceFromTarget = 1;
  private static double distanceToMove = Math.pow(Math.pow(distanceOffCenter,2)+Math.pow(distanceFromTarget,2),0.5);
  public CenterRobot(AutoTurn AutoTurn, MoveForward MoveForward) {

  // Possibly needs one version for each side of the target

    new AutoTurn(90+Math.atan(distanceFromTarget/distanceOffCenter));
    new MoveForward(distanceToMove, 0.5);
    new AutoTurn(90-Math.atan(distanceFromTarget/distanceOffCenter));
  
  }
}
