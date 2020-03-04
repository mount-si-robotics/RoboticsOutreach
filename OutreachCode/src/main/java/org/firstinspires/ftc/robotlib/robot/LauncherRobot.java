package org.firstinspires.ftc.robotlib.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotlib.motor.LimitedMotor;

public class LauncherRobot {
    public LimitedMotor rightLaunch;
    public LimitedMotor leftLaunch;
    public LimitedMotor yawMotor;
    public LimitedMotor pitchMotor;

    // Robot variables
    private final HardwareMap hwMap;

    public LauncherRobot(HardwareMap hwMap) {
        // Hardware ref
        this.hwMap = hwMap;

        // Motor Init
        rightLaunch = new LimitedMotor(hwMap.get(DcMotor.class, "right_launch"), 0, 100);
        leftLaunch = new LimitedMotor(hwMap.get(DcMotor.class, "left_launch"), 0, 100);
        yawMotor = new LimitedMotor(hwMap.get(DcMotor.class, "yaw_motor"), 0, 100);
        pitchMotor = new LimitedMotor(hwMap.get(DcMotor.class, "pitch_motor"), 0, 100);

        rightLaunch.setDirection(DcMotorSimple.Direction.REVERSE);
        leftLaunch.setDirection(DcMotorSimple.Direction.FORWARD);
        yawMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        pitchMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        rightLaunch.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftLaunch.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        yawMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        pitchMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightLaunch.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftLaunch.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        yawMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        pitchMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setLauncherMotorPowers(double power) {
        this.rightLaunch.setPower(power);
        this.leftLaunch.setPower(power);
    }
}
