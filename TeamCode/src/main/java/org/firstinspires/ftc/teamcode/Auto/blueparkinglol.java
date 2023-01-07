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
        robot.clamp_lol.setPosition(0);
        robot.clamp_mochi.setPosition(0);
        mufasa(1000, 0);
        mufasa(1248, 1);
        mufasa(1000, 0);
        turningRed(34, 1);
        mufasa(1000, 0);
        lifty(1000, 1);
        mufasa(1000, 0);
        robot.clamp_lol.setPosition(1);
        robot.clamp_mochi.setPosition(1);
        lifty(1000, -1);

    }

    public void mufasa(int time, int speed) { //forward
        robot.bRight.setPower(speed);
        robot.bLeft.setPower(speed);
        robot.fRight.setPower(speed);
        robot.fLeft.setPower(speed);
        sleep(time);
    }

    public void turningRed(int time, int speed) { // turn
        robot.bRight.setPower(speed);
        robot.bLeft.setPower(-speed);
        robot.fRight.setPower(speed);
        robot.fLeft.setPower(-speed);
        sleep(time);
    }

    public void lifty(int time, int speed) { // lift
        robot.lift_lol.setPower(speed);
        robot.lift_mochi.setPower(speed);
        sleep(time);
    }
}