package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Robot;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
    public Drive() {
    	requires(Robot.chassis);
    }
    

    protected void initialize() {
    }

    protected void execute() {
    	if (!Robot.auton) {
    		Robot.chassis.move(Robot.oi.getRightJoy().getY(), Robot.oi.getLeftJoy().getY());
    		double r = Math.abs(Robot.oi.getRightJoy().getY());
    		double l = Math.abs(Robot.oi.getLeftJoy().getY());
    		Robot.oi.getXbox().setRumble(RumbleType.kLeftRumble, (r+l)*0.5);
    		Robot.oi.getXbox().setRumble(RumbleType.kRightRumble, (r+l)*0.5);
    	}
    }
    
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
