package frc.robot.control;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.RobotMap;

public class XboxJoystick extends Controller{
    XboxController xbox;

    public XboxJoystick(){
        xbox = new XboxController(RobotMap.xboxPort);
    }
    
    public double getXAxis (){
        return xbox.getX(Hand.kLeft);
    }

    public double getZ (){
        return getXAxis();
    }

    public double getYAxis (){
        return -xbox.getY(Hand.kLeft);
    }


}