/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.control.ButtonPanelController;
import frc.robot.control.HotasController;
import frc.robot.commands.AutoTurn;
import frc.robot.commands.BallUpOne;
import frc.robot.commands.BeltAutoRun;
import frc.robot.commands.MoveForward;
import frc.robot.commands.MoveToAim;
import frc.robot.commands.MoveToFire;
import frc.robot.commands.MoveToRange;
import frc.robot.commands.TurnToGoal;
import frc.robot.control.XboxJoystick;
//import frc.robot.control.XboxMap;
import frc.robot.control.Controller;
import frc.robot.control.ButtonMap;
import frc.robot.commands.TiltAcquisition;
import frc.robot.commands.TurnToAngle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private static ButtonPanelController buttonPanel = new ButtonPanelController();
  private static HotasController hotas = new HotasController();
  private static XboxJoystick xbox = new XboxJoystick();
  private static Controller joystick = xbox;

  boolean enablePID = false; //do not set to true unless you know what you are doing. It causes issues. 
  

  public OI(){
    // buttonPanel
    buttonPanel.getButton(ButtonMap.mainButton).whenPressed(new MoveToAim(Robot.shootingDistance));
    buttonPanel.getButton(ButtonMap.tiltAcquisition).whenPressed(new TiltAcquisition());
    buttonPanel.getButton(ButtonMap.beltUpOne).whenPressed(new BallUpOne());
  }

  /*
  * * * * * * * * * * * * * * 
  * HELPER METHODS          *
  * * * * * * * * * * * * * *
  */ 
  
  //simple logrithmic curve
  public static double sCurve(double value){
    double e = 2.718;
    return (1 / (1 + Math.pow(e, value))) * 2 - 1;
  }


  /*
  more complex method to get a curve with a deadzone - graph at;
  https://www.desmos.com/calculator/qs1u1uacir
  */
  public static double accCurve(double value){
    double output;
    double e = 2.718;
    output = 2/(1 + Math.pow(e, -8 * value)) - 1 - 4 * value;
    output *= (-25.6 * value * value)/((1+(16 * value * value)) * Math.abs(4 * value));
    output = 4 * sCurve(0.5 * output);
    return output;
  }


  /*
  * * * * * * * * * * * * * *
  * INPUT HANDELING METHODS *
  * * * * * * * * * * * * * *
  */

  /**
   * Gets the state a button of the specific XboxJoystick instance xbox, basically an extension of {@link XboxJoystick#getButtonState(buttonName) getButtonState()} specifically for the instance xbox
   * @param buttonName The abbreviation for the button <p> Accepted inputs are A, B, X, Y, LB, RB, LT, RT
   * @return Whether or not the buttton buttonName is pressed, unaccepted inputs will return false
   */
  public static boolean getXboxButtonState(String buttonName){
    return xbox.getButtonState(buttonName);
  }

  public static boolean getPanelButtonState(int button){
    return buttonPanel.getState(button);
  }


  public static double getForward(){
    return joystick.getYAxis();
  }

  public static double getTurn(){
    return joystick.getXAxis();

  }
  //temp
  public static int getLiftMotion(){
    int out = 0;
    out += (1);
    return out;
  }


}
