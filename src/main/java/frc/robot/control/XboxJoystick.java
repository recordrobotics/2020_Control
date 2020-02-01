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
        return -0.25*xbox.getY(Hand.kLeft);
    }

    public boolean getButtonState (String buttonName){
        if (buttonName == "x" || buttonName == "X"){
            return xbox.getXButton();
        } else if (buttonName == "y" || buttonName == "Y" ) {
            return xbox.getYButton();
        } else if (buttonName == "a" || buttonName == "A"){
            return xbox.getAButton();
        } else if (buttonName == "b" || buttonName == "B" ) {
            return xbox.getBButton();
        } else if (buttonName == "lb" || buttonName == "LB"){
            return xbox.getBumper(Hand.kLeft);
        } else if (buttonName == "rb" || buttonName == "RB" ) {
            return xbox.getBumper(Hand.kRight);
        } else {
            return false;
        }

    }
    public double getCStickXAxis(){
        return xbox.getX(Hand.kRight);
    }
    public double getCStickYAxis(){
        return xbox.getY(Hand.kRight);
    }


}