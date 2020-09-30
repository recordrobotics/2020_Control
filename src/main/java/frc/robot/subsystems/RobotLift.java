package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
//import frc.robot.RobotMap;  

//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.Talon;
import frc.robot.commands.*;

/**
 * 
 */
public abstract class RobotLift extends Subsystem {
    public void initDefaultCommand() {
        setDefaultCommand(new LiftControl());
    }
    /**
     * initDefaultCommand() makes LiftControl command.
     * v moves lift at speed v.
     */
    public abstract void moveLift(double v);
    public abstract void stop();
}