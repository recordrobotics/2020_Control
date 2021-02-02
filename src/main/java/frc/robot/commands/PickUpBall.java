package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PickUpBall extends Command {

    private double time;

    public PickUpBall(double t){
        time = t;
    }

    public PickUpBall(){
        this(1);
    }

    /** Called just before this Command runs the first time*/
    @Override
    protected void initialize() {
    }

    /** Called repeatedly when this Command is scheduled to run*/
    @Override 
    protected void execute() {
        Robot.acq.moveAcq(-0.5);
        Robot.belt.moveBelt(0.6);
    }

    /** Make this return true when this Command no longer needs to run execute()*/
    @Override
    protected boolean isFinished() {
        return this.timeSinceInitialized() >= time;
    }

    /** Called once after isFinished returns true*/
    @Override
    protected void end() {
        Robot.acq.moveAcq(0);
        Robot.belt.moveBelt(0);
    }

    /**
    *   Called when another command which requires one or more of the same
    *   subsystems is scheduled to run
    */
    @Override
    protected void interrupted() {
    }
    
}
