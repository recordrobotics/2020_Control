package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;


public abstract class Dashboard extends Subsystem {

    /**
    * displays a certain value on the dashboard under a certain name
    */
    @Override
    public void initDefaultCommand() {
    }

    @Override
    public abstract void periodic();
}