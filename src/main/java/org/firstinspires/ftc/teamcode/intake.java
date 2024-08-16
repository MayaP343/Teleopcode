package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class intake {
    CRServo claw1;
    CRServo claw2;

    public intake(CRServo claw1, CRServo claw2) {
        this.claw1 = claw1;
        this.claw2 = claw2;
    }

    public void intakeClaw(Gamepad gamepad2){

        if (gamepad2.a) {
            claw1.set(1);
        }
        else {
            claw1.set(0);
        }
        if (gamepad2.b) {
            claw1.set(-1);
        }
        else {
            claw1.set(0);
        }

        if (gamepad2.x) {
            claw2.set(1);
        }
        else {
            claw2.set(0);
        }
        if (gamepad2.y) {
            claw2.set(-1);
        }
        else {
            claw2.set(0);
        }
    }

}
