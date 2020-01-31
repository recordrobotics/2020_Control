package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import frc.robot.RobotMap;

public class GyroMonolith extends Gyroscope {
    @Override
    public void initDefaultCommand() {;
        //do nothing, no default command for this subsystem
    }
    private ADXRS450_Gyro gyro = new ADXRS450_Gyro(RobotMap.gyroPortSPI);

    //get angle in degrees
    public double getDeg(){
        return gyro.getAngle();
    }

    //get angle in radians
    public double getRad(){
        return Math.toRadians(gyro.getAngle());
    }

    //initialization: calibrate the gyroscope and set the initial angle to be 0
    public void gyroCalib(){
        gyro.calibrate();
        gyro.reset();
    }

    //reset the gyro without recalibrating
    public void gyroReset(){
        gyro.reset();
    }
}