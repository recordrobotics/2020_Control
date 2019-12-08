package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import frc.robot.commands.*;

/**
 *
 */
public class Lift extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Talon motor = new Talon(RobotMap.liftPortMonolith);

    public void initDefaultCommand() {
        setDefaultCommand(new LiftControl());
    }
    
    public void moveLift(double v)
    {
    	motor.set(v);
    }
    
    public void stop()
    {
    	motor.stopMotor();
    	motor.set(0.0);
    }
}