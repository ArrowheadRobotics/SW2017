package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Robot;
import org.usfirst.frc706.SW2017.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Release extends Command {
	private DoubleSolenoid releaseSol;
	private DoubleSolenoid pickUpSol;
	
    public Release() {
    }

    protected void initialize() {
    	pickUpSol = RobotMap.pickUpSol;
    	releaseSol = RobotMap.gearReleaseFlap;
    }

    protected void execute() {
    	pickUpSol.set(Value.kReverse);
    	Timer.delay(0.3);
    	releaseSol.set(Value.kForward);
    }
    
    protected boolean isFinished() {
        return !(Robot.oi.x.get());
    }

    protected void end() {
    	releaseSol.set(Value.kReverse);
    	pickUpSol.set(Value.kForward);
    }

    protected void interrupted() {
    }
}
