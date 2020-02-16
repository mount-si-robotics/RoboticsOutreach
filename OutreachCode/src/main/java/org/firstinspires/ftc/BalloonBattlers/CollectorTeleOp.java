package org.firstinspires.ftc.BalloonBattlers;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotlib.robot.CollectorRobot;

@TeleOp(name="Collector TeleOp", group="teleop")
public class CollectorTeleOp extends OpMode {
    private CollectorRobot robot;

    @Override
    public void init() {
        robot = new CollectorRobot(hardwareMap);
    }

    @Override
    public void loop() {
        robot.drivetrain.setThrottle(-gamepad1.right_stick_y);
        robot.drivetrain.setBrake(gamepad1.left_trigger);
        robot.drivetrain.setRotation(-gamepad1.left_stick_x/2);

        telemetry.addData("TRIGGER DATA", gamepad1.right_trigger);
        if (gamepad1.right_trigger > 0) robot.collectorMotor.setPower(gamepad1.right_trigger);
        else robot.collectorMotor.setPower(0.0);
    }
}
