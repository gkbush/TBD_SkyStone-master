package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class FoundationClamp
{
    private Servo r_servo = null;
    private Servo l_servo = null;

    private final double L_SERVO_OPEN = -1.0;
    private final double L_SERVO_CLOSED = 1.0;
    private final double R_SERVO_OPEN = 1.0;
    private final double R_SERVO_CLOSED = -1.0;


    public FoundationClamp(){}
    public  void init(HardwareMap mapIn)
    {
        r_servo =mapIn.get(Servo.class, "Foundation_Grab_L");
        l_servo =mapIn.get(Servo.class, "Foundation_Grab_R");

        r_servo.setPosition(R_SERVO_OPEN);
        l_servo.setPosition(L_SERVO_OPEN);
    }
    public void clamp()
    {
        r_servo.setPosition(R_SERVO_CLOSED);
        l_servo.setPosition(L_SERVO_CLOSED);
    }
    public  void  release()
    {
        r_servo.setPosition(R_SERVO_OPEN);
        l_servo.setPosition(L_SERVO_OPEN);
    }
}
