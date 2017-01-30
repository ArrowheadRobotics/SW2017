package org.usfirst.frc706.SW2017.commands;
import org.usfirst.frc706.SW2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SW2017.Constants;

public class runIntake extends Command {
	private CANTalon intakeMotor = RobotMap.intakeIntakeMotor;
	private double intakeSpeed = Constants.Intake.INTAKE_SPEED;
	
    public runIntake() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	intakeMotor.set(intakeSpeed);
    }
    
    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	intakeMotor.set(0);
    }

    protected void interrupted() {
    }
}
