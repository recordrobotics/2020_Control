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
  private double initXred = 0.5, initYred = 3.81, initXblue = 0.5, initYblue = 1.524;
  private boolean redPath = false;

  public GalSearchB() {
    SmartDashboard.putBoolean("Acquistion", Robot.acq.isAcqOn());
        reset();    

        addParallel(new TiltAcquisition());

        if (redPath) {
          redPath();
        } else {
          bluePath();
        }
  }

  private void redPath(){
    addParallel(new PickUpBall(2));
    addSequential(new CircularTrajectory(2.5, Math.PI/3, velocity));

    addParallel(new PickUpBall(2));
    addSequential(new CircularTrajectory(-1, Math.PI - 1, velocity));

    addParallel(new PickUpBall(2));
    addSequential(new MoveForward(60, -0.7));

    addSequential(new CircularTrajectory(3, Math.PI/3.5, velocity));
  }

  private void bluePath(){
    addParallel(new PickUpBall(3));
    addSequential(new MoveForward(134, -0.7));
    addSequential(new CircularTrajectory(-1.5, Math.PI/2));

    addParallel(new PickUpBall(1));
    addSequential(new CircularTrajectory(0.5, Math.PI/1.4));

    addParallel(new PickUpBall(2));
    addSequential(new MoveForward(60, -0.7));
    addSequential(new CircularTrajectory(-0.5, Math.PI));
  }

  @Override
  protected void initialize() {
    reset();
  }

  private void reset(){
    velocity = SmartDashboard.getNumber("Autonomous Velocity", 2.0);  
    
    if (redPath){
      Robot.odometry.reset(initXred, initYred);
    } else {
      Robot.odometry.reset(initXblue, initYblue);
    }
  }

}
