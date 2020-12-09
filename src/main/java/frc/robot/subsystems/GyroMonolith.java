package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import frc.robot.RobotMap;

/**
 * Subsystem class for the gyroscope used on Monolith (2018 Robot) Extends the
 * Gyroscope abstract class
 */
public class GyroMonolith extends Gyroscope {

    /**
     * Instance variable representing the gyroscope, an ADXR-450
     * 
     * @see RobotMap.java
     */
    private ADXRS450_Gyro gyro = new ADXRS450_Gyro(RobotMap.gyroPortSPI);

    /**
     * @return the current angle the robot is at, in degrees
     */
    public double getDeg() {
        return gyro.getAngle();
    }

    /**
     * @return the current angle the robot is at, in radians
     */
    public double getRad() {
        return Math.toRadians(gyro.getAngle());
    }

    /**
     * Calibrates the gyroscope, and defines the direction the robot is pointing to
     * be 0 Do not move the robot for 5 seconds while the gyroscope is calibrating
     */
    public void gyroCalib() {
        gyro.calibrate();
        gyro.reset();
    }

    /**
     * Defines the direction the robot is pointing as 0 Does not recalibrate the
     * gyroscope
     */
    public void gyroReset() {
        gyro.reset();
    }
}