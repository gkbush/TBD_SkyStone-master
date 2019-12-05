package org.firstinspires.ftc.teamcode;

public class LocData
{
    private boolean visible;
    private String name;

    private String alliance;
    private String zone;
    private double Xpos;
    private double Ypos;
    private double Zpos;
    private double roll;
    private double pitch;
    private double heading;

    private double imu_target_heading;
    private double imu_current_heading;


    public String getAlliance() {
        return alliance;
    }

    public void setAlliance(String alliance) {
        this.alliance = alliance;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public double getXpos() {
        return Xpos;
    }

    public void setXpos(double xpos) {
        Xpos = xpos;
    }

    public double getYpos() {
        return Ypos;
    }

    public void setYpos(double ypos) {
        Ypos = ypos;
    }

    public double getZpos() {
        return Zpos;
    }

    public void setZpos(double zpos) {
        Zpos = zpos;
    }

    public double getRoll() {
        return roll;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public double getHeading() {
        return heading;
    }

    public void setHeading(double heading) {
        this.heading = heading;
    }
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public boolean getVisible() {
        return visible;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImu_heading(double inPut){this.imu_target_heading = inPut;}
    public double getImu_target_heading(){return this.imu_target_heading;}
    public double getImu_current_heading(){return this.imu_current_heading;}
}
