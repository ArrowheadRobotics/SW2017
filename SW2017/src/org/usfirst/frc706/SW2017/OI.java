package org.usfirst.frc706.SW2017;

import org.usfirst.frc706.SW2017.commands.Climb;
import org.usfirst.frc706.SW2017.commands.RunIntake;
import org.usfirst.frc706.SW2017.commands.Shift;
import org.usfirst.frc706.SW2017.commands.ShootBalls;
import org.usfirst.frc706.SW2017.commands.ToggleReceive;
import org.usfirst.frc706.SW2017.commands.ToggleRelease;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    private Joystick leftJoy, rightJoy, xbox;
    public JoystickButton a, b, x, y, rb, lb, start;
    public JoystickButton rightTrigger, leftTrigger;

    public OI() {
        xbox = new Joystick(Constants.OI.XBOX);
        rightJoy = new Joystick(Constants.OI.RIGHT_JOY);
        leftJoy = new Joystick(Constants.OI.LEFT_JOY);
        
        a = new JoystickButton(xbox, Constants.OI.A);
        b = new JoystickButton(xbox, Constants.OI.B);
        x = new JoystickButton(xbox, Constants.OI.X);
        y = new JoystickButton(xbox, Constants.OI.Y);
        rb = new JoystickButton(xbox, Constants.OI.RB);
        lb = new JoystickButton(xbox, Constants.OI.LB);
        start = new JoystickButton(xbox, Constants.OI.START);
        
        rightTrigger = new JoystickButton(rightJoy, Constants.OI.TRIGGER);
        leftTrigger = new JoystickButton(leftJoy, Constants.OI.TRIGGER);

        rightTrigger.whileHeld(new ShootBalls());
        a.whileHeld(new RunIntake());
        x.whenPressed(new ToggleRelease());
        y.whenPressed(new ToggleReceive());
        b.whenPressed(new Climb());
        start.whenPressed(new Shift());
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

