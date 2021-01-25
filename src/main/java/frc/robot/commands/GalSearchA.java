package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class GalSearchA extends CommandGroup {

    private double velocity;
    private boolean redPath = true;

    public GalSearchA(double v){
        velocity = v;
        redPath();
    }

    private void bluePath(){

    }

    private void redPath(){
        addSequential(new MoveForward(48, -0.7));
        
        //addParallel(pick up ball) TODO write command that picks up ball and call it here
        addSequential(new MoveForward(18, -0.4));

        addSequential(new CircularTrajectory(1.5, Math.PI/3.25, velocity));
        addSequential(new CircularTrajectory(-0.25, Math.PI - 0.4, velocity));
        addSequential(new MoveForward(48, -0.7));

        //addParallel(pick up ball) TODO write command that picks up ball and call it here
        addSequential(new MoveForward(18, -0.4));
        addSequential(new CircularTrajectory(0.25, Math.PI/2 + 0.75, velocity));   
        
        addSequential(new CircularTrajectory(-14, Math.PI/11, velocity));
    
    }

    @Override
    protected void execute() {
        SmartDashboard.putBoolean("Acquistion", Robot.acq.isAcqOn());
    }
    
}
