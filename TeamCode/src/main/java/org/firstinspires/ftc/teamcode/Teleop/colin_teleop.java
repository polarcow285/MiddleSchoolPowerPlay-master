package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Projects.ProjectShortage;

@TeleOp(name="Colin Teleop")
public class colin_teleop extends LinearOpMode {
    //making a robot from project file (hardware map)
    public ProjectShortage robot = new ProjectShortage();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {
            double y = -gamepad1.right_stick_y; // Back and forth
            double x = gamepad1.right_stick_x * 1.1; // strafing
            double rx = -gamepad1.left_stick_x; // turning

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            robot.fLeft.setPower(frontLeftPower);
            robot.bLeft.setPower(backLeftPower);
            robot.fRight.setPower(frontRightPower);
            robot.bRight.setPower(backRightPower);


            //teleop goes here (gamepad controls, etc)
              if (gamepad1.right_trigger > 0) { // go up
                //robot.lift_lol.setPower(gamepad1.right_trigger);
                robot.lift_mochi.setPower(gamepad1.right_trigger);

            }
             else if (gamepad1.left_trigger > 0) {  // go down
                //robot.lift_lol.setPower(-gamepad1.left_trigger);
                robot.lift_mochi.setPower(-gamepad1.left_trigger);

            } else {
                //robot.lift_lol.setPower(0);
                robot.lift_mochi.setPower(0);
            }
            if (gamepad1.a) {
                robot.clamp_lol.setPosition(1); //0
                robot.clamp_mochi.setPosition(1);

            }
            else if (gamepad1.b) {
                robot.clamp_lol.setPosition(0); //105
                robot.clamp_mochi.setPosition(0);


            }
        }
    } }
