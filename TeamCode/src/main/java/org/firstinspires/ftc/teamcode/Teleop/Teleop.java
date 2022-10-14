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


        }
    }
}
