package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;  

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import frc.robot.commands.*;

/**
 * 
 */
public class Lift extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    //Lift for Monolith. Should work.

    Talon motor = new Talon(RobotMap.liftPortMonolith);
    
    DigitalInput topLimit = new DigitalInput(1);
    DigitalInput bottomLimit = new DigitalInput(2);

    public void initDefaultCommand() {
        setDefaultCommand(new LiftControl());
    }
    
    public void moveLift(double v)
    {
        if ((v < 0 & bottomLimit.get()) || (v > 0 & topLimit.get()))
        {
            motor.set(v);
        }
    }
    
    public void stop()
    {
    	motor.stopMotor();
    	motor.set(0.0);
    }
}