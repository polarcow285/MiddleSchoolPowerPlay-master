package org.firstinspires.ftc.teamcode.Projects;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;


//hardware map file
public class ProjectShortage extends Project{
    public DcMotor right = null;
    public DcMotor left = null;

    @Override
    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        //Define and Initialize Motors
        right = hwMap.dcMotor.get("right");
        left = hwMap.dcMotor. get("left");

        //Setup Motor directions and Encoder settings
        right.setDirection(DcMotor.Direction.FORWARD);
        left.setDirection(DcMotor.Direction.REVERSE);

        right.

        // Set all motors to zero power

    }

    public void Stop(){


    }
}
