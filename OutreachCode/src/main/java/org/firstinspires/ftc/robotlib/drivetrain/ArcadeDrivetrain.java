package org.firstinspires.ftc.robotlib.drivetrain;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotlib.motor.EncoderMotor;

public class ArcadeDrivetrain extends Drivetrain implements Rotatable
{
    private double rotation;
    private double throttle;
    private double brake;

    public ArcadeDrivetrain(DcMotor driveLeft, DcMotor driveRight)
    { super(new EncoderMotor[] {new EncoderMotor(driveLeft), new EncoderMotor(driveRight)}); }

    public void setThrottle(double throttle)
    {
        this.throttle = throttle;
        updateMotorPowers();
    }
    public double getThrottle() { return throttle; }

    public void setBrake(double brake)
    {
        this.brake = brake;
        updateMotorPowers();
    }
    public double getBrake() { return brake; }

    @Override
    protected double[] calculateMotorPowers()
    {
        // motor array is {leftMotor, rightMotor}
        return new double[] {(throttle - brake) - rotation, (throttle - brake) + rotation};
    }

    @Override
    public void setRotation(double rotation)
    {
        this.rotation = rotation;
        updateMotorPowers();
    }
    @Override
    public double getRotation() { return rotation; }
}
