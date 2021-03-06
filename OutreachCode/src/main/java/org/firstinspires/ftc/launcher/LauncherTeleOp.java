package org.firstinspires.ftc.launcher;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotlib.robot.LauncherRobot;
import org.firstinspires.ftc.robotlib.state.Button;

@TeleOp(name="Launcher TeleOp", group="teleop")
public class LauncherTeleOp extends OpMode {
    private LauncherRobot robot;

    // State
    private boolean powerShooterMotors;

    // Input
    private Button yButton;

    @Override
    public void init() {
        robot = new LauncherRobot(hardwareMap);

        yButton = new Button();
    }

    @Override
    public void loop() {
        robot.yawMotor.setPower(-gamepad1.right_stick_x);
        robot.pitchMotor.setPower(-gamepad1.left_stick_y);

        if (powerShooterMotors) {
            robot.setLauncherMotorPowers(gamepad1.right_trigger / 2 + 0.5);
        } else {
            robot.setLauncherMotorPowers(0.0);
        }

        if (yButton.onRelease()) powerShooterMotors = !powerShooterMotors;

        yButton.input(gamepad1.y);
    }
}
