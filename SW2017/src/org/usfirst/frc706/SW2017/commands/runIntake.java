package org.usfirst.frc706.SW2017.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.Robot;
import org.usfirst.frc706.SW2017.RobotMap;

import com.ctre.CANTalon;

public class RunIntake extends Command {
	private CANTalon intakeMotor = RobotMap.intakeIntakeMotor;
	
    public RunIntake() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	intakeMotor.set(Constants.Intake.INTAKE_SPEED);
    }
    
    protected boolean isFinished() {
        return !(Robot.oi.a.get());
    }

    protected void end() {
    	intakeMotor.set(0);
    }

    protected void interrupted() {
    }
}
