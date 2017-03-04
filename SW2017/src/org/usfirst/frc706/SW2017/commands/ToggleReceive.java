package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Command;

public class ToggleReceive extends Command {
	private Servo receiveServo;
	
    public ToggleReceive() {
    }

    protected void initialize() {
    	receiveServo = RobotMap.receiveServo;
    }

    protected void execute() {
    	receiveServo.set(receiveServo.get() > 0.5 ? 0.31 : 1.0);
    }
    
    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
