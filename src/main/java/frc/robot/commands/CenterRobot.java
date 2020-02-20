/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.AutoTurn;
import frc.robot.commands.MoveForward;
/**
 * An example command.  You can replace me with your own command.
 */
public class CenterRobot extends CommandGroup {
  //TODO: Set distances to correct values
  private double distanceToMove;
  private final double distLineToGoal = 0;

  public CenterRobot(double distanceFromTarget, double distanceOffCenter) {
    distanceToMove = Math.pow(Math.pow(distanceOffCenter,2)+Math.pow(distanceFromTarget,2),0.5);
    distanceFromTarget -= distLineToGoal;

    // Possibly needs one version for each side of the target
    addSequential(new AutoTurn(Math.atan(distanceFromTarget/distanceOffCenter)));
    addSequential(new MoveForward(distanceToMove, 0.5));
    addSequential(new AutoTurn(Math.atan(distanceFromTarget/distanceOffCenter)));
  
  }
}
