/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class GalSearchB extends CommandGroup {
  private double velocity;

  public GalSearchB(boolean redPath, double v) {
    velocity = v;
    if (redPath) {
      redPath();
    }
    else {
      bluePath();
    }
  }

  private void redPath(){
    addSequential(new MoveForward(33, 0.7));
    addParallel(new PickUpBall(2));
    addSequential(new CircularTrajectory(2, Math.PI/3, velocity));

    addParallel(new PickUpBall(2));
    addSequential(new CircularTrajectory(-0.7, Math.PI-0.8, velocity));
    addSequential(new MoveForward(40, 0.7));

    addParallel(new PickUpBall(2));
    addSequential(new CircularTrajectory(2.5, Math.PI/3, velocity));
    addSequential(new MoveForward(46, 0.7));
  }

  private void bluePath(){
    addParallel(new PickUpBall(3));
    addSequential(new MoveForward(134, 0.7));
    addSequential(new CircularTrajectory(-1.2, Math.PI/2));

    addParallel(new PickUpBall(1));
    addSequential(new CircularTrajectory(0.7, Math.PI/1.5));

    addParallel(new PickUpBall(2));
    addSequential(new MoveForward(63, 0.7));
    addSequential(new CircularTrajectory(-0.7, Math.PI/2));
    addSequential(new MoveForward(24, 0.7));
  }

  @Override
  protected void initialize() {
  }

}
