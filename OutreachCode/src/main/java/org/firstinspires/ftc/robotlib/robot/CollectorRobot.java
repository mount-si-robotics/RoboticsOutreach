package org.firstinspires.ftc.robotlib.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotlib.drivetrain.ArcadeDrivetrain;

public class CollectorRobot {
    private DcMotor driveRight;
    private DcMotor driveLeft;

    public DcMotor collectorMotor;

    // Robot variables
    private final HardwareMap hwMap;

    // Drivetrain
    public ArcadeDrivetrain drivetrain;

    public CollectorRobot(HardwareMap hwMap) {
        // Hardware ref
        this.hwMap = hwMap;

        // Drive Motor Init
        driveRight = hwMap.get(DcMotor.class, "driveRight");
        driveLeft = hwMap.get(DcMotor.class, "driveLeft");
        //LimitedMotor motor = new LimitedMotor(hwMap.get(DcMotor.class, "motor"), 0, 1000);

        driveRight.setDirection(DcMotorSimple.Direction.REVERSE);
        driveLeft.setDirection(DcMotorSimple.Direction.FORWARD);

        driveRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        driveLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        driveRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        collectorMotor = hwMap.get(DcMotor.class, "collector_motor");

        // Drivetrain Init
        drivetrain = new ArcadeDrivetrain(driveLeft, driveRight);
    }
}
