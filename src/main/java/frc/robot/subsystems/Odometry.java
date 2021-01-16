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

    public Odometry(double x, double y, double theta){
        initialPosition = new Pose2d(x, y, new Rotation2d(theta));

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
}
