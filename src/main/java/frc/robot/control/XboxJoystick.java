package frc.robot.control;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;


/**
 * A class that turns the inputs from an XBox controller into usable inputs for our code
 */
public class XboxJoystick extends Controller{
    //How many usuable button inputs there are on the controller
    private static final int NUM_BUTTONS = 10;

    XboxController xbox;
    private JoystickButton[] buttons;

    public XboxJoystick(){
        //Assigns the port the controller is connected to
        xbox = new XboxController(RobotMap.xboxPort);
        buttons = new JoystickButton[NUM_BUTTONS];

        /**instantiate buttons*/
		for(int i = 0; i < NUM_BUTTONS; i++){
			buttons[i] = new JoystickButton(xbox, i);
		}
    }
    /**
     * Gets the requested JoystickButton
     * @param buttonName The abbreviated name for the button <p> Accepted inputs are X, Y, A, B, LB, and RB <p> Unaccepted inputs will return the A button
     * @return The requested JoystickButton, or the A button if buttonName wasn't an accepted input
     */
    public JoystickButton getButton(String buttonName){
        buttonName.toUpperCase();
        int button;
        switch (buttonName){
            case "X":
                button = 3;
                break;
            case "Y":
                button = 4;
                break;
            case "A":
                button = 1;
                break;
            case "B":
                button = 2;
                break;
            case "LB":
                button = 5;
                break;
            case "RB":
                button = 6;
                break;
            case "RSYUP":
                button = 7;
                break;
            case "RSYDOWN":
                button = 8;
                break;
            case "RSXRIGHT":
                button = 9;
                break;
            case "RSXLEFT":
                button = 10;
                break;
            default:
                button = 1;
                break;
        }
		return buttons[button];
    }
    
    /**
     * @return The X axis value of the left stick
     */
    public double getXAxis (){
        return xbox.getX(Hand.kLeft);
    }

    /**
     * Unnecessary function required by the superclass, does the same thing as getXAxis
     */
    public double getZ (){
        return getXAxis();
    }

    /**
     * @return The Y axis value of the left stick
     */
    public double getYAxis (){
        return xbox.getY(Hand.kLeft);
    }
    /**
     * Gets whether or not a button is pressed as a boolean
     * @param buttonName The common abbreviation for the button <p> Accepted inputs are X, Y, A, B, LB, RB, LS, RS, LT, RT, START, and BACK <p> Non-accepted inputs will return false
     * @return The boolean value of the button
     */
    public boolean getButtonState (String buttonName){
        buttonName.toUpperCase();

        switch (buttonName){
            case "X":
                return xbox.getXButton();
            case "Y":
                return xbox.getYButton();
            case "A":
                return xbox.getAButton();
            case "B":
                return xbox.getBButton();
            case "LB":
                return xbox.getBumper(Hand.kLeft);
            case "RB":
                return xbox.getBumper(Hand.kRight);
            case "LS":
                return xbox.getStickButton(Hand.kLeft);
            case "RS":
                return xbox.getStickButton(Hand.kRight);
            case "LT":
                return getTrigger("LT");
            case "RT":
                return getTrigger("RT");
            case "RSYUP":
                return getRightStickYUp();
            case "RSYDOWN":
                return getRightStickYDown();
            case "RSXRIGHT":
                return getRightStickXRight();
            case "RSXLEFT":
                return getRightStickXLeft();
            case "START":
                return xbox.getStartButton();
            case "BACK":
                return xbox.getBackButton();
            default:
                return false;
        }

    }
    /**
     * 
     * @return The X axis value of the right stick
     */
    public double getCStickXAxis(){
        return xbox.getX(Hand.kRight);
    }

    /**
     * 
     * @return The Y axis value of the right stick
     */
    public double getCStickYAxis(){
        return xbox.getY(Hand.kRight);
    }

    /**
     * Turns the right stick into inputs that can be used as buttons
     * @return Whether or not the right stick is more than halfway to the right
     */
    public boolean getRightStickXRight() {
        if (getCStickXAxis() > 0.5) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Turns the right stick into inputs that can be used as buttons
     * @return Whether or not the right stick is more than halfway to the left
     */
    public boolean getRightStickXLeft() {
        if (getCStickXAxis() > -0.5) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Turns the right stick into inputs that can be used as buttons
     * @return Whether or not the right stick is more than halfway up
     */
    public boolean getRightStickYUp() {
        if (getCStickYAxis() < -0.5) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Turns the right stick into inputs that can be used as buttons
     * @return Whether or not the right stick is more than halfway down
     */
    public boolean getRightStickYDown() {
        if (getCStickYAxis() > 0.5) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * 
     * @return The axis value of the right trigger, i.e. how far it is pushed in
     */
    public double getRTAxis(){
        return xbox.getTriggerAxis(Hand.kRight);
    }

    /**
     * 
     * @return The axis value of the left trigger, i.e. how far it is pushed in
     */
    public double getLTAxis(){
        return xbox.getTriggerAxis(Hand.kLeft);
    }

    /**
     * Gets whether or not the given trigger's axis is over a set cutoff as a boolean
     * @param triggerName The trigger to check <p> Accepted inputs are LT and RT, unaccepted inputs will return false
     * @return If it is past the cutoff
     */
    public boolean getTrigger(String triggerName) {
        triggerName.toUpperCase();
        double cutoff = 0.5;    

        switch (triggerName){
            case "LT":
                return (int)(getLTAxis() + cutoff) == 1;
            case "RT":
                return (int)(getRTAxis() + cutoff) == 1;
            default:
                return false;
            
        }
    }

    /** unused but planned direct support for commands in the XboxJoystick class, would work similar to whenPressed for a Button*/
    public void whenXBPressed(String buttonName, final Command command){
    }
}


