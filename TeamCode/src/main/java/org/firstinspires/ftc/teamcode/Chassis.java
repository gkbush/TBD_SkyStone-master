package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Chassis
{
    DcMotor LF_motor = null;
    DcMotor LR_motor= null;
    DcMotor RF_motor = null;
    DcMotor RR_motor = null;

    //ColorSensor sensorColor = null;

   // private DistanceSensor sensorRange;

    public FoundationClamp clamp= null;

    LocData data = new LocData();
    Location loc = new Location();
    Thread lThread;

    public Chassis()
    {

    }
    public void init(HardwareMap mapIn)
    {
        clamp = new FoundationClamp();
        clamp.init(mapIn);

        loc.init(mapIn);

        LF_motor = mapIn.get(DcMotor.class, "LF_Motor");
        LR_motor= mapIn.get(DcMotor.class, "LR_Motor");
        RF_motor = mapIn.get(DcMotor.class, "RF_Motor");
        RR_motor = mapIn.get(DcMotor.class, "RR_Motor");

        LF_motor.setDirection(DcMotor.Direction.FORWARD);
        LR_motor.setDirection(DcMotor.Direction.FORWARD);
        RF_motor.setDirection(DcMotor.Direction.REVERSE);
        RR_motor.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to zero power
        LF_motor.setPower(0);
        LR_motor.setPower(0);
        RF_motor.setPower(0);
        RR_motor.setPower(0);

        // Set all motors to run without encoders.
        LF_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LR_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RF_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RR_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // get a reference to the color sensor.
        //sensorColor = mapIn.get(ColorSensor.class, "Color_Sensor");
        //sensorRange = mapIn.get(DistanceSensor.class, "Range_Sensor");

        data.setXpos(1.5);
        lThread = new Thread(loc);
        lThread.start();
    }
    public LocData findLocation()
    {
        return loc.findLocation();
    }
    public LocData getLocData()
    {
        return loc.getLocation();
    }
    public void setLF_Power(double sp)
    {
        LF_motor.setPower(sp);
    }
    public void setLR_Power(double sp)
    {
        LR_motor.setPower(sp);

    }
    public void setRF_Power(double sp)
    {
        RF_motor.setPower(sp);

    }
    public void setRR_Power(double sp)
    {
        RR_motor.setPower(sp);
    }
    public void stopMotors()
    {
        LF_motor.setPower(0.0);
        LR_motor.setPower(0.0);
        RF_motor.setPower(0.0);
        RR_motor.setPower(0.0);
    }
    public int turn2heading(double tHeading)
    {

        return 1;
    }
    public void Finalize()
    {
        loc.shutdown();
    }
}
