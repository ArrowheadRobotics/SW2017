package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.Robot;
import org.usfirst.frc706.SW2017.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.AnalogInput;
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
    }

    protected void execute() {
    	String msg = "";
    	leftShooterMotor.changeControlMode(TalonControlMode.Speed);
    	rightShooterMotor.changeControlMode(TalonControlMode.Speed);
    	double[] spd = getSpeed();
    	agitatorMotor.set(Constants.Shooter.AGITATOR_SPEED);
    	conveyorMotor.set(Constants.Shooter.CONVEYOR_SPEED);
    	leftShooterMotor.set(spd[0]*-2500);
    	rightShooterMotor.set(spd[1]*2500);
    	msg += spd[0]*5000 + "\t";
    	msg += spd[1]*5000 + "\t";
    	System.out.println(msg);
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
