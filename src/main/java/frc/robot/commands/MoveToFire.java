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
        
        addSequential(new TurnToGoal(targetAngle));
        addSequential(new TurnToGoal(targetAngle));
        addSequential(new MoveToRange(firingDistance));
        addSequential(new TurnToGoal(targetAngle));
        addSequential(new BeltAutoRun());
        //addSequential(new TurnToAngle(180));
        //addSequential(new MoveForward((10 - firingDistance) + 4, 0.5));
    }
}
