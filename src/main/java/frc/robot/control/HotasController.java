package frc.robot.control;
import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class HotasController extends Controller{
	public Joystick hotas;
	

	public HotasController(){
		hotas = new Joystick(RobotMap.hotasPort);
	}

	public double getZ(){
		return hotas.getTwist();
	}

	public double getYAxis(){
		//it's negative because all the way forward is -1
		return -hotas.getY(Hand.kRight);
	}

	public double getXAxis(){
		return hotas.getX(Hand.kRight);
	}
}