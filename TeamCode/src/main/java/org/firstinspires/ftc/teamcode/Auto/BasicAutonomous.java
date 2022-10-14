package org.firstinspires.ftc.teamcode.Auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Projects.ProjectShortage;

//name that appears on the driver hub screen
@Autonomous(name = "Basic Autonomous")
public class BasicAutonomous extends LinearOpMode{

    //making a robot from project file (hardware map)
    public ProjectShortage robot = new ProjectShortage();

    @Override
    public void runOpMode() throws InterruptedException {
        //initialize hardware map
        robot.init(hardwareMap);

        waitForStart();
        //autonomous happens here

    }

}
