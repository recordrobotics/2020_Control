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
import frc.robot.commands.MoveForward;
import frc.robot.commands.TurnToGoal;
import frc.robot.control.XboxJoystick;
import frc.robot.control.XboxMap;
import frc.robot.control.Controller;
import frc.robot.control.ButtonMap;
import frc.robot.commands.TiltAcquisition;

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

    //control autoTurning with blue buttons
    double dirMult = 1; //change to -1 if the right button makes robot turns left and vice-versa - DO NOT SET TO ANY VALUE OTHER THAN 1 OR -1
    double xboxDirMult = 1; //change to -1 if the right button for the Xbox controller makes robot turns left and vice-versa - DO NOT SET TO ANY VALUE OTHER THAN 1 OR -1
   /* int autoRightButton = ButtonMap.turn90Right; //button to use for turing the robot 90 degrees to the right
    int autoLeftButton = ButtonMap.turn90Left; //button to use for turing the robot 90 degrees to the left
    String autoRightXboxButton = XboxMap.aTurnRStr; //Xbox button to use for turing the robot 90 degrees to the right
    String autoLeftXboxButton = XboxMap.aTurnLStr; //Xbox button to use for turing the robot 90 degrees to the left
    */
    /*
    buttonPanel.getButton(autoRightButton).whenPressed(new AutoTurn(90 * dirMult)); //right turn
    buttonPanel.getButton(autoLeftButton).whenPressed(new AutoTurn(90 * -dirMult)); //left turn
    xbox.getButton(autoLeftXboxButton).whenPressed(new AutoTurn(90 * -xboxDirMult)); //left turn
    xbox.getButton(autoRightXboxButton).whenPressed(new AutoTurn(90 * xboxDirMult)); //right turn
    */
    //xbox.getButton("B").whenPressed(new MoveForward(24, -0.3));
    buttonPanel.getButton(ButtonMap.mainButton).whenPressed(new TurnToGoal());
    buttonPanel.getButton(ButtonMap.tiltAcquisition).whenPressed(new TiltAcquisition());
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
