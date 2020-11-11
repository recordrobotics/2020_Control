package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.*;

public abstract class Acquisition extends Subsystem {
    public abstract double getTiltSpeed();
    public abstract boolean getTiltPosition();
    public abstract void setTiltPosition(boolean pos);
    public abstract void moveAcq(double v);
    public abstract void moveTilt(double v);
    public abstract boolean getTiltLimit();
    public abstract boolean isAcqOn();

    /**
     * Creates a ControlAcquisition command.
     */
    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ControlAcquisition());
    }
}
