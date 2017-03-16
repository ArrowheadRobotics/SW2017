package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.Robot;
import org.usfirst.frc706.SW2017.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ShootBalls extends Command {
	private CANTalon agitatorMotor;
	private CANTalon conveyorMotor;
	private CANTalon leftShooterMotor;
	private CANTalon rightShooterMotor;
	private AnalogInput ultra;
	
    public ShootBalls() {
    }

    protected void initialize() {
    	agitatorMotor = RobotMap.shooterAgitatorMotor;
    	conveyorMotor = RobotMap.shooterConveyorMotor;
    	leftShooterMotor = RobotMap.shooterLeftShooter;
    	rightShooterMotor = RobotMap.shooterRightShooter;
    	ultra = RobotMap.ultra;
    	leftShooterMotor.enable();
    	rightShooterMotor.enable();
    	leftShooterMotor.changeControlMode(TalonControlMode.Speed);
    	rightShooterMotor.changeControlMode(TalonControlMode.Speed);
    	leftShooterMotor.set(-1000/*getSpeed()[0]*-2500*/);
    	rightShooterMotor.set(1590/*getSpeed()[1]*2500*/);
    	Timer.delay(Constants.Shooter.SHOT_DELAY);
    }

    protected void execute() {
    	agitatorMotor.set(Constants.Shooter.AGITATOR_SPEED);
    	conveyorMotor.set(Constants.Shooter.CONVEYOR_SPEED);
    	leftShooterMotor.set(-1000/*getSpeed()[0]*-2500*/);
    	System.out.println("Left Enc: " + leftShooterMotor.getEncVelocity());
    	System.out.println("Right Enc: " + rightShooterMotor.getEncVelocity());
    	rightShooterMotor.set(1590/*getSpeed()[1]*2500*/);
    	System.out.println("Left: " + getSpeed()[0] + "  " + "Right: " + getSpeed()[1]);
    }
    
    protected boolean isFinished() {
        return !(Robot.oi.rightTrigger.get());
    }

    protected void end() {
    	leftShooterMotor.changeControlMode(TalonControlMode.PercentVbus);
    	rightShooterMotor.changeControlMode(TalonControlMode.PercentVbus);
    	agitatorMotor.set(0);
    	conveyorMotor.set(0);
    	leftShooterMotor.set(0);
    	rightShooterMotor.set(0);
    }

    protected void interrupted() {
    }
    
    protected double[] getSpeed() {
    	return new double[]{Robot.oi.getLeftJoy().getZ()+1, Robot.oi.getRightJoy().getZ()+1};
    }
}
