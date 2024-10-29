package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@TeleOp(name = "Sensor Test", group = "TeleOp")
public class SensorTest extends LinearOpMode {

    @Override
    public void runOpMode() {
//        BaseRobot baseRobot = new BaseRobot(hardwareMap, gamepad1, gamepad2, telemetry);
        final RevTouchSensor touch;
        final RevColorSensorV3 color;
        touch = hardwareMap.get(RevTouchSensor.class, "touchSensor2");
        color = hardwareMap.get(RevColorSensorV3.class, "colorSensor");
        telemetry.setAutoClear(false);
        Telemetry.Item isTouching = telemetry.addData("touch", false);
        Telemetry.Item red = telemetry.addData("red", 0);
        Telemetry.Item blue = telemetry.addData("blue", 0);
        Telemetry.Item green = telemetry.addData("green", 0);
        Telemetry.Item distance = telemetry.addData("distance", 0);
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            isTouching.setValue(touch.isPressed());
            red.setValue(color.red());
            green.setValue(color.green());
            blue.setValue(color.blue());
            distance.setValue(color.getDistance(DistanceUnit.INCH));
            telemetry.update();
//            baseRobot.driveGamepads();

//            if (Settings.Deploy.ODOMETRY) {
//                baseRobot.odometry.update();
//            }
        }
//        baseRobot.shutDown();
    }

}
