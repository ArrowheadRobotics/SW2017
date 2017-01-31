package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class Shift extends Command {
	private DoubleSolenoid shiftSol = RobotMap.chassisShiftSol;
	
    public Shift() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (shiftSol.get() == DoubleSolenoid.Value.kForward) {
    		shiftSol.set(DoubleSolenoid.Value.kReverse);
    	}
    	else if (shiftSol.get() == DoubleSolenoid.Value.kReverse) {
    		shiftSol.set(DoubleSolenoid.Value.kForward);
    	}
    	else {
    		shiftSol.set(DoubleSolenoid.Value.kReverse);
    	}
    }
    
    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
