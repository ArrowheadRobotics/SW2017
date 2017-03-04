package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Robot;
import org.usfirst.frc706.SW2017.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class Squeeze extends Command {
	private DoubleSolenoid squeezeSol = RobotMap.gearSqueezeSol;
	
    public Squeeze() {
    }

    protected void initialize() {
      	squeezeSol.set(Value.kReverse);
    }

    protected void execute() {
  
    }
    
    protected boolean isFinished() {
        return !(Robot.oi.rb.get());
    }

    protected void end() {
    	squeezeSol.set(Value.kForward);
    }

    protected void interrupted() {
    }
}
