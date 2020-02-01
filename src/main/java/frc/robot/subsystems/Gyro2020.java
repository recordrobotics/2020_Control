package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;

public class Gyro2020 extends Gyroscope{
    @Override
    public void initDefaultCommand() {;
        //do nothing, no default command for this subsystem
    }

    I2C port = new I2C(I2C.Port.kOnboard, 2);

    private AHRS gyro = new AHRS(port);

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