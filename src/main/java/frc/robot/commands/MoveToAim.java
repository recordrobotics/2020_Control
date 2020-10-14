/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveToAim extends CommandGroup {
    /**
     * cameraOffCenter How far away the camera is from the center of the robot.
     * targetAngle The angle the robot needs to face in order to shoot at the goal.
     */
    double cameraOffCenter = 5.25;
    double targetAngle;
    /**
     * MoveToAim() Moves the robot so that it can fire.
     * @param firingDistance How far we have to stand in order to shoot the ball into the slot.
     */
    public MoveToAim(double firingDistance){

        /**setTimeout(5);*/

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
        double timeOut = 1.5;

        addSequential(new TurnToGoal(targetAngle), timeOut);
        addSequential(new TurnToGoal(targetAngle), timeOut);
        addSequential(new MoveToRange(firingDistance), 3);
        addSequential(new TurnToGoal(targetAngle), timeOut);
        
    }
}