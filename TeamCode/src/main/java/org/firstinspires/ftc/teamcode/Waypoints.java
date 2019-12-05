package org.firstinspires.ftc.teamcode;

import java.util.ArrayList;

public class Waypoints {
    ArrayList<LocData> redWP = new ArrayList<LocData>(6);
    ArrayList<LocData> blueWP = new ArrayList<LocData>(6);

    enum Alliance {RED, BLUE}

    Alliance alliance;

    /*
     *   Row
     *0  Foundation Start Position
     *1  Foundation End Position
     *2  Load Pivot Point
     *3  Build Mid Point
     *4  Load Mid Point
     *5  Pick up Station
     *6
     */
    public void init() {
        LocData temp = new LocData();

        temp.setAlliance("Red");
        //    Foundation Start Position
        temp.setXpos(54.0);
        temp.setYpos(-29.0);
        temp.setHeading(-75.0);
        temp.setImu_heading(0);

        redWP.add(0, temp);

        //  1  Foundation End Position
        temp.setXpos(10.0);
        temp.setYpos(11.0);
        temp.setHeading(12.0);
        temp.setImu_heading(90);

        redWP.add(1, temp);

        //  2  Load Pivot Point
        temp.setXpos(20.0);
        temp.setYpos(21.0);
        temp.setHeading(22.0);
        temp.setImu_heading(90);

        redWP.add(2, temp);

        //  3  Foundation Start Position
        temp.setXpos(30.0);
        temp.setYpos(31.0);
        temp.setHeading(-32.0);
        temp.setImu_heading(0);

        redWP.add(3, temp);

        //  4  Foundation End Position
        temp.setXpos(40.0);
        temp.setYpos(41.0);
        temp.setHeading(-42.0);
        temp.setImu_heading(90);

        redWP.add(4, temp);

        //  5  Load Pivot Point
        temp.setXpos(50.0);
        temp.setYpos(51.0);
        temp.setHeading(-52.0);
        temp.setImu_heading(90);

        redWP.add(5, temp);

        ////////////////////////////////////////////////////////////

        temp.setAlliance("Blue");
        //    Foundation Start Position
        temp.setXpos(85.0);
        temp.setYpos(35.0);
        temp.setHeading(-5.0);
        temp.setImu_heading(0);

        blueWP.add(0, temp);

        //  1  Foundation End Position
        temp.setXpos(85.0);
        temp.setYpos(35.0);
        temp.setHeading(-5.0);
        temp.setImu_heading(90);

        blueWP.add(1, temp);

        //  2  Load Pivot Point
        temp.setXpos(85.0);
        temp.setYpos(35.0);
        temp.setHeading(-5.0);
        temp.setImu_heading(90);

        blueWP.add(2, temp);

        //  3  Foundation Start Position
        temp.setXpos(85.0);
        temp.setYpos(35.0);
        temp.setHeading(-5.0);
        temp.setImu_heading(0);

        blueWP.add(3, temp);

        //  4  Foundation End Position
        temp.setXpos(85.0);
        temp.setYpos(35.0);
        temp.setHeading(-5.0);
        temp.setImu_heading(90);

        blueWP.add(4, temp);

        //  5  Load Pivot Point
        temp.setXpos(85.0);
        temp.setYpos(35.0);
        temp.setHeading(-5.0);
        temp.setImu_heading(90);

        blueWP.add(5, temp);
    }

    public void setAlliance(String ally) {
        switch (ally) {
            case "Red":
                alliance = Alliance.RED;
                break;
            case "Blue":
                alliance = Alliance.BLUE;
                break;
        }
    }

    public LocData getWayPoint(int index) {
        LocData wp = new LocData();

        switch (alliance) {
            case RED:
                wp = redWP.get(index);
                break;
            case BLUE:
                wp = blueWP.get(index);
                break;
        }
        return wp;
    }
}
