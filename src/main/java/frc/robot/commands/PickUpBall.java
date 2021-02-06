package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PickUpBall extends Command {

    private double time, delay;
    private Timer timer;

    public PickUpBall(double t, double d){
        time = t;
        delay = d;

        timer = new Timer();
    }

    public PickUpBall(double t){
        this(t, 0);
    }

    public PickUpBall(){
        this(1, 0);
    }

    /** Called just before this Command runs the first time*/
    @Override
    protected void initialize() {
        timer.start();
    }

    /** Called repeatedly when this Command is scheduled to run*/
    @Override 
    protected void execute() {
        if (timer.get() > delay){
            Robot.acq.moveAcq(-0.5);
            Robot.belt.moveBelt(0.6);
        }
    }

    /** Make this return true when this Command no longer needs to run execute()*/
    @Override
    protected boolean isFinished() {
        return timer.get() >= time;
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
        end();
    }
    
}
