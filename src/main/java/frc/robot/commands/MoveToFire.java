/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class MoveToFire extends CommandGroup {

    double cameraOffCenter = 0;
    double targetAngle;

    public MoveToFire(double firingDistance){
        if (cameraOffCenter != 0)
            targetAngle = (90 - Math.toDegrees(Math.atan(firingDistance / cameraOffCenter)));
        else {
            targetAngle = 0;
        }

        addSequential(new TurnToGoal(), 15);
    }
}
