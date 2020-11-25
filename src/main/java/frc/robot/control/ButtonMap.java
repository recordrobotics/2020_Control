package frc.robot.control;


/** 
* this class contains the button panel assignments
* assigns each of the numbered inputs for the button pannel to their appropriate color/locations pairs
* then assigns each of the colored names to what their function is 
*/
public final class ButtonMap {

	private static int greenLeft = 1;
	private static int greenRight = 2;
	private static int yellowLeft = 3;
	private static int yellowRight = 4;
	private static int redLeft = 7;
	private static int redRight = 5;
	private static int blueLeft = 8;
	private static int blueRight = 9;
	private static int white = 6;

	public static int liftRaise = greenLeft;
	public static int liftLower = greenRight;
	public static int mainButton = white;
	public static int LiftOverrideDown = yellowRight;
	public static int LiftOverrideUp = yellowLeft;
	public static int winchUp = redLeft;
	public static int winchDown = redRight;
	public static int blueTempNameRight = blueRight;
	public static int blueTempNameLeft = blueLeft;

}