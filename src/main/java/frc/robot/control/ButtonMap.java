package frc.robot.control;


/*
* this class contains the button panel assignments
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
	public static int aquire = redLeft;
	public static int eject = redRight;
	public static int togglePID = white;
	public static int turn90Right = yellowRight;
	public static int turn90Left = yellowLeft;
}