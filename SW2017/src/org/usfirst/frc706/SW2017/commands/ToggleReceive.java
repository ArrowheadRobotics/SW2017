package org.usfirst.frc706.SW2017.commands;
import org.usfirst.frc706.SW2017.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class ToggleReceive extends Command {
	private DoubleSolenoid receiveSol = RobotMap.gearReceiveFlap;
	
    public ToggleReceive() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (receiveSol.get() == DoubleSolenoid.Value.kForward) {
    		receiveSol.set(DoubleSolenoid.Value.kReverse);
    	}
    	else if (receiveSol.get() == DoubleSolenoid.Value.kReverse){
    		receiveSol.set(DoubleSolenoid.Value.kForward);
    	}
    	else {
    		receiveSol.set(DoubleSolenoid.Value.kReverse);
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
