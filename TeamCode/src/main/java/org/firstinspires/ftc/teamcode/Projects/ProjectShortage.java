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


        left = hwMap.dcMotor.get("leftWheel");
        right = hwMap.dcMotor.get("rightWheel");

        right.setDirection(DcMotor.Direction.FORWARD);
        left.setDirection(DcMotor.Direction.REVERSE);

        right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void Stop(){


    }
}
