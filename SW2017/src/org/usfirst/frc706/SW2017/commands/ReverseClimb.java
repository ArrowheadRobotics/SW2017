package org.usfirst.frc706.SW2017.commands;
import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.Robot;
import org.usfirst.frc706.SW2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;

public class ReverseClimb extends Command {
	private CANTalon climbMotorOne;
	private CANTalon climbMotorTwo;
	
    public ReverseClimb() {
    }

    protected void initialize() {
    	climbMotorOne = RobotMap.chassisWinchOne;
    	climbMotorTwo = RobotMap.chassisWinchTwo;
    }

    protected void execute() {
    	climbMotorOne.set(Constants.Chassis.CLIMB_SPEED*-0.15);
    	climbMotorTwo.set(Constants.Chassis.CLIMB_SPEED*-0.15);
    }
    
    protected boolean isFinished() {
        return !(Robot.oi.back.get());
    }

    protected void end() {
    	climbMotorOne.set(0);
    	climbMotorTwo.set(0);
    }

    protected void interrupted() {
    }
}
