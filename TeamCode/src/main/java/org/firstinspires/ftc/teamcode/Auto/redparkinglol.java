package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Projects.ProjectShortage;


//name that appears on the driver hub screen
@Autonomous(name = "Red Parking LoL")
public class redparkinglol extends LinearOpMode {
    //making a robot from project file (hardware map)
    public ProjectShortage robot = new ProjectShortage();

    @Override
    public void runOpMode() throws InterruptedException {
        //initialize hardware map
        robot.init(hardwareMap);

        waitForStart();
        //autonomous happens here
        robot.bRight.setPower(1);
        robot.bLeft.setPower(1);
        robot.fRight.setPower(1);
        robot.fLeft.setPower(1);
        sleep(2000); //need to test!!!!
        robot.bRight.setPower(0);
        robot.bLeft.setPower(0);
        robot.fRight.setPower(0);
        robot.fLeft.setPower(0);
        robot.clamp_lol.setPosition(0);
        robot.clamp_mochi.setPosition(1);
    }
}
