package org.usfirst.frc706.SW2017.commands;


import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.RobotMap;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousCommand extends Command {
	private CANTalon leftMotorOne, leftMotorTwo, rightMotorOne, rightMotorTwo;
	private CANTalon conveyorMotor, agitatorMotor, leftShooterMotor, rightShooterMotor;
	private DoubleSolenoid receiveSol, releaseSol;
	private AnalogInput ultra;
	private DigitalInput autoLeft, autoRight;
	private DigitalInput stateReadOne, stateReadTwo;
	private AHRS nav;
	private DriverStation.Alliance alliance;
	private int state;
	private int mult;
	private int position;
	private double[] posOne, posTwo, posThree;

    public AutonomousCommand() {
    	state = 0;
    	posOne = new double[]{};
    	posTwo = new double[]{};
    	posThree = new double[]{};
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
    	stateReadOne = RobotMap.stateReadOne;
    	stateReadTwo = RobotMap.stateReadTwo;
    	ultra = RobotMap.ultra;
    	autoLeft = RobotMap.autoLeft;
    	autoRight = RobotMap.autoRight;
    	nav = RobotMap.nav;
    	alliance = DriverStation.getInstance().getAlliance();
    	position = getPosition();
    	mult = (alliance == DriverStation.Alliance.Red) ? 1 : -1;
    }

    protected void execute() {
    	switch (position) {
    	case 0:
    		break;
    	case 1:
    		break;
    	case 2:
    		break;
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	stop();
    }

    protected void interrupted() {
    }
    
    protected double getDistance() {
    	return ultra.getValue();
    }
    
    protected boolean[] getInputs() {
    	return new boolean[]{autoLeft.get(), autoRight.get()};
    }
    
    protected int getPosition() {
    	int msb = stateReadOne.get() ? 2 : 0;
    	int lsb = stateReadTwo.get() ? 1 : 0;
    	return msb + lsb;
    }
    
    protected double getAngle() {
    	return nav.getAngle();
    }
    
    protected void driveToDist(double dist) {
    	double err = dist - getDistance();
    	double spd = Constants.Autonomous.SPEED_MULTIPLIER * err;
    	leftMotorOne.set(spd);
    	leftMotorTwo.set(spd);
    	rightMotorOne.set(spd*-1);
    	rightMotorTwo.set(spd*-1);
    }
    
    protected void rotateTo(double deg) {
    	double err = deg - getAngle();
    	double spd = Constants.Autonomous.SPEED_MULTIPLIER * err;
    	leftMotorOne.set(spd);
    	leftMotorTwo.set(spd);
    	rightMotorOne.set(spd);
    	rightMotorTwo.set(spd);
    	
    }
    
    protected void driveWithVision() {
    	leftMotorOne.set(getInputs()[0] ? Constants.Autonomous.DRIVE_SPEED : 0);
    	leftMotorTwo.set(getInputs()[0] ? Constants.Autonomous.DRIVE_SPEED : 0);
    	rightMotorOne.set(getInputs()[1] ? Constants.Autonomous.DRIVE_SPEED*-1 : 0);
    	rightMotorTwo.set(getInputs()[1] ? Constants.Autonomous.DRIVE_SPEED*-1 : 0);
    }
    
    protected void openRelease() {
    	releaseSol.set(Value.kReverse);
    }
    
    protected void closeRelease() {
    	releaseSol.set(Value.kForward);
    }
    
    protected void startShooter() {
    	leftShooterMotor.set(Constants.Shooter.CLOSE_SHOOT_SPEED);
    	rightShooterMotor.set(Constants.Shooter.CLOSE_SHOOT_SPEED);
    	conveyorMotor.set(Constants.Shooter.CONVEYOR_SPEED);
    	agitatorMotor.set(Constants.Shooter.AGITATOR_SPEED);
    }
    
    protected void stopShooter() {
    	leftShooterMotor.set(0);
    	rightShooterMotor.set(0);
    	conveyorMotor.set(0);
    	agitatorMotor.set(0);
    }
    
    protected void stop() {
    	leftMotorOne.set(0);
    	leftMotorTwo.set(0);
    	rightMotorOne.set(0);
    	rightMotorTwo.set(0);
    	rightShooterMotor.set(0);
    	leftShooterMotor.set(0);
    	rightShooterMotor.set(0);
    	conveyorMotor.set(0);
    	agitatorMotor.set(0);
    	
    }
    
    protected void dance() {
    	double d = Math.random() < 0.5 ? -1 : 1;
    	double v = Math.random() * Math.random() < 0.5 ? -1 : 1;
    	double spd = v * d;
    	leftMotorOne.set(spd);
    	leftMotorTwo.set(spd);
    	rightMotorOne.set(spd*-1);
    	rightMotorTwo.set(spd*-1);
    }
}
