package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Projects.ProjectShortage;

@TeleOp(name="Teleop")
public class Teleop extends LinearOpMode {
    //making a robot from project file (hardware map)
    public ProjectShortage robot = new ProjectShortage();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {
            //teleop goes here (gamepad controls, etc)
            robot.right.setPower(gamepad1.right_stick_y);
            robot.left.setPower(-gamepad1.left_stick_y);

            if (gamepad1.x) {
                robot.lift_lol.setPower(1);
                robot.lift_mochi.setPower(1);

            } else{
                robot.lift_lol.setPower(0);
                robot.lift_mochi.setPower(0);
            }
            if(gamepad1.y) {
                robot.lift_lol.setPower(-1);
                robot.lift_mochi.setPower(-1);

            } else{
                robot.lift_lol.setPower(0);
                robot.lift_mochi.setPower(0);
            }
            if(gamepad1.a) {
                robot.clamp_lol.setPosition(1);
                robot.clamp_mochi.setPosition(1);

            }
            if(gamepad1.b) {
                robot.clamp_lol.setPosition(-1);
                robot.clamp_mochi.setPosition(-1);
            }
        }
    } }