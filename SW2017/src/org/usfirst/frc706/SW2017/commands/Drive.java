package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
    public Drive() {
    	requires(Robot.chassis);
    }
    

    protected void initialize() {
    }

    protected void execute() {
    	Robot.chassis.move(Robot.oi.getrightJoy().getY(), Robot.oi.getleftJoy().getY());
    	System.out.println(Robot.oi.getrightJoy().getY() + "\t" + Robot.oi.getleftJoy().getY());
    }
    
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
