package org.usfirst.frc706.SW2017;

import org.usfirst.frc706.SW2017.commands.Climb;
import org.usfirst.frc706.SW2017.commands.ReverseClimb;
import org.usfirst.frc706.SW2017.commands.ReverseConveyor;
import org.usfirst.frc706.SW2017.commands.RunIntake;
import org.usfirst.frc706.SW2017.commands.Shift;
import org.usfirst.frc706.SW2017.commands.ShootBalls;
import org.usfirst.frc706.SW2017.commands.ToggleReceive;
import org.usfirst.frc706.SW2017.commands.ToggleRelease;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    private Joystick leftJoy, rightJoy, xbox;
    public JoystickButton a, b, x, y, rb, lb, start, back;
    public JoystickButton rightTrigger, leftTrigger, buttTwo;

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
        back = new JoystickButton(xbox, Constants.OI.BACK);
        
        buttTwo = new JoystickButton(rightJoy, Constants.OI.BUTT_TWO);
        rightTrigger = new JoystickButton(rightJoy, Constants.OI.TRIGGER);
        leftTrigger = new JoystickButton(leftJoy, Constants.OI.TRIGGER);

        rightTrigger.whenPressed(new ShootBalls());
        leftTrigger.whenPressed(new Shift());
        a.whenPressed(new RunIntake());
        buttTwo.whenPressed(new ReverseConveyor());
        x.whenPressed(new ToggleRelease());
        y.whenPressed(new ToggleReceive());
        start.whenPressed(new Climb());
        back.whenPressed(new ReverseClimb());
    }

    public Joystick getLeftJoy() {
        return leftJoy;
    }

    public Joystick getRightJoy() {
        return rightJoy;
    }

    public Joystick getXbox() {
        return xbox;
    }
}

