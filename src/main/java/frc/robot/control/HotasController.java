package frc.robot.control;
import edu.wpi.first.wpilibj.Joystick;
/** import edu.wpi.first.wpilibj.buttons.JoystickButton;*/
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class HotasController extends Controller{
	//Creates a specific instance of a hotas controller
	public Joystick hotas;
	
	public HotasController(){
		hotas = new Joystick(RobotMap.hotasPort);
	}


	/**
	 * Get the rotation/twist of the Hotas controller
	 * @return The amount the Hotas controller has been twisted as a double
	 */
	public double getZ(){
		return hotas.getTwist();
	}

	/**
	 * Get how far forward the Hotas controller is
	 * @return The amount the Hotas controller has been pushed forward as a double
	 */
	public double getYAxis(){
		/**it's negative because all the way forward is -1*/
		return -hotas.getY(Hand.kRight);
	}

	/**
	 * Get how far to the side the Hotas controller is
	 * @return The amount the Hotas controller has been pushed to the side as a double
	 */
	public double getXAxis(){
		return hotas.getX(Hand.kRight);
	}
}

