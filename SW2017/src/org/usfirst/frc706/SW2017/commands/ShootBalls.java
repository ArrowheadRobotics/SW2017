package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.Robot;
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
    	leftShooterMotor.set(speed*-1);
    	rightShooterMotor.set(speed);
    }
    
    protected boolean isFinished() {
        return !(Robot.oi.rightTrigger.get());
    }

    protected void end() {
    	agitatorMotor.set(0);
    	conveyorMotor.set(0);
    	leftShooterMotor.set(0);
    	rightShooterMotor.set(0);
    }

    protected void interrupted() {
    }
    
    protected double calculateSpeed() {
    	return 1.0;
    }
}
