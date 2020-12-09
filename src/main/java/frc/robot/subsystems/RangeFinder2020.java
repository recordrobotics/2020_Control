/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

/**
*import edu.wpi.first.wpilibj.AnalogInput;
*import edu.wpi.first.wpilibj.PWM;
*import edu.wpi.first.wpilibj.SerialPort;
*/
import edu.wpi.first.wpilibj.Ultrasonic;

/**import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;*/

/**
 * Subsystem class for the RangeFinder
 */
public class RangeFinder2020 extends RangeFinder {
  /**
   * factor to convert sensor values to a distance in inches
   */
  private Ultrasonic m_ultrasonic = new Ultrasonic(8, 9);

  /**
   * Method that enables the rangefinder
   */
  public RangeFinder2020() {
    m_ultrasonic.setEnabled(true);
    m_ultrasonic.setAutomaticMode(true);
  }

  /**
   * @return the range from 0-4095 that is scaled to inches
   */
  public double getDistance() {
    /** System.out.println(m_ultrasonic.getRangeInches()); */
    return m_ultrasonic.getRangeInches();
  }

}
