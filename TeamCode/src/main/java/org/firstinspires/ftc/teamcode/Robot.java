package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import java.io.StringBufferInputStream;
import java.util.StringTokenizer;

public class Robot
{
    private String alliance = "";
    private String zone = "";
    public Chassis chassis;
    private LocData data;

    public Robot()
    {
        chassis = new Chassis();
        data = new LocData();
    }
    public void init(HardwareMap mapIn)
    {
        chassis.init(mapIn);
    }
    public  String getAlliance()
    {
        return alliance;
    }
    public String getZone()
    {
        return zone;
    }
    public  LocData  findLocation()
    {
        data = chassis.getLocData();

        return data;
    }
    public LocData getLocation()
    {
        data = chassis.getLocData();
        return data;
    }
}
