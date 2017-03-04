package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Robot;
import org.usfirst.frc706.SW2017.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class PickUp extends Command {
	private DoubleSolenoid pickUpSol = RobotMap.pickUpSol;
	
    public PickUp() {
    }

    protected void initialize() {
    	pickUpSol.set(Value.kReverse);
    }

    protected void execute() {}
    		
    
    protected boolean isFinished() {
        return !(Robot.oi.lb.get());
    }

    protected void end() {
    	pickUpSol.set(Value.kForward);
    }

    protected void interrupted() {
    }
}
