package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private VictorSP lift_motor = new VictorSP(6);

    public void initDefaultCommand() {}
    
    public void moveLift(double v)
    {
    	this.lift_motor.set(v);
    }
    
    public void stop()
    {
    	this.lift_motor.stopMotor();
    	this.lift_motor.set(0.0);
    }
}