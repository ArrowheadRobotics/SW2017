package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Robot;
import org.usfirst.frc706.SW2017.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class Release extends Command {
	private DoubleSolenoid releaseSol;
	
    public Release() {
    }

    protected void initialize() {
    	releaseSol = RobotMap.gearReleaseFlap;
    }

    protected void execute() {
    	releaseSol.set(Value.kForward);
    }
    
    protected boolean isFinished() {
        return !(Robot.oi.x.get());
    }

    protected void end() {
    	releaseSol.set(Value.kReverse);
    }

    protected void interrupted() {
    }
}
