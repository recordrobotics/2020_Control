package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;  

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import frc.robot.commands.*;
/*1 CIM - + and - (circular) direction, possible neutral (spins freely)
1 MINI CIM - + and - (circular) direction
Both motor control different systems
Possible thought of combining both lifts*/
/**
 * 
 */
public abstract class RobotLift extends Subsystem {
    public void initDefaultCommand() {
        setDefaultCommand(new LiftControl());
    }
    
    public abstract void moveLift(double v);
    public abstract void stop();
}