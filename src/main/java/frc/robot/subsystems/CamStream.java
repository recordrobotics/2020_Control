/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.CamControl;

/**
 * Allows for use of the Camera in the RoboRio code
 * A lot of camera stuff is done on the raspberry pi in Python
 */
public class CamStream extends Subsystem {
    /**Objects representing the camera and its networktable */
    private UsbCamera[] camera;
    private NetworkTableEntry cameraSelection;

    /**
     * @param numCameras number of cameras to initialize
     * Constructor, initialize all the cameras and get the appropriate table from the network
     * */
    public CamStream(int numCameras){
        camera = new UsbCamera[numCameras];

        if (Robot.isReal()){
            for (int i = 0; i < numCameras; i++){
                camera[i] = CameraServer.getInstance().startAutomaticCapture(0);
                camera[i].setResolution(512, 288);
            }

            cameraSelection = NetworkTableInstance.getDefault().getTable("").getEntry("CameraSelection");
        }
    }

    /**default constructor */
    public CamStream(){
        this(1);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new CamControl());
    }

    /**
     * @param cameraNum which camera to set
     * Sets the network to a certain camera
     */
    public void setCamera(int cameraNum){
        cameraSelection.setString(camera[cameraNum].getName());
    }
}
