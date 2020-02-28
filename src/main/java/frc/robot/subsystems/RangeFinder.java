/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
//import edu.wpi.first.wpilibj.AnalogInput;
//import edu.wpi.first.wpilibj.PWM;
//import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class RangeFinder extends Subsystem {
  // factor to convert sensor values to a distance in inches

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Ultrasonic m_ultrasonic = new Ultrasonic(8, 9);

  public RangeFinder(){
    m_ultrasonic.setEnabled(true);
    m_ultrasonic.setAutomaticMode(true);    
  }

  public double getDistance() {
    // sensor returns a value from 0-4095 that is scaled to inches
    //System.out.println(m_ultrasonic.getRangeInches());
    return m_ultrasonic.getRangeInches();
    }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
   

  }
}
