package org.firstinspires.ftc.robotlib.motor;
// a motor which is indented to be in one of two positions

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotlib.state.ServoState;

public class StateServoMotor extends ModifiedMotor
{
    private int[] positions;
    private ServoState servoState;

    public StateServoMotor(DcMotor motor, int stowedPosition, int openPosition, int closePosition)
    {
        super(motor);

        positions = new int[]{stowedPosition, openPosition, closePosition};
    }

    public StateServoMotor(DcMotor motor)
    {
        this (motor, 0, 0, 0);
    }

    public void setTargetPosition(ServoState servoState, double power)
    {
        if (servoState != ServoState.UNKNOWN)
        {
            setTargetPosition(positions[servoState.getStateLevel()]);
            motor.setMode(RunMode.RUN_TO_POSITION);
            motor.setPower(motor.getCurrentPosition() < motor.getTargetPosition() ? power : -power);

            this.servoState = servoState;
        }
    }

    public ServoState getServoState() { return servoState; }

    private void setPositions(int[] positions) { this.positions = positions; }

    public void setPositions(int stowedPosition, int upPosition, int downPosition) { setPositions(new int[] {stowedPosition, upPosition, downPosition});}

    public int[] getPositions() { return positions; }
}
