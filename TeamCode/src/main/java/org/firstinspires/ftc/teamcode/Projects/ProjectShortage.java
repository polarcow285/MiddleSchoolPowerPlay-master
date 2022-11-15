package org.firstinspires.ftc.teamcode.Projects;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//hardware map file
public class ProjectShortage extends Project{
    public DcMotor fRight = null;
    public DcMotor fLeft = null;
    public DcMotor bRight = null;
    public DcMotor bLeft = null;
    public DcMotor lift_lol = null;
    public DcMotor lift_mochi = null;
    public Servo clamp_lol = null;
    public Servo clamp_mochi = null;
    @Override
    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;


        fLeft = hwMap.dcMotor.get("fLeftWheel");
        fRight = hwMap.dcMotor.get("fRightWheel");
        bLeft = hwMap.dcMotor.get("bLeftWheel");
        bRight = hwMap.dcMotor.get("bRightWheel");
        lift_lol = hwMap.dcMotor.get("liftLOL");
        lift_mochi = hwMap.dcMotor.get("liftMochi");
        clamp_lol = hwMap.servo.get("clampLOL");
        clamp_mochi = hwMap.servo.get("clampMochi");

        //motors face towards each other
        fRight.setDirection(DcMotor.Direction.FORWARD);
        fLeft.setDirection(DcMotor.Direction.REVERSE);
        bRight.setDirection(DcMotor.Direction.FORWARD);
        bLeft.setDirection(DcMotor.Direction.REVERSE);
        lift_lol.setDirection(DcMotor.Direction.FORWARD);
        lift_mochi.setDirection(DcMotor.Direction.FORWARD);
        clamp_lol.setDirection(Servo.Direction.FORWARD);
        clamp_mochi.setDirection(Servo.Direction.REVERSE);

        fRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift_lol.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift_mochi.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        fRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift_lol.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift_mochi.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Stop();

    }

    public void Stop(){
        fRight.setPower(0);
        fLeft.setPower(0);
        bRight.setPower(0);
        bLeft.setPower(0);
        lift_lol.setPower(0);
        lift_mochi.setPower(0);
        clamp_lol.setPosition(0);
        clamp_mochi.setPosition(0);
    }
}