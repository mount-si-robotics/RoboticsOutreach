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
        robot.drivetrain.setRotation(gamepad1.right_stick_x);

        /** Update Buttons **/
        attackButton.input(gamepad1.left_bumper);

        /** Move arm **/
        if (attackButton.onPress() && robot.armPopper.getServoState() != ServoState.DOWN)
        {
            robot.armPopper.setTargetPosition(ServoState.DOWN, 1);
        }
        else if (attackButton.onPress())
        {
            robot.armPopper.setTargetPosition(ServoState.UP, 1);
        }

        /** Telemetry **/
        telemetry.addData("Throttle", robot.drivetrain.getThrottle());
        telemetry.addData("Rotation", robot.drivetrain.getRotation());
        telemetry.addData("Popper State", robot.armPopper.getServoState());
    }
}
