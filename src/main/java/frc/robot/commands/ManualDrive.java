/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
/**import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;*/
import frc.robot.Robot;
/**import frc.robot.subsystems.Drive2020;*/
import frc.robot.OI;

public class ManualDrive extends CommandBase {

  /** input multiplier, reduces or increases the input value */
  private double turnMult = 0.67, fwdMult = 0.6;

  public ManualDrive() {
    /** Use requires() here to declare subsystem dependencies */
    addRequirements(Robot.driveTrain);
  }

  /** Called repeatedly when this Command is scheduled to run */
  @Override
  public void execute() {
    switch (Robot.currentRobot) {
      case MONOLITH:
        driveMonolith();
        break;
      case ROBOT2020:
        drive2020();
        break;
    }
  }

  private double driveMonolith() {
    double turnAmount = OI.getTurn() * turnMult;
    double forwardAmount = OI.getForward() * fwdMult;

    double leftAmount = forwardAmount;
    double rightAmount = forwardAmount;

    leftAmount += turnAmount;
    rightAmount -= turnAmount;

    leftAmount = OI.accCurve(leftAmount);
    rightAmount = OI.accCurve(rightAmount);

    Robot.driveTrain.moveLeftWheels(leftAmount);
    Robot.driveTrain.moveRightWheels(rightAmount);

    return ((leftAmount + rightAmount) / 2);
  }

  private void drive2020() {
    double fwdMult2020 = fwdMult;
    double turnMult2020 = turnMult;
    if (OI.getXboxButtonState("LS")) {

      fwdMult2020 = fwdMult * 1.5;
      turnMult2020 = turnMult * 1.5;

      if (fwdMult2020 > 1) {
        fwdMult2020 = 1;
      }
      if (turnMult2020 > 1) {
        turnMult2020 = 1;
      }
    }
    Robot.driveTrain.getDrive().arcadeDrive(OI.getForward() * fwdMult2020, OI.getTurn() * turnMult);
  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    return false;
  }
}
