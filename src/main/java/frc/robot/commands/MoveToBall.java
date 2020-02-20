/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.AutoTurn;
import frc.robot.commands.MoveForward;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * An example command.  You can replace me with your own command.
 */
public class MoveToBall extends CommandGroup {
  

  public MoveToBall(double pyangle, double rangeDistance){
    pyangle = SmartDashboard.getNumber("Angle to Ball", 359);
    rangeDistance = Robot.rangeFinder.getDistance();
   addSequential(new AutoTurn(pyangle));
   addSequential(new MoveForward(rangeDistance, 1));
 
  }
 

}
