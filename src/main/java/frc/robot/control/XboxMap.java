package frc.robot.control;

public final class XboxMap{

    private static int aButton = 1;
    private static int bButton = 2;
    private static int xButton = 3;
    private static int yButton = 4;
    private static int rBumper = 6;
    private static int lBumper = 5;
    private static int rightStickYUp = 7;
    private static int rightStickYDown = 8;
    private static int rightStickXUp = 9;
    private static int rightStickXDown = 10;
    /**
     * Port value for auto turn left button
     */
    public static int aTurnLNum = lBumper;
    /**
     * Port value for auto turn right button
     */
    public static int aTurnRNum = rBumper;

    /**
     * Abbreviated name for auto turn left button
     */
    public static String aTurnLStr = "LB";
    /**
     * Abbreviated name for auto turn right button
     */
    public static String aTurnRStr = "RB";

}