package org.usfirst.frc706.SW2017;

import org.usfirst.frc706.SW2017.commands.Climb;
import org.usfirst.frc706.SW2017.commands.FlapAngleInc;
import org.usfirst.frc706.SW2017.commands.PickUp;
import org.usfirst.frc706.SW2017.commands.Release;
import org.usfirst.frc706.SW2017.commands.ReverseClimb;
import org.usfirst.frc706.SW2017.commands.ReverseConveyor;
import org.usfirst.frc706.SW2017.commands.RunIntake;
import org.usfirst.frc706.SW2017.commands.Shift;
import org.usfirst.frc706.SW2017.commands.ShootBalls;
import org.usfirst.frc706.SW2017.commands.Squeeze;
import org.usfirst.frc706.SW2017.commands.StraightDrive;
import org.usfirst.frc706.SW2017.commands.ToggleReceive;
import org.usfirst.frc706.SW2017.commands.VisionPlace;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    private Joystick leftJoy, rightJoy, xbox;
    public JoystickButton a, b, x, y, rb, lb, start, back;
    public JoystickButton rightTrigger, leftTrigger, leftButtThree, leftButtTwo, rightButtTwo, rightButtFour, rightButtFive;

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
        
        rightButtTwo = new JoystickButton(rightJoy, Constants.OI.BUTT_TWO);
        rightButtFive = new JoystickButton(rightJoy, Constants.OI.BUTT_FIVE);
        rightButtFour = new JoystickButton(rightJoy, Constants.OI.BUTT_FOUR);
        leftButtTwo = new JoystickButton(leftJoy, Constants.OI.BUTT_TWO);
        leftButtThree = new JoystickButton(leftJoy, Constants.OI.BUTT_THREE);
        rightTrigger = new JoystickButton(rightJoy, Constants.OI.TRIGGER);
        leftTrigger = new JoystickButton(leftJoy, Constants.OI.TRIGGER);
        
        leftButtThree.whenPressed(new VisionPlace());
        rightTrigger.whenPressed(new ShootBalls());
        leftTrigger.whenPressed(new Shift());
        a.whenPressed(new RunIntake());
        rightButtTwo.whenPressed(new ReverseConveyor());
        leftButtTwo.whenPressed(new StraightDrive());
        x.whenPressed(new Release());
        y.whenPressed(new ToggleReceive());
        start.whenPressed(new Climb());
        back.whenPressed(new ReverseClimb());
        lb.whenPressed(new PickUp());
        rb.whenPressed(new Squeeze());
        rightButtFive.whileHeld(new FlapAngleInc(-0.01));
        rightButtFour.whileHeld(new FlapAngleInc(0.01));
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

