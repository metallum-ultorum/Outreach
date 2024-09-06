package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "Outreach", group = "TeleOp")
public class OutreachOp extends LinearOpMode {

    @Override
    public void runOpMode() {
        BaseRobot baseRobot = new BaseRobot(hardwareMap, gamepad1, gamepad2, telemetry);
        waitForStart();

        while (opModeIsActive()) {
            baseRobot.driveGamepads();

            if (Settings.Deploy.ODOMETRY) {
                baseRobot.odometry.update();
            }
        }
        baseRobot.shutDown();
    }

}
