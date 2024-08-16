package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class arm {
    Motor rotation;
    Motor extension;

    PIDFController pidf = new PIDFController(0.05, 0, 0, 0.01);

    public arm(Motor rotation, Motor extension) {
        this.rotation = rotation;
        this.extension = extension;

        rotation.setRunMode(Motor.RunMode.VelocityControl);
        extension.setRunMode(Motor.RunMode.PositionControl);
        rotation.setVeloCoefficients(0.05, 0, 0);
        extension.setPositionCoefficient(0.05);
    }

    public void armMovement(Gamepad gamepad2){
        double extensionPos = 0;
        extensionPos += gamepad2.left_stick_y;

        while (!pidf.atSetPoint()) {
            double output =pidf.calculate(
                    rotation.getCurrentPosition()  // the measured value
            );
            rotation.set(output);
        }
        rotation.stopMotor(); // stop the motor

        extension.setTargetPosition((int) extensionPos);

        double axial   = -gamepad2.left_stick_y;  // Note: pushing stick forward gives negative value
        double lateral =  gamepad2.left_stick_x;
        double yaw     =  gamepad2.right_stick_x;


    }

}

