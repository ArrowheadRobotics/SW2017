package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;

public class ShootBalls extends Command {
	private CANTalon agitatorMotor;
	private CANTalon conveyorMotor;
	private CANTalon leftShooterMotor;
	private CANTalon rightShooterMotor;
	
    public ShootBalls() {
    }

    protected void initialize() {
    	agitatorMotor = RobotMap.shooterAgitatorMotor;
    	conveyorMotor = RobotMap.shooterConveyorMotor;
    	leftShooterMotor = RobotMap.shooterLeftShooter;
    	rightShooterMotor = RobotMap.shooterRightShooter;
    }

    protected void execute() {
    	double speed = calculateSpeed();
    	agitatorMotor.set(Constants.Shooter.AGITATOR_SPEED);
    	conveyorMotor.set(Constants.Shooter.CONVEYOR_SPEED);
    	leftShooterMotor.set(speed);
    	rightShooterMotor.set(speed);
    }
    
    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    protected double calculateSpeed() {
    	return 0.5;
    }
}
