package org.firstinspires.ftc.BalloonBattlers;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotlib.robot.BalloonBattlerRobot;
import org.firstinspires.ftc.robotlib.state.Button;
import org.firstinspires.ftc.robotlib.state.ServoState;

@TeleOp(name="Balloon Battler TeleOp", group="Balloon")
public class BalloonBattlerTeleOp extends OpMode
{
    /** Init **/
    private BalloonBattlerRobot robot;
    private Button attackButton;

    /** Constants **/
    private static final double ATTACK_POWER = 0.25;

    @Override
    public void init()
    {
        /** Def **/
        robot = new BalloonBattlerRobot(this.hardwareMap);
        attackButton = new Button();
    }

    @Override
    public void loop()
    {
        /** Update Drivetrain **/
        robot.drivetrain.setThrottle(gamepad1.right_trigger);
        robot.drivetrain.setBrake(gamepad1.left_trigger);
        robot.drivetrain.setRotation(gamepad1.right_stick_x/2);

        /** Update Buttons **/
        attackButton.input(gamepad1.left_bumper);

        /** Move arm **/
        if (attackButton.onPress() && robot.armPopper.getServoState() != ServoState.DOWN)
        { robot.armPopper.setTargetPosition(ServoState.DOWN, ATTACK_POWER); }
        else if (attackButton.onPress())
        { robot.armPopper.setTargetPosition(ServoState.UP, ATTACK_POWER); }

        /** Telemetry **/
        telemetry.addData("Throttle", robot.drivetrain.getThrottle());
        telemetry.addData("Rotation", robot.drivetrain.getRotation());
        telemetry.addData("Popper State", robot.armPopper.getServoState());
    }
}
