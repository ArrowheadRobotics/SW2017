package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.RobotMap;

import com.ctre.CANTalon;
//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousCommand extends Command {
	private CANTalon leftMotorOne, leftMotorTwo, rightMotorOne, rightMotorTwo;
	private CANTalon conveyorMotor, agitatorMotor, leftShooterMotor, rightShooterMotor;
	private DoubleSolenoid receiveSol, releaseSol;
	private AnalogInput ultraFront, ultraBack;
	private DigitalInput autoLeft, autoRight;
	//private AHRS nav;
	private DriverStation.Alliance alliance;
	private int state;

    public AutonomousCommand() {
    }

    protected void initialize() {
    	leftMotorOne = RobotMap.chassisLeftDriveOne;
    	leftMotorTwo = RobotMap.chassisLeftDriveTwo;
    	rightMotorOne = RobotMap.chassisRightDriveOne;
    	rightMotorTwo = RobotMap.chassisRightDriveTwo;
    	conveyorMotor = RobotMap.shooterConveyorMotor;
    	agitatorMotor = RobotMap.shooterAgitatorMotor;
    	leftShooterMotor = RobotMap.shooterLeftShooter;
    	rightShooterMotor = RobotMap.shooterRightShooter;
    	ultraFront = RobotMap.ultraFront;
    	ultraBack = RobotMap.ultraBack;
    	autoLeft = RobotMap.autoLeft;
    	autoRight = RobotMap.autoRight;
    	//nav = RobotMap.nav;
    	alliance = DriverStation.getInstance().getAlliance();
    }

    protected void execute() {
    	if (alliance == DriverStation.Alliance.Red) {
    		switch (state) {
    		case 0:
    			driveToDist(0);
    			break;
    		}
    	}
    	else if (alliance == DriverStation.Alliance.Blue) {
    		switch (state) {
    		case 0:
    			driveToDist(0);
    			break;
    		}
    	}
    	else {
    		//oops
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    protected double[] getDistances() {
    	return new double[]{ultraFront.getValue(), ultraBack.getValue()};
    }
    
    protected boolean[] getInputs() {
    	return new boolean[]{autoLeft.get(), autoRight.get()};
    }
    
    protected void getAngle() {
    	//return nav.getAngle();
    }
    
    protected void driveToDist(double dist) {
    	
    }
    
    protected void rotateTo(double deg) {
    	
    }
    
    protected void driveWithVision() {
    	leftMotorOne.set(getInputs()[0] ? Constants.Autonomous.DRIVE_SPEED : 0);
    	leftMotorTwo.set(getInputs()[0] ? Constants.Autonomous.DRIVE_SPEED : 0);
    	rightMotorOne.set(getInputs()[1] ? Constants.Autonomous.DRIVE_SPEED : 0);
    	rightMotorTwo.set(getInputs()[1] ? Constants.Autonomous.DRIVE_SPEED : 0);
    }
}
