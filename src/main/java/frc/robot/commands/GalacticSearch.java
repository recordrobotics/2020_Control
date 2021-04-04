package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.Odometry;

public class GalacticSearch extends CommandGroup {

    private double velocity;
    private path selectedPath;

    private double ballDistance;

    /**
     * Distance to balls: 
     * Red path A: 5 units 
     * Blue path A: 7 units
     * Red path B: 3 units
     * Blue path B: 6 units
     */
    //starting coordinates
    private double[] redA_init = {0.3, 1.524};
    private double[] blueA_init = {0.3, 3.048};

    private double[] redB_init = {0.3, 3.048};
    private double[] blueB_init = {0.3, 1.524};


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

        ballDistance = SmartDashboard.getNumber("Distance to Ball", -1);
        double error = 6; //inches

        selectedPath = Robot.path_chooser.getSelected();
        
        switch (selectedPath) {
            case A_RED:
                Robot.odometry.reset(redA_init[0], redA_init[1]);
                GalSearchA pathARed = new GalSearchA(true, velocity);
                pathARed.start();
                break;

            case B_RED:
                Robot.odometry.reset(redB_init[0], redB_init[1]);
                GalSearchB pathBRed = new GalSearchB(true, velocity);
                pathBRed.start();
                break;

            case A_BLUE:
                Robot.odometry.reset(blueA_init[0], blueA_init[1]);
                GalSearchA pathABlue = new GalSearchA(false, velocity);
                pathABlue.start();
                break;

            case B_BLUE:
                Robot.odometry.reset(blueB_init[0], blueB_init[1]);
                GalSearchB pathBBlue = new GalSearchB(false, velocity);
                pathBBlue.start();
                break;
        }
    }
    @Override
    protected boolean isFinished() {
        return true;
    }
}
