/*Info on Robot Lift:
1 CIM - + and - (circular) direction, possible neutral (spins freely)
1 MINI CIM - + and - (circular) direction
Both motor control different systems
Possible thought of combining both lifts
package frc.robot.subsystems;*/
package frc.robot.subsystems;

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
  
    public void stop() {

        robotLiftMotor.stopMotor();

        robotLiftMotor.set(0.0);
    }
    public void moveLift(double v) {

        robotLiftMotor.set(ControlMode.PercentOutput, v);
    }
}