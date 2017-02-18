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
    	leftShooter.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	leftShooter.configEncoderCodesPerRev(128);
    	leftShooter.reverseSensor(false);
    	leftShooter.configNominalOutputVoltage(+0.0f, -0.0f);
    	leftShooter.configPeakOutputVoltage(+12.0f, -12.0f);
    	leftShooter.setPID(Constants.Shooter.SHOOTER_LEFT_P, Constants.Shooter.SHOOTER_LEFT_I, Constants.Shooter.SHOOTER_LEFT_D);	
    }
    
    public void initDefaultCommand() {
    }
}

