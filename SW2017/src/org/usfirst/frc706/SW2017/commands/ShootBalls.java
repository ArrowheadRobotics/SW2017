package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.Robot;
import org.usfirst.frc706.SW2017.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

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
//    	
//    	leftShooterMotor.changeControlMode(TalonControlMode.Speed);
//    	leftShooterMotor.set(Constants.Shooter.TARGET_LEFT);
//    	
    }

    protected void execute() {
    	double speed = getSpeed();
    	System.out.println(speed);
    	agitatorMotor.set(Constants.Shooter.AGITATOR_SPEED);
    	conveyorMotor.set(Constants.Shooter.CONVEYOR_SPEED);
    	leftShooterMotor.set(speed);
    	rightShooterMotor.set(speed*-1);
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
    
    protected double getSpeed() {
    	double spd = Robot.oi.getLeftJoy().getY();
    	spd = (1 + spd) * 0.5;
    	return spd;
    }
}
