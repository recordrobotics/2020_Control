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
    /**
     * cameraOffCenter How far away the camera is from the center of the robot.
     * targetAngle The angle the robot needs to face in order to shoot at the goal.
     * gyroAngle The angle returned by the gyro.
     */
    double cameraOffCenter = 5.25;
    double targetAngle;
    double gyroAngle = Robot.gyro.getDeg();

    double firingDistance;
    double timeOut = 2;

    /**
     * MoveToFire() Moves the robot into position to fire.
     * USE THIS COMMAND TO SHOOT AUTONOMOUSLY
     * @param fDist How far the robot needs to be from the goal in order to score.
     */
    public MoveToFire(double fDist){

        firingDistance = fDist;

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

        autonomousOne();
    }

    private void autonomousOne(){
        addSequential(new TurnToGoal(targetAngle), timeOut);
        addSequential(new MoveToRange(firingDistance), 5);
        addSequential(new TurnToGoal(targetAngle), timeOut);
        addSequential(new BeltAutoRun());
        addSequential(new MoveForward(120 - firingDistance + 36, -0.5), 0.7);
    }

    private void autonomousTwo(){
        addSequential(new TurnToGoal(targetAngle), timeOut);
        addSequential(new MoveToRange(firingDistance), 5);
        addSequential(new TurnToGoal(targetAngle), timeOut);
        addSequential(new BeltAutoRun());

        addSequential(new TurnToAngle(180));
        addParallel(new TiltAcquisition());
        addSequential(new MoveForward(120 - firingDistance + 36, 0.5), 0.7);
    }
}
