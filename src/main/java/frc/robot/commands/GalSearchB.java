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
  private double initXred = 0.5, initYred = 3.81, initXblue, initYblue;
  private boolean redPath = true;

  public GalSearchB() {
    SmartDashboard.putBoolean("Acquistion", Robot.acq.isAcqOn());
        Robot.odometry.reset(initXred, initYred);
        velocity = SmartDashboard.getNumber("Autonomous Velocity", 2.0);

        addParallel(new TiltAcquisition());

        bluePath();
  }

  private void redPath(){
    addSequential(new CircularTrajectory(2.5, Math.PI/3, velocity));
    addSequential(new CircularTrajectory(-1, Math.PI - 1, velocity));
    addSequential(new MoveForward(60, -0.7));
    addSequential(new CircularTrajectory(3, Math.PI/3.5, velocity));
  }

  private void bluePath(){
    addSequential(new TurnToAngle(140));
  }

  @Override
  protected void initialize() {
    velocity = SmartDashboard.getNumber("Autonomous Velocity", 2.0);    
    Robot.odometry.reset(initXred, initYred);
  }

}
