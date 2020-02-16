package org.firstinspires.ftc.robotlib.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotlib.drivetrain.ArcadeDrivetrain;
import org.firstinspires.ftc.robotlib.motor.LimitedMotor;

public class LauncherRobot {
    public LimitedMotor yawMotor;
    public LimitedMotor pitchMotor;
    private DcMotor launcherMotor; // honestly don't remember this one

    private DigitalChannel digitalTouchSensor;

    // Robot variables
    private final HardwareMap hwMap;

    public LauncherRobot(HardwareMap hwMap) {
        // Hardware ref
        this.hwMap = hwMap;

        // Motor Init
        yawMotor = new LimitedMotor(hwMap.get(DcMotor.class, "yaw_motor"), 0, 100);
        pitchMotor = new LimitedMotor(hwMap.get(DcMotor.class, "pitch_motor"), 0, 100);
        launcherMotor = hwMap.get(DcMotor.class, "launcher_motor");

        yawMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        pitchMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        yawMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        pitchMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        yawMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        pitchMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Touch Sensor Init
        digitalTouchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");

        digitalTouchSensor.setMode(DigitalChannel.Mode.INPUT);
    }

    public boolean isTouchSensorPressed() {
        return !digitalTouchSensor.getState();
    }
}
