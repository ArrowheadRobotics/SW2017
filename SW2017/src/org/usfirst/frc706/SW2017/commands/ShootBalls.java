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
	private boolean inPos;
	
    public ShootBalls() {
    }

    protected void initialize() {
    	agitatorMotor = RobotMap.shooterAgitatorMotor;
    	conveyorMotor = RobotMap.shooterConveyorMotor;
    	leftShooterMotor = RobotMap.shooterLeftShooter;
    	rightShooterMotor = RobotMap.shooterRightShooter;
    	ultra = RobotMap.ultra;
    	inPos = false;
    }

    protected void execute() {
    	if (Math.abs(ultra.getValue() - Constants.Shooter.OPTIMAL_POSITION) < 10) {
    		inPos = true;
    	}
    	double[] spd = getSpeed();
    	System.out.println(spd[0] + "\t" + spd[1]);
    	agitatorMotor.set(Constants.Shooter.AGITATOR_SPEED);
    	conveyorMotor.set(Constants.Shooter.CONVEYOR_SPEED);
    	leftShooterMotor.set(spd[0] * 5000);
    	rightShooterMotor.set(spd[1]*-1*5000);
    }
    
    protected boolean isFinished() {
        return !(Robot.oi.rightTrigger.get());
    }

    protected void end() {
    	agitatorMotor.set(0);
    	conveyorMotor.set(0);
    	leftShooterMotor.set(0);
    	rightShooterMotor.set(0);
    	leftShooterMotor.changeControlMode(TalonControlMode.PercentVbus);
    	rightShooterMotor.changeControlMode(TalonControlMode.PercentVbus);
    }

    protected void interrupted() {
    }
    
    protected double[] getSpeed() {
    	return new double[]{Robot.oi.getLeftJoy().getZ(), Robot.oi.getRightJoy().getZ()};
    }
}
