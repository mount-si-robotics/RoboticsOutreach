package org.firstinspires.ftc.robotlib.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class BalloonBattlerRobot
{
    /** Drive variables **/
    private DcMotor driveRight;
    private DcMotor driveLeft;

    /** Arm variables **/
    private DcMotor armPopper;

    /** Robot variables **/
    private final HardwareMap hwMap;

    public BalloonBattlerRobot(HardwareMap hwMap)
    {
        this.hwMap = hwMap;
    }
}
