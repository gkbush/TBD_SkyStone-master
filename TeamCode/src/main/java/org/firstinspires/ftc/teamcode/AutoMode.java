package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Autonomous(name="SkyStone: Auto Drive", group="Shaper")
//@Disabled

public class AutoMode extends LinearOpMode
{
    private Robot bot = new Robot();
    private ElapsedTime runtime = new ElapsedTime();
    private String alliance = "";
    private String zone = "";
    private LocData autoData = new LocData();
    private Waypoints wp = new Waypoints();

    LocData target = new LocData();
    LocData currLoc = new LocData();
    double errX = 1;
    double errY = 1;
    double errHeading = 0.0;
    double speedSP = -0.3;
    double speedOffset = 0;

    @Override
    public void runOpMode()
    {
        telemetry.addData("Status", "Initializing Robot");    //
        telemetry.update();
        bot.init(hardwareMap);
        telemetry.addData("Status", "Identifying Location");    //
        telemetry.update();
        autoData = bot.findLocation();

        wp.init();
        wp.setAlliance(autoData.getAlliance());
        telemetry.addData("Alliance", autoData.getAlliance());    //
        telemetry.addData("Zone", autoData.getZone());    //
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();
        zone = autoData.getZone();


        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        switch (zone)
        {
            case "Build":
                build();
                break;
            case "Load":
                load();
                break;
            default:
                telemetry.addData("Status", "Failed Switch");    //
                telemetry.update();
        }
        /*
        while(  runtime.now(TimeUnit.MILLISECONDS) < 21500)
        {
            getStones();
        }
*/
        //navigate();

    }
    //////////////////////////////////////////////////////////////////////////////////////////////
    private void build()
    {


        telemetry.addData("Build " + autoData.getAlliance(),"Repositioning");
        telemetry.update();

        //  move to foundation
        target = wp.getWayPoint(0);
        move2wayPoint();

        // latch onto foundation
        bot.chassis.clamp.clamp();

        //  move to foundation
       // target = wp.getWayPoint(1);
       // move2wayPoint();

        // release foundation
      // bot.chassis.clamp.release();

    }
    private void load()
    {

    }
    private void getStones()
    {
        telemetry.addData("fetching ", "stones");
        telemetry.update();
    }
    private void navigate()
    {
        telemetry.addData("navigating ", autoData.getAlliance());
        telemetry.update();
    }
    private void move2wayPoint()
    {
        while(Math.abs(errX) >.5 || Math.abs(errY) > 0.5 )
        {
            currLoc = bot.getLocation();
            errX = target.getXpos() - currLoc.getXpos();
            errY = target.getYpos() - currLoc.getYpos();
            errHeading = Math.sqrt(Math.pow(errX,2) + Math.pow(errY,2));
            speedOffset = speedSP * errX/ errY;

            telemetry.addData("target X  ", target.getXpos());
            telemetry.addData("target Y  ", target.getYpos());
            telemetry.addData("posX  ", currLoc.getXpos());
            telemetry.addData("posY  ", currLoc.getYpos());
            telemetry.addData("errx ", errX);
            telemetry.addData("erry ", errY);
            //telemetry.addData("errh ", errHeading);
            //telemetry.addData("errs ", speedOffset);
            telemetry.update();

            bot.chassis.setLF_Power(speedSP + speedOffset);
            bot.chassis.setLR_Power(speedSP - speedOffset);
            bot.chassis.setRF_Power(speedSP - speedOffset);
            bot.chassis.setRR_Power(speedSP + speedOffset);
        }
        bot.chassis.stopMotors();

    }
}
