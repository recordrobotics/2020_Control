package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class Odometry extends Subsystem {

    Pose2d initialPosition;
    DifferentialDriveOdometry odometry;
    Field2d field = new Field2d();

    double xInit, yInit, thetaInit;

    public Odometry(double x, double y, double theta){
        xInit = x;
        yInit = y;
        thetaInit = theta;

        initialPosition = new Pose2d(xInit, yInit, new Rotation2d(thetaInit));

        odometry = new DifferentialDriveOdometry(
            new Rotation2d(Robot.gyro.getRad()),
            initialPosition
        );

        SmartDashboard.putData(field);
    }

    public Odometry(){
        this(0, 0, 0);
    }

    @Override
    protected void initDefaultCommand() {
        //no default command
    }

    @Override
    public void periodic() {
        odometry.update(
            new Rotation2d(Robot.gyro.getRad()),
            -Robot.driveTrain.getLeftEncoder() / 39.37,
            Robot.driveTrain.getRightEncoder() / 39.37
        );

        field.setRobotPose(odometry.getPoseMeters());
    }

    public void reset(){
        odometry.resetPosition(new Pose2d(xInit, yInit, new Rotation2d(thetaInit)), new Rotation2d(0.0));
        Robot.driveTrain.resetEncoders();
    }
}
