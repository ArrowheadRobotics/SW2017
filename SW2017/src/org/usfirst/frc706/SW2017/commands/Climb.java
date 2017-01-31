package org.usfirst.frc706.SW2017.commands;
import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command {
	private CANTalon climbMotorOne;
	private CANTalon climbMotorTwo;
	
    public Climb() {
    }

    protected void initialize() {
    	climbMotorOne = RobotMap.chassisWinchOne;
    	climbMotorTwo = RobotMap.chassisWinchTwo;
    }

    protected void execute() {
    	climbMotorOne.set(Constants.Chassis.CLIMB_SPEED);
    	climbMotorTwo.set(Constants.Chassis.CLIMB_SPEED);
    }
    
    protected boolean isFinished() {
        return (Math.max(climbMotorOne.getOutputCurrent(), climbMotorTwo.getOutputCurrent()) > Constants.Chassis.WINCH_CURRENT_MAX);
    }

    protected void end() {
    	climbMotorOne.set(0);
    	climbMotorTwo.set(0);
    }

    protected void interrupted() {
    }
}
