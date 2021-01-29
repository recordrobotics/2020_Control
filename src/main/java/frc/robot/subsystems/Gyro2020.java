package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.simulation.BuiltInAccelerometerSim;
/**import edu.wpi.first.wpilibj.I2C.Port;*/
import frc.robot.Robot;

/**
 * Subsystem class for the gyroscope used on the 2020 Robot
 * Extends the Gyroscope abstract class
 */
public class Gyro2020 extends Gyroscope{
    @Override
    public void initDefaultCommand() {;
        /**do nothing, no default command for this subsystem*/
    }   
    /**
    * Instance variable representing the gyroscope, an AHRS gyroscope
    * @see RobotMap.java
    */
    private AHRS gyro = new AHRS(I2C.Port.kOnboard);

    private BuiltInAccelerometer builtInAccel = new BuiltInAccelerometer();
    public BuiltInAccelerometerSim builtInAccelSim = new BuiltInAccelerometerSim(builtInAccel);
    private boolean useBuiltIn = true;

    /**
     * @return the current angle the robot is at, in degrees
     */
    public double getDeg(){
        if (Robot.isSimulation())
            return Robot.driveTrain.getSimulatedAngle();
        
        return gyro.getAngle();
    }

    /**
     * @return the current angle the robot is at, in radians
     */
    public double getRad(){
        return Math.toRadians(getDeg());
    }
    
    /**
     * Calibrates the gyroscope and resets the current direction the robot is pointing to 0
     * Don't move the robot for 5 seconds while the gyroscope is calibrating
     */
    public void gyroCalib(){
        gyro.calibrate();
        gyro.reset();
    }

    /**
     * Resets the current direction the robot is pointing to 0
     * Does not calibrate the robot!
     */
    public void gyroReset(){
        gyro.reset();
    }

    /**
     Guesstimate indicates that it should take about 1.7kN to tip robot with froce at center of mass
     F = (m * g * 0.6858) * (1/h) where h is the height of the center of mass (estimate = 8")
     But this seems like a lot, so I may be misunderstanding the torque applied here
     */

     public double getAccelX(){
        return getAccel("x");
     }

     public double getAccelY(){
        return getAccel("y");
     }

     public double getAccelZ(){
        return getAccel("z");
     }

     private double getAccel(String direction){
        double accel = 0;

        if (Robot.isSimulation() && !useBuiltIn){
            useBuiltIn = true;
        }

        switch(direction){
        case "x":
            if (useBuiltIn) {
                accel = builtInAccel.getX();
            } else {
                accel = gyro.getRawAccelX();
            }
            break;
        case "y":
            if (useBuiltIn) {
                accel = builtInAccel.getY();
            } else {
                accel = gyro.getRawAccelY();
            }
            break;
        case "z":
            if (useBuiltIn) {
                accel = builtInAccel.getZ();
            } else {
                accel = gyro.getRawAccelZ();
            }
            break;
        default:
            throw new IllegalArgumentException("Direction should be x, y, or z");
        }

        return accel;
     }

     private DifferentialDriveKinematics dKin = new DifferentialDriveKinematics(0.6858);
     private double vX, vY, prev_Vx, prev_Vy;
     /**
      * Updates the virtual accelerometer using simualted data
      * A two-point derrivative is fine for this, as simulated data is noiseless
      * t = 0.02s = 20ms, units are Gs (1G = 9.81 m/s^2)
      */
     public void updateAccelSim(double Vleft, double Vright){
        ChassisSpeeds cSpeeds = dKin.toChassisSpeeds(new DifferentialDriveWheelSpeeds(Vleft, Vright));

        prev_Vx = vX;
        prev_Vy = vY;

        vX = cSpeeds.vxMetersPerSecond;
        vY = cSpeeds.vyMetersPerSecond;

        builtInAccelSim.setX(((vX - prev_Vx)/0.02)/9.81);
        builtInAccelSim.setY(((vY - prev_Vy)/0.02)/9.81);
     }
}