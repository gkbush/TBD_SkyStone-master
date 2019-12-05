package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="SkyBot: Teleop", group="Pushbot")
//@Disabled

public class TeleOpMode extends LinearOpMode
{
    /* Declare OpMode members. */
    Robot bot = new Robot();

    final private double scalor = 0.5;
    LocData myData = new LocData();
    double LFsp, LRsp, RFsp, RRsp = 0;

    @Override
    public  void runOpMode()
    {
        bot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Select Alliance", "X = Blue   B = Red");    //
        telemetry.update();
        Boolean input = false;
        Boolean inX, inB = false;
        while(!input)
        {
            inB = gamepad2.b;
            inX = gamepad2.x;
            input = inB || inX;
        }
        if(inB)
            myData.setAlliance("Red");
        else
            myData.setAlliance("Blue");
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Selected Alliance", myData.getAlliance());
        telemetry.addData("Waiting for ","start");
        //
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive())
        {
            /******     Get Telemetry           ***********/
            myData = bot.getLocation();

            telemetry.addData("Sees Target = ", myData.isVisible());
            telemetry.addData("Target Name = ", myData.getName());
            telemetry.addData("Angle = ", myData.getHeading());
            telemetry.addData("Xpos = ", myData.getXpos());
            telemetry.addData("Ypos = ", myData.getYpos());
            telemetry.update();

            /******     Driver 1 Controls       ***********/
            //
            //
            //  Left Joystick
                //  F/B  creep forward / backward
            LFsp =gamepad1.right_stick_y - gamepad1.right_stick_x;
            LRsp = gamepad1.right_stick_y - gamepad1.right_stick_x;
            RFsp = gamepad1.right_stick_y + gamepad1.right_stick_x;
            RRsp = gamepad1.right_stick_y + gamepad1.right_stick_x;
/*
            telemetry.addData("LF SP = ", LFsp);
            telemetry.addData("LR SP = ", LRsp);
            telemetry.addData("RF SP = ", RFsp);
            telemetry.addData("RR SP = ", RRsp);
            telemetry.update();
*/
            bot.chassis.setLF_Power( gamepad1.left_stick_y * scalor);
            bot.chassis.setLR_Power(gamepad1.left_stick_y * scalor);
            bot.chassis.setRF_Power(gamepad1.left_stick_y * scalor);
            bot.chassis.setRR_Power(gamepad1.left_stick_y * scalor);

                //  R/L Straffe Right / Left

            //  Right Joystick
                //  F/B Forward / Backward
                //  R/L Turn Right / Left

                bot.chassis.setLF_Power(LFsp);
                bot.chassis.setLR_Power(LRsp);
                bot.chassis.setRF_Power(RFsp);
                bot.chassis.setRR_Power(RRsp);


            /******     Driver 2 Controls       ***********/

                //  Servos to grab Foundation - Dpad Up/ Dwn
            if(gamepad2.dpad_down){bot.chassis.clamp.clamp();}
            if(gamepad2.dpad_up){bot.chassis.clamp.release();}

                //  Grab/ Release Stone - Right / Left Bumper

                //  Raise / Lower Cascading arms  - Left Joystick up/dwn

                //  Extend / Retract Cascading arms - Right Joystick up/dwn

        }
    }
}
