package org.usfirst.frc706.SW2017.subsystems;

import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.RobotMap;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
    private final CANTalon conveyorMotor = RobotMap.shooterConveyorMotor;
    private final CANTalon agitatorMotor = RobotMap.shooterAgitatorMotor;
    private final CANTalon leftShooter = RobotMap.shooterLeftShooter;
    private final CANTalon rightShooter = RobotMap.shooterRightShooter;

    public Shooter() {
    	conveyorMotor.set(0);
    	agitatorMotor.set(0);
    	leftShooter.set(0);
    	rightShooter.set(0);
    }
    
    public void initDefaultCommand() {
    	leftShooter.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	rightShooter.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	leftShooter.reverseSensor(false);
    	rightShooter.reverseSensor(false);
    	leftShooter.configNominalOutputVoltage(+0, -0);
    	rightShooter.configNominalOutputVoltage(+0, -0);
    	leftShooter.configPeakOutputVoltage(+12, -12);
    	rightShooter.configPeakOutputVoltage(+12, -12);
    	leftShooter.configEncoderCodesPerRev(8196);
    	rightShooter.configEncoderCodesPerRev(8196);
    	leftShooter.setPID(Constants.Shooter.SHOOTER_LEFT_P, Constants.Shooter.SHOOTER_LEFT_I, Constants.Shooter.SHOOTER_LEFT_D);
    	rightShooter.setPID(Constants.Shooter.SHOOTER_RIGHT_P, Constants.Shooter.SHOOTER_RIGHT_I, Constants.Shooter.SHOOTER_RIGHT_D);
    }
}

