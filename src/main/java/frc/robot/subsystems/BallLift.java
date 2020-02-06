package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;  

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.commands.*;

/**
 COPY OF LIFT.JAVA modified for Ball storage lift.
 */


public class BallLift extends Subsystem {
  private WPI_VictorSPX beltMotor = new WPI_VictorSPX(-1);
    public void initDefaultCommand() {
        setDefaultCommand(new BeltControl());
    }
    
    public void moveBelt(double v){
      beltMotor.set(ControlMode.PercentOutput, v);
    }

    public void stop(){

    }

}
