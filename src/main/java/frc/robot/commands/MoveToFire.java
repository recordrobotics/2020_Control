/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;


public class MoveToFire extends CommandGroup {

    double cameraOffCenter = 5.25;
    double targetAngle;
    double gyroAngle = Robot.gyro.getDeg();

    public MoveToFire(double firingDistance){
        if (cameraOffCenter != 0){
            targetAngle = (90 - Math.toDegrees(Math.atan(firingDistance / cameraOffCenter)));
            targetAngle = (int)(targetAngle + 0.5);

            if (targetAngle > 0){
                targetAngle = -targetAngle;
            }
            System.out.println(targetAngle);
        }
        else {
            targetAngle = 0;
        }

        System.out.println("Target Angle" + targetAngle);

        double timeOut = 2;

        addSequential(new TurnToGoal(targetAngle), timeOut);
        addSequential(new MoveToRange(firingDistance), 5);
        addSequential(new TurnToGoal(targetAngle), timeOut);
        addSequential(new BeltAutoRun());
        addSequential(new MoveForward(36, 0.5), 0.8);

        /**addSequential(new TiltAcquisition(), timeOut);*/

/**
*        addSequential(new TurnToAngle(-180+gyroAngle));
*        addSequential(new MoveForward((120-firingDistance) + 48, 0.5));
*/
    }
}
