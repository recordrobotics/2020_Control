/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.commands.AutoTurn;
import frc.robot.commands.MoveForward;
/**import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;*/

public class CenterRobot extends SequentialCommandGroup {
  /**TODO: Set distances to correct values*/
  private double distanceToMove;
  private final double distLineToGoal = 120;

  /**
   * Calculates the distance the robot needs to move by using right triangles with the distance off of the target forwards/backwards and side/side
   * Calculates the angle needed to turn to be facing the target using the same method as above
   * Turns the calculated angle, moves the calculated distance, returns to facing straight, and runs the belt to fire all balls
   * @param distanceFromTarget distance away from target (forward/backward)
   * @param distanceOffCenter distance away from target (left/right)
   */
  public CenterRobot(double distanceFromTarget, double distanceOffCenter) {
    distanceToMove = Math.pow(Math.pow(distanceOffCenter,2)+Math.pow(distanceFromTarget,2),0.5);
    distanceFromTarget -= distLineToGoal;

    /**Robot.acq.setTiltPosition(false);*/

    double theta = Math.toDegrees(Math.atan(distanceFromTarget/distanceOffCenter));

    if (distanceFromTarget < 0){
      theta += 90;
    }

    /** Possibly needs one version for each side of the target*/

    addCommands(
      new AutoTurn(theta),
      new MoveForward(distanceToMove, 0.5),
      new AutoTurn(180 - theta),
      new BeltAutoRun()
    );
  
  }
}
