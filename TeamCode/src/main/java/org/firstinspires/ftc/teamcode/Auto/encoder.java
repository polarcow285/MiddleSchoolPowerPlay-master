package org.firstinspires.ftc.teamcode.Auto;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Projects.ProjectShortage;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="encoders")
//"tag" that is displayed on driver hub
public class encoder extends LinearOpMode {
    //creating robot object
    //the project name will be different, make sure to change this line below to proper name and also in the imports
    public ProjectShortage robot = new ProjectShortage();

    @Override
    public void runOpMode() throws InterruptedException {
        //initialize hardware map
        robot.init(hardwareMap);
        robot.fRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.fLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.bRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.bLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //wait for start button to be pressed
        waitForStart();

        //write autonomous code here

        //record number of encoder counts for certain distances
        //"blank" encoder counts = 1 tile
        //"blank" encoder counts = 90 degree turn

        //speed, leftCounts, rightCounts
        encoderDrive (1, 200, 200, 200, 200);


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
