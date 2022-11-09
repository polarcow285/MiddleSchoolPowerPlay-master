package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Projects.ProjectShortage;


//name that appears on the driver hub screen
@Autonomous(name = "Blue Parking LoL")
public class blueparkinglol extends LinearOpMode {
    //making a robot from project file (hardware map)
    public ProjectShortage robot = new ProjectShortage();

    @Override
    public void runOpMode() throws InterruptedException {
        //initialize hardware map
        robot.init(hardwareMap);

        waitForStart();
        //autonomous happens here
        robot.right.setPower(-1);
        robot.left.setPower(-1);
        sleep(2000); //need to test!!!!
        robot.right.setPower(0);
        robot.left.setPower(0);
        robot.clamp_lol.setPosition(0);
        robot.clamp_mochi.setPosition(1);
    }
}
