/*Info on Robot Lift:
1 CIM - + and - (circular) direction, possible neutral (spins freely)
1 MINI CIM - + and - (circular) direction
Both motor control different systems
Possible thought of combining both lifts
package frc.robot.subsystems;*/
package frc.robot.subsystems;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogEncoder;
import com.ctre.phoenix.motorcontrol.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.RobotMap;

public class RobotLift2020 extends RobotLift{
    private WPI_VictorSPX robotLiftMotor = new WPI_VictorSPX(RobotMap.robotLiftLeftMotorPort);
    private double targetVoltage = 11.5;

    public RobotLift2020(){
        robotLiftMotor.enableVoltageCompensation(true);
        robotLiftMotor.setVoltage(targetVoltage);
    }
    /**
     * robotLiftMotorLeft creates variable for the left lift motor.
     * stop() stops the motor.
     */
    private WPI_VictorSPX robotLiftMotorLeft = new WPI_VictorSPX(RobotMap.robotLiftLeftMotorPort);
  
    AnalogInput encoderInput = new AnalogInput(0);
    AnalogEncoder liftEncoder = new AnalogEncoder(encoderInput);

    public void stop() {

        robotLiftMotor.stopMotor();

        robotLiftMotor.set(0.0);
    }
    public double getPosition(){
        return liftEncoder.get();
    }
    /**
     * moveLift() moves lift up and down.
     * @param v how fast the left lift motor spins.
     */
    public void moveLift(double v) {

        robotLiftMotor.set(ControlMode.PercentOutput, v);
    }
}