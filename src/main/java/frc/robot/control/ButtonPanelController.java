package frc.robot.control;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;


/**
 * creates a new instance of a button pannel and links it to the button port
 * creates a new instance of the buttons on the joystick
 * creates an instance of a button for each physical button
 * has a function for getting the values of a given button
 */
public class ButtonPanelController{
	private static final int NUM_BUTTONS = 10;

	public Joystick buttonPanel;
	private JoystickButton[] buttons;
	

	public ButtonPanelController(){
		buttonPanel = new Joystick(RobotMap.buttonPanelPort);
		buttons = new JoystickButton[NUM_BUTTONS];

		/**instantiate buttons*/
		for(int i = 0; i < NUM_BUTTONS; i++){
			buttons[i] = new JoystickButton(buttonPanel, i);
		}
		
	}

	public JoystickButton getButton(int button){
		return buttons[button];
	}


	/** 
	get states
	*/
/**
*	I don't know if getState works
*	if it doesn't, do a toggle!
*  gets the state of a certain numbered button
*  checks whether a certain numbered button is pressed
*  checks whether a certain numbered button is released
*/
	public boolean getState(int button){
		return getButton(button).get();
	}

	public boolean getPressed(int button){
		return buttonPanel.getRawButtonPressed(button);
	}

	public boolean getReleased(int button){
		return buttonPanel.getRawButtonReleased(button);
	}


	

	






}