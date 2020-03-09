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
import frc.robot.commands.CamControl;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class CamStream extends Subsystem {
  
    private UsbCamera[] camera;
    private NetworkTableEntry cameraSelection;

    public CamStream(int numCameras){
        camera = new UsbCamera[numCameras];

        for (int i = 0; i < numCameras; i++){
            camera[i] = CameraServer.getInstance().startAutomaticCapture(0);
            camera[i].setResolution(512, 288);
        }

        cameraSelection = NetworkTableInstance.getDefault().getTable("").getEntry("CameraSelection");
    }

    public CamStream(){
        this(1);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new CamControl());
    }

    public void setCamera(int cameraNum){
        cameraSelection.setString(camera[cameraNum].getName());
    }
}
