package org.usfirst.frc706.SW2017;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    private Joystick leftJoy;
    private Joystick rightJoy;
    private Joystick xbox;

    public OI() {
        xbox = new Joystick(2);
        rightJoy = new Joystick(1);
        leftJoy = new Joystick(0);
    }

    public Joystick getleftJoy() {
        return leftJoy;
    }

    public Joystick getrightJoy() {
        return rightJoy;
    }

    public Joystick getxbox() {
        return xbox;
    }
}

