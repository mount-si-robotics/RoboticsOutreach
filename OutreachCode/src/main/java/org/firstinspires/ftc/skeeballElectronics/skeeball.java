package org.firstinspires.ftc.skeeballElectronics;


import android.graphics.Color;
import android.media.SoundPool;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//sensors
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
//sound
import android.media.MediaPlayer;
import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.ftccommon.SoundPlayer;
//leds
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.internal.system.Deadline;


@TeleOp(name = "SkeeBall")
public class skeeball extends LinearOpMode {
    ColorSensor sensorColor0;
    ColorSensor sensorColor1;
    ColorSensor sensorColor2;
    ColorSensor sensorColor3;

    DistanceSensor sensorDistance;

    private MediaPlayer mediaPlayer;
    private SoundPlayer soundPlayer;
    private MediaPlayer sound;

    private String[] sounds = {" applause2_x.wav "," applause3.wav "," applause_y.wav "," arrow_x.wav "," baseball_hit.wav "," baseball_hit_orbitz.wav "," blurp_x.wav "," boing_x.wav "," fart_wav.wav "," gasp_ohhh.wav "," glass_shatter_c.wav "," halo.mp3 "," hammer_anvil.wav "," hit_with_frying_pan_y.wav "," laser_x.wav "," laugh_x.wav "," police_siren.wav "," ricochet_x.wav "," thunk.wav "," whah_whah.wav "," woow_x.wav "," yay_z.wav " };


    /*
    RevBlinkinLedDriver blinkinLedDriver;
    RevBlinkinLedDriver.BlinkinPattern pattern;
    RevBlinkinLedDriver.BlinkinPattern patternR;
    RevBlinkinLedDriver.BlinkinPattern patternB;
    Telemetry.Item patternName;
    Telemetry.Item display;
    DisplayKind displayKind;
    Deadline ledCycleDeadline;

    protected enum DisplayKind {
        MANUAL,
    }
*/
    @Override
    public void runOpMode() {
        //finds color sensors
        sensorColor0 = hardwareMap.get(ColorSensor.class, "sensor_color_distance_0");
        sensorColor1 = hardwareMap.get(ColorSensor.class, "sensor_color_distance_1");
        sensorColor2 = hardwareMap.get(ColorSensor.class, "sensor_color_distance_2");
        sensorColor3 = hardwareMap.get(ColorSensor.class, "sensor_color_distance_3");


        sensorDistance = hardwareMap.get(DistanceSensor.class, "sensor_color_distance_0");


        // hue, saturation, and value
        float hsvValues[] = {0F, 0F, 0F};
        final float values[] = hsvValues;
        //increases measured values
        final double SCALE_FACTOR = 255;
/*
        blinkinLedDriver = hardwareMap.get(RevBlinkinLedDriver.class, "blinkin");
        pattern = RevBlinkinLedDriver.BlinkinPattern.RAINBOW_WITH_GLITTER;
        patternB = RevBlinkinLedDriver.BlinkinPattern.BLUE;
        patternR = RevBlinkinLedDriver.BlinkinPattern.RED;
        blinkinLedDriver.setPattern(pattern);

        display = telemetry.addData("Display Kind: ", displayKind.toString());
        patternName = telemetry.addData("Pattern: ", pattern.toString());
        setDisplayKind(DisplayKind.MANUAL);
        //led code not used
*/
        // wait for the start button to be pressed.
        waitForStart();

        // loop and read the RGB and distance data.
        // Note we use opModeIsActive() as our loop condition because it is an interruptible method.
        while (opModeIsActive()) {
            colorCheck(sensorColor0);
            colorCheck(sensorColor1);
            colorCheck(sensorColor2);
            colorCheck(sensorColor3);
            telemetry.update();
        }




    }
    public void colorCheck(ColorSensor sensor){
        sensor.enableLed(true);

        telemetry.addData("Name", sensor.toString());
        telemetry.addData("Red  ", sensor.red());
        telemetry.addData("Blue ", sensor.blue());
        if (sensor.red() > 100) {
            telemetry.addData("red:", true);

        }
        if (sensor.blue() > 100) {
            telemetry.addData("blue:", true);
            // pattern = patternR;

        }
        // playSound(sounds);

        /*    else{
                pattern = RevBlinkinLedDriver.BlinkinPattern.RAINBOW_WITH_GLITTER;
            }
            displayPattern();

         */
    }

    /*   protected void setDisplayKind(DisplayKind displayKind)
       {
           this.displayKind = displayKind;
           display.setValue(displayKind.toString());
       }

       protected void doAutoDisplay()
       {
           if (ledCycleDeadline.hasExpired()) {
               pattern = pattern.next();
               displayPattern();
               ledCycleDeadline.reset();
           }
       }

       protected void displayPattern()
       {
           blinkinLedDriver.setPattern(pattern);
           patternName.setValue(pattern.toString());
       }

     */
    public void playSound(String[] name) {
        if (sound != null && !sound.isPlaying()) {
            sound = MediaPlayer.create(hardwareMap.appContext, hardwareMap.appContext.getResources().getIdentifier(name[(int) (Math.random() * sounds.length)], "raw", hardwareMap.appContext.getPackageName()));
            sound.start();
        }
    }
}