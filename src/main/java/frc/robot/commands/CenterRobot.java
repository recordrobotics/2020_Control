/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.AutoTurn;
import frc.robot.commands.MoveForward;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * An example command.  You can replace me with your own command.
 */
public class CenterRobot extends CommandGroup {
  //TODO: Set distances to correct values
  private double distanceToMove;
  private final double distLineToGoal = 120;

  public CenterRobot(double distanceFromTarget, double distanceOffCenter) {
    distanceToMove = Math.pow(Math.pow(distanceOffCenter,2)+Math.pow(distanceFromTarget,2),0.5);
    distanceFromTarget -= distLineToGoal;

    //Robot.acq.setTiltPosition(false);

    double theta = Math.toDegrees(Math.atan(distanceFromTarget/distanceOffCenter));

    if (distanceFromTarget < 0){
      theta += 90;
    }

    // Possibly needs one version for each side of the target
    addSequential(new AutoTurn(theta));
    addSequential(new MoveForward(distanceToMove, 0.5));
    addSequential(new AutoTurn(180 - theta));
    addSequential(new BeltAutoRun());
  
  }
}
