/*----------------------------------------------------------------------------*/
/* CopyRight (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;
import edu.wpi.first.wpilibj.SPI;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */


public class RobotMap {
	/**
	 * For example to map the Left and Right motors, you could define the
 	 * Following variables to use with your drivetrain subsystem.
	 * public static int LeftMotor = 1;
	 * public static int RightMotor = 2;
     * If you are using multiple modules, make sure to define both the port
     * number and the module. For example you with a rangefinder:
	 * public static int rangefinderPort = 1;
	 * public static int rangefinderModule = 1;
	 */

	/**
	 * Spark Motors for Monolith
	 */
	public static int driveFrontRightPortMonolith = 2;
	public static int driveFrontLeftPortMonolith = 0;
	public static int driveBackRightPortMonolith = 3;
	public static int driveBackLeftPortMonolith = 1;

	/**
	 * CAN Bus Drive on Monty
	 */
	public static int driveFrontRightPortMonty = 7;
	public static int driveFrontLeftPortMonty = 5;
	public static int driveBackRightPortMonty = 2;
	public static int driveBackLeftPortMonty = 1;

	/**
	 * CAN bus on the 2020 Robot
	 */
	public static int driveFrontRight2020 = 1;
	public static int driveFrontLeft2020 = 2;
	public static int driveBackRight2020 = 3;
	public static int driveBackLeft2020 = 4;

	/**
	 * Set of subsystem motors 2020, temporary ports, set to real numbers later
	 */
	public static int acquireMotorPort = 8;
	public static int tiltMotorPort = 7;
	public static int beltMotorPort = 6;
	public static int flywheelMotorPort = 5;
	public static int spoolLiftLeftMotor = 10;
	public static int spoolLiftRightMotor = 11;
	public static int robotLiftLeftMotorPort = 9; 

	/**
	 * encoder ports
	 * Format of [Port A, Port B]
	 */
	public static int[] rightDriveEncoder = {0, 1};
	public static int[] leftDriveEncoder = {2, 3};
	
	/**
	 * lifting mechanism port
	 */
	public static int liftPortMonolith = 4;

	/** the controller ports can be found in the driver station*/

	/**
	 * lifting mechanism port
	 */
	public static int buttonPanelPort = 1;
	/**
	 * hotas
	 */
	public static int hotasPort = 0;
	/**
	 * xbox
	 */
	public static int xboxPort = 0;

	/**
	 * gyroscope port
	 */
	public static SPI.Port gyroPortSPI = SPI.Port.kOnboardCS0;

	

}

