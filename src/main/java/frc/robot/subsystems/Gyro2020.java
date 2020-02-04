package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

public class Gyro2020 extends Gyroscope{
    @Override
    public void initDefaultCommand() {;
        //do nothing, no default command for this subsystem
    }   

    private AHRS gyro = new AHRS(I2C.Port.kOnboard);

    public double getDeg(){
        return gyro.getAngle();
    }

    public double getRad(){
        return Math.toRadians(getDeg());
    }

    public void gyroCalib(){
        gyro.calibrate();
        gyro.reset();
    }

    public void gyroReset(){
        gyro.reset();
    }
}