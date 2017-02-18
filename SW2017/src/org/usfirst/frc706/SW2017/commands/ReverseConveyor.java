package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.Robot;
import org.usfirst.frc706.SW2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;

public class ReverseConveyor extends Command {
	private CANTalon conveyorMotor;
	
    public ReverseConveyor() {
    	conveyorMotor = RobotMap.shooterConveyorMotor;
    }

    protected void initialize() {
    }

    protected void execute() {
    	conveyorMotor.set(Constants.Shooter.CONVEYOR_SPEED*-1);
    }
    
    protected boolean isFinished() {
        return !(Robot.oi.b.get());
    }

    protected void end() {
    	conveyorMotor.set(0);
    }

    protected void interrupted() {
    }
}
