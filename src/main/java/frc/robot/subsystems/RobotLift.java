package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
/**import frc.robot.RobotMap;  */

/**
*import edu.wpi.first.wpilibj.DigitalInput;
*import edu.wpi.first.wpilibj.Talon;
*/
import frc.robot.commands.*;

public abstract class RobotLift extends SubsystemBase {
    public RobotLift() {
        this.setDefaultCommand(new LiftControl());
    }

    public abstract void moveLift(double v);
    public abstract void stop();
}