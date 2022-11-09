package org.firstinspires.ftc.teamcode.Projects;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//hardware map file
public class ProjectShortage extends Project{
    public DcMotor right = null;
    public DcMotor left = null;
    public DcMotor lift_lol = null;
    public DcMotor lift_mochi = null;
    public Servo clamp_lol = null;
    public Servo clamp_mochi = null;
    @Override
    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;


        left = hwMap.dcMotor.get("leftWheel");
        right = hwMap.dcMotor.get("rightWheel");
        lift_lol = hwMap.dcMotor.get("liftLOL");
        lift_mochi = hwMap.dcMotor.get("liftMochi");
        clamp_lol = hwMap.servo.get("clampLOL");
        clamp_mochi = hwMap.servo.get("clampMochi");

        //motors face towards each other
        right.setDirection(DcMotor.Direction.FORWARD);
        left.setDirection(DcMotor.Direction.REVERSE);
        lift_lol.setDirection(DcMotor.Direction.FORWARD);
        lift_mochi.setDirection(DcMotor.Direction.FORWARD);
        clamp_lol.setDirection(Servo.Direction.FORWARD);
        clamp_mochi.setDirection(Servo.Direction.REVERSE);

        right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift_lol.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift_mochi.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift_lol.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift_mochi.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Stop();

    }

    public void Stop(){
        right.setPower(0);
        left.setPower(0);
        lift_lol.setPower(0);
        lift_mochi.setPower(0);
        clamp_lol.setPosition(0);
        clamp_mochi.setPosition(0);
    }
}