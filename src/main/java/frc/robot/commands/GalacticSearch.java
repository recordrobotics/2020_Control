package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.Odometry;

public class GalacticSearch extends CommandGroup {

    private double velocity;
    private path selectedPath;

    //starting coordinates
    private double[] redA_init = {0, 2.286};
    private double[] blueA_init = {0.0, 0.7};

    private double[] redB_init = {0.5, 3.81};
    private double[] blueB_init = {0.5, 1.524};

    //Object declarations
    public enum path {
        A_RED,
        B_RED,
        A_BLUE,
        B_BLUE
    };

    public GalacticSearch() {
        velocity = SmartDashboard.getNumber("Autonomous Velocity", 2);
        SmartDashboard.putBoolean("Acquistion", Robot.acq.isAcqOn());
        //addParallel(new TiltAcquisition());
        selectedPath = Robot.path_chooser.getSelected();
    }

    @Override
    protected void initialize(){
        switch (selectedPath) {
            case A_RED:
                Robot.odometry.reset(redA_init[0], redA_init[1]);
                System.out.println("GALSEARCH A REDPATH CALLED");
                GalSearchA pathARed = new GalSearchA(true, velocity);
                
                break;
            case B_RED:
                Robot.odometry.reset(redB_init[0], redB_init[1]);
                GalSearchB pathBRed = new GalSearchB(false, velocity);
            case A_BLUE:
                Robot.odometry.reset(blueA_init[0], blueA_init[1]);
                GalSearchA pathABlue = new GalSearchA(false, velocity);
            case B_BLUE:
                Robot.odometry.reset(blueB_init[0], blueB_init[1]);
                GalSearchB pathBBlue = new GalSearchB(false, velocity);
        }
    }
    @Override
    protected boolean isFinished() {
        return true;
    }

    private void redA_path(){
        addSequential(new CircularTrajectory(-2, Math.PI/12, velocity));
        addParallel(new PickUpBall(2));
        addSequential(new CircularTrajectory(1.5, Math.PI/2.5, velocity));
        addParallel(new PickUpBall(3));
        addSequential(new CircularTrajectory(-1.5, Math.PI/4, velocity));
        addSequential(new CircularTrajectory(-0.5, 11*Math.PI/12, velocity));
        addParallel(new PickUpBall(2));
        addSequential(new CircularTrajectory(1.25, Math.PI/2, velocity));
        addSequential(new CircularTrajectory(1.75, Math.PI/2.75, velocity*1.25));
        addSequential(new CircularTrajectory(-4.5, Math.PI/6, velocity*1.25));
    }
    private void blueA_path(){
        addSequential(new MoveForward(132, velocity));
        addParallel(new PickUpBall(2));
        addSequential(new CircularTrajectory(-0.9, 5*Math.PI/6, velocity));
        addParallel(new PickUpBall(2));
        addSequential(new CircularTrajectory(0.8, 5*Math.PI/6, velocity));
        addParallel(new PickUpBall(2));
        addSequential(new CircularTrajectory(-3, Math.PI/3));
    }

    private void redB_path(){
        addParallel(new PickUpBall(2));
        addSequential(new CircularTrajectory(2.5, Math.PI/3, velocity));

        addParallel(new PickUpBall(2));
        addSequential(new CircularTrajectory(-1, Math.PI - 1, velocity));

        addParallel(new PickUpBall(2));
        addSequential(new MoveForward(60, 0.7));

        addSequential(new CircularTrajectory(3, Math.PI/3.5, velocity));
    }
    private void blueB_path(){
        addParallel(new PickUpBall(3));
        addSequential(new MoveForward(134, 0.7));
        addSequential(new CircularTrajectory(-1.5, Math.PI/2));

        addParallel(new PickUpBall(1));
        addSequential(new CircularTrajectory(0.5, Math.PI/1.4));

        addParallel(new PickUpBall(2));
        addSequential(new MoveForward(60, 0.7));
        addSequential(new CircularTrajectory(-0.5, Math.PI));
        
    }
}
