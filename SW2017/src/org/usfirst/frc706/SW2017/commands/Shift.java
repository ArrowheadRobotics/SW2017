package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Robot;
import org.usfirst.frc706.SW2017.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class Shift extends Command {
	private DoubleSolenoid shiftSol = RobotMap.chassisShiftSol;
	
    public Shift() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	shiftSol.set(Value.kReverse);
    }
    
    protected boolean isFinished() {
        return !(Robot.oi.leftTrigger.get());
    }

    protected void end() {
    	shiftSol.set(Value.kForward);
    }

    protected void interrupted() {
    }
}
