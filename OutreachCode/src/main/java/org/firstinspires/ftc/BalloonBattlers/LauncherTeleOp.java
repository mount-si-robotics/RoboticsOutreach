package org.firstinspires.ftc.BalloonBattlers;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotlib.robot.LauncherRobot;

@TeleOp(name="Launcher TeleOp", group="teleop")
public class LauncherTeleOp extends OpMode {
    private LauncherRobot robot;

    @Override
    public void init() {
        robot = new LauncherRobot(hardwareMap);
    }

    @Override
    public void loop() {

    }
}
