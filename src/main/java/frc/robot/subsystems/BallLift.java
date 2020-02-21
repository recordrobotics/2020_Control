package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;  
import edu.wpi.first.wpilibj.DigitalInput;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.commands.*;

public class BallLift extends Subsystem {
  private WPI_VictorSPX beltMotor = new WPI_VictorSPX(RobotMap.beltMotorPort);


  //array of limit switches that are triggered when a ball occupies it's slot
  private DigitalInput[] ballLimits = new DigitalInput[5];
  
  public BallLift() {
    //instance of limit switches
    int offset = 0;
    //ballLimits = new DigitalInput [5];
    for (int i = 0; i < ballLimits.length; i++){
      //ballLimits[i] = new DigitalInput(i + offset);
    }
  }
  
  public void initDefaultCommand() {
      setDefaultCommand(new BeltControl());
  }
  
  public void moveBelt(double v){
    beltMotor.set(ControlMode.PercentOutput, v);
  }

  public int lowestFullSlot(){
    int lowest = ballLimits.length - 1;
    for(int i = ballLimits.length - 1; i >= 0; i--){
      if (ballLimits[i].get()){
        lowest = i;
      }
    }
    return lowest;
  }
  
  public int highestFullSlot(){
    int highest = 0;
    for(int i = 0; i < ballLimits.length; i++){
      if (ballLimits[i].get()){
        highest = i;
      }
    }
    return highest;
  }
  public int countBall(){
    int count = 0;

    for (DigitalInput limit : ballLimits){
      if (limit.get()){
        count++;
      }
    }

    return count;
  }  

  public boolean getSlot(int slot){
    return ballLimits[slot].get();
  }
}
