package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class FlapAngleInc extends Command {
	double inc;
    public FlapAngleInc(double i) {
    	inc= i;
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	RobotMap.receiveServo.set(Math.max(0.31, Math.min(1, RobotMap.receiveServo.get() + inc)));
    }
    
    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	System.out.println("Servo Pos " + RobotMap.receiveServo.get());
    }

    protected void interrupted() {
    }
}
