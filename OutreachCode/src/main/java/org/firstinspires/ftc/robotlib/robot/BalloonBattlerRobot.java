package org.firstinspires.ftc.robotlib.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotlib.drivetrain.ArcadeDrivetrain;
import org.firstinspires.ftc.robotlib.motor.ServoMotor;

public class BalloonBattlerRobot
{
    /** Drive variables **/
    private DcMotor driveRight;
    private DcMotor driveLeft;

    /** Arm variables **/
    public ServoMotor armPopper;

    /** Robot variables **/
    private final HardwareMap hwMap;

    /** Drivetrain **/
    public ArcadeDrivetrain drivetrain;

    public BalloonBattlerRobot(HardwareMap hwMap)
    {
        // Hardware ref
        this.hwMap = hwMap;

        /** Drive Motor Init **/
        driveRight = hwMap.get(DcMotor.class, "driveRight");
        driveLeft = hwMap.get(DcMotor.class, "driveLeft");

        driveRight.setDirection(DcMotorSimple.Direction.REVERSE);
        driveLeft.setDirection(DcMotorSimple.Direction.FORWARD);

        driveRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        driveLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        driveRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        /** Arm Motor Init **/
        armPopper = new ServoMotor(hwMap.get(DcMotor.class, "armPopper"), 0, 0, 250);
        armPopper.setDirection(DcMotorSimple.Direction.FORWARD);
        armPopper.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armPopper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        /** Drivetrain Init **/
        drivetrain = new ArcadeDrivetrain(driveLeft, driveRight);
    }
}
