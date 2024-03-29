package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

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


        encoderDrive (1, 200, 200, 200, 200);
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

        robot.lift_mochi.setPower(speed);
        sleep(time);
    }


    //encoder method
    public void encoderDrive(double speed,
                             double fRightCounts, double fLeftCounts, double bRightCounts, double bLeftCounts) {
        int newfLeftTarget;
        int newfRightTarget;
        int newbLeftTarget;
        int newbRightTarget;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newfLeftTarget = robot.fLeft.getCurrentPosition() + (int) (fLeftCounts);
            newfRightTarget = robot.fRight.getCurrentPosition() + (int) (fRightCounts);
            newbLeftTarget = robot.bLeft.getCurrentPosition() + (int) (bLeftCounts);
            newbRightTarget = robot.bRight.getCurrentPosition() + (int) (bRightCounts);
            robot.fLeft.setTargetPosition(newfLeftTarget);
            robot.fRight.setTargetPosition(newfRightTarget);
            robot.bLeft.setTargetPosition(newbLeftTarget);
            robot.bRight.setTargetPosition(newbRightTarget);

            // Turn On RUN_TO_POSITION
            robot.fLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.fRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.bLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.bRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.fLeft.setPower(Math.abs(speed));
            robot.fRight.setPower(Math.abs(speed));
            robot.bLeft.setPower(Math.abs(speed));
            robot.bRight.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (opModeIsActive() &&
                    (robot.fLeft.isBusy() && robot.fRight.isBusy() && robot.bLeft.isBusy() && robot.bRight.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Path1", "Running to %7d :%7d", newfLeftTarget, newfRightTarget, newbLeftTarget, newbRightTarget);
                telemetry.addData("Path2", "Running at %7d :%7d",
                        robot.fLeft.getCurrentPosition(),
                        robot.fRight.getCurrentPosition(),
                        robot.bLeft.getCurrentPosition(),
                        robot.bRight.getCurrentPosition());


                telemetry.update();
            }

            // Stop all motion;
            robot.fLeft.setPower(0);
            robot.fRight.setPower(0);
            robot.bLeft.setPower(0);
            robot.bRight.setPower(0);

            // Turn off RUN_TO_POSITION
            robot.fLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.fRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.bLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.bRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
}

