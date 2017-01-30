package org.usfirst.frc706.SW2017.commands;
import org.usfirst.frc706.SW2017.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class ToggleRelease extends Command {
	private DoubleSolenoid releaseSol = RobotMap.gearReleaseFlap;
	
    public ToggleRelease() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (releaseSol.get() == DoubleSolenoid.Value.kForward) {
    		releaseSol.set(DoubleSolenoid.Value.kReverse);
    	}
    	else if (releaseSol.get() == DoubleSolenoid.Value.kReverse) {
    		releaseSol.set(DoubleSolenoid.Value.kForward);
    	}
    	else {
    		releaseSol.set(DoubleSolenoid.Value.kReverse);
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
