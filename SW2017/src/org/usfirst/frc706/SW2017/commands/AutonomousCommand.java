package org.usfirst.frc706.SW2017.commands;


import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousCommand extends Command {
	private CANTalon leftMotorOne, leftMotorTwo, rightMotorOne, rightMotorTwo;
	private CANTalon conveyorMotor, agitatorMotor, leftShooterMotor, rightShooterMotor;
	private DoubleSolenoid releaseSol, receiveSol, pickUpSol;
	private Servo receiveServo;
	private AnalogInput ultra;
	private AnalogInput autoLeft, autoRight;
	private DigitalInput stateReadOne, stateReadTwo;
	private AHRS nav;
	private DriverStation.Alliance alliance;
	private int state;
	private int mult;
	private int position;
	private long start = 0;
	private double ang = 0;
	private double[][] posOneCommands, posTwoCommands, posThreeCommands;

    public AutonomousCommand() {
    	state = 0;
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
    	releaseSol = RobotMap.gearReleaseFlap;
    	receiveServo = RobotMap.receiveServo;
    	pickUpSol = RobotMap.pickUpSol;
    	ultra = RobotMap.ultra;
    	autoLeft = RobotMap.autoLeft;
    	autoRight = RobotMap.autoRight;
    	nav = RobotMap.nav;
    	nav.zeroYaw();
    	alliance = DriverStation.getInstance().getAlliance();
    	position = getPosition();
    	mult = (alliance == DriverStation.Alliance.Red) ? 1 : -1;
    	posOneCommands = new double[][]{
    		{Constants.Autonomous.DRIVE_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.6},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.ROTATE_COMMAND, nav.getYaw() - 33},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.DRIVE_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.5},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.2},
    		{Constants.Autonomous.VISION_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.OPENL_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.25},
    		{Constants.Autonomous.DRIVE_BACK_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.RAISE_FLAP_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.325},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.CLOSE_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.ROTATE_COMMAND, nav.getYaw() + 110},
    		{Constants.Autonomous.VISION_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.SHOOT_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 5},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE}
    	};
    	posTwoCommands = new double[][]{
    		{Constants.Autonomous.DRIVE_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.45},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.3},
    		{Constants.Autonomous.VISION_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.OPENL_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.25},
    		{Constants.Autonomous.DRIVE_BACK_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.35},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.CLOSE_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.ROTATE_COMMAND, nav.getYaw() + 80},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.RAISE_FLAP_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.VISION_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.SHOOT_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 5},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE}
    	};
    	posThreeCommands = new double[][]{
    		{Constants.Autonomous.DRIVE_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.7},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.ROTATE_COMMAND, nav.getYaw() + 33},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.DRIVE_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.3},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.2},
    		{Constants.Autonomous.VISION_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.OPENL_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.25},
    		{Constants.Autonomous.DRIVE_BACK_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.5},
    		{Constants.Autonomous.CLOSE_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.ROTATE_COMMAND, nav.getYaw()},
    		{Constants.Autonomous.DRIVE_COMMAND, Constants.Autonomous.NULL_VALUE},
    		{Constants.Autonomous.WAIT_COMMAND, 0.5},
    		{Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE}
    	};
    	receiveServo.set(0.8);
    	pickUpSol.set(Value.kReverse);
    }

    protected void execute() {
    	double[] command = new double[]{};	
    	switch (position) {
    	case 0:
        	command = posOneCommands[Math.min(state, posOneCommands.length-1)];
   			doCommand((int) command[0], command[1]);
    		break;
    	case 1:
        	command = posTwoCommands[Math.min(state, posTwoCommands.length-1)];
   			doCommand((int) command[0], command[1]);
   			break;
   		case 2:
        	command = posThreeCommands[Math.min(state, posThreeCommands.length-1)];
   			doCommand((int) command[0], command[1]);
   			break;
   		case 3:
   			command = new double[] {Constants.Autonomous.ESTOP_COMMAND, Constants.Autonomous.NULL_VALUE};
   			doCommand((int) command[0], command[1]);
   			break;
   		}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    protected double getDistance() {
    	return ultra.getValue();
    }
    
    protected boolean[] getInputs() {
    	return new boolean[]{autoLeft.getValue() > 512, autoRight.getValue() > 512};
    }
    
    protected int getPosition() {
    	int msb = stateReadOne.get() ? 2 : 0;
    	int lsb = stateReadTwo.get() ? 1 : 0;
    	return msb + lsb;
    }
    
    protected double getAngle() {
    	return nav.getYaw();
    }
    
    protected void driveStraight() {
    	leftMotorOne.changeControlMode(TalonControlMode.PercentVbus);
    	leftMotorTwo.changeControlMode(TalonControlMode.PercentVbus);
    	rightMotorOne.changeControlMode(TalonControlMode.PercentVbus);
    	rightMotorTwo.changeControlMode(TalonControlMode.PercentVbus);
    	leftMotorOne.set(Constants.Autonomous.DRIVE_SPEED);
    	leftMotorTwo.set(Constants.Autonomous.DRIVE_SPEED);
    	rightMotorOne.set(Constants.Autonomous.DRIVE_SPEED*-1);
    	rightMotorTwo.set(Constants.Autonomous.DRIVE_SPEED*-1);
    	incState();
    }
    
    protected void startShooter() {
    	leftShooterMotor.changeControlMode(TalonControlMode.PercentVbus);
    	rightShooterMotor.changeControlMode(TalonControlMode.PercentVbus);
    	leftShooterMotor.set(Constants.Shooter.CLOSE_SHOOT_SPEED*-1);
    	rightShooterMotor.set(Constants.Shooter.CLOSE_SHOOT_SPEED);
    	conveyorMotor.set(Constants.Shooter.CONVEYOR_SPEED);
    	agitatorMotor.set(Constants.Shooter.AGITATOR_SPEED);
    	incState();
    }
    
    protected void driveBack() {
    	leftMotorOne.set(Constants.Autonomous.DRIVE_SPEED*-1);
    	leftMotorTwo.set(Constants.Autonomous.DRIVE_SPEED*-1);
    	rightMotorOne.set(Constants.Autonomous.DRIVE_SPEED);
    	rightMotorTwo.set(Constants.Autonomous.DRIVE_SPEED);
    	incState();
    }
    
    protected void driveToDist(double dist) {
    	double err = dist - getDistance();
    	double spd = Constants.Autonomous.SPEED_MULTIPLIER * err;
    	if (err < Constants.Autonomous.MIN_DIST_ERR) {
    		incState();
    	}
    	else {
        	leftMotorOne.set(spd);
        	leftMotorTwo.set(spd);
        	rightMotorOne.set(spd*-1);
        	rightMotorTwo.set(spd*-1);	
    	}
    }
    
    protected void rotateTo(double deg) {
    	double err = deg - nav.getYaw();
    	leftMotorOne.set(err*0.1);
    	leftMotorTwo.set(err*0.1);
    	rightMotorOne.set(err*0.1);
    	rightMotorTwo.set(err*0.1);
    	if (Math.abs(err) < 10) {
    		incState();
    	}
    }
    
    protected void driveWithVision() {
   		leftMotorOne.set(getInputs()[0] ? Constants.Autonomous.VISION_SPEED_HIGH : Constants.Autonomous.VISION_SPEED_LOW);
   		leftMotorTwo.set(getInputs()[0] ? Constants.Autonomous.VISION_SPEED_HIGH : Constants.Autonomous.VISION_SPEED_LOW);
   		rightMotorOne.set(getInputs()[1] ? Constants.Autonomous.VISION_SPEED_HIGH*-1 : Constants.Autonomous.VISION_SPEED_LOW*-1);
   		rightMotorTwo.set(getInputs()[1] ? Constants.Autonomous.VISION_SPEED_HIGH*-1 : Constants.Autonomous.VISION_SPEED_LOW*-1);
   		if (start == 0) {
   			start = System.currentTimeMillis();
   		}
   		else {
   			if (System.currentTimeMillis() - start > 2250) {
   				incState();
   				start = 0;
   			}
   		}
    }
    
    protected void openRelease() {
    	releaseSol.set(Value.kForward);
    	incState();
    }
    
    protected void closeRelease() {
    	releaseSol.set(Value.kReverse);
    	incState();
    }
    
    protected void openReceive() {
    	receiveSol.set(Value.kForward);
    	incState();
    	
    }
    
    protected void closeReceive() {
    	receiveSol.set(Value.kReverse);
    	incState();
    	
    }
    
    protected void stopShooter() {
    	leftShooterMotor.set(0);
    	rightShooterMotor.set(0);
    	conveyorMotor.set(0);
    	agitatorMotor.set(0);
    	incState();
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
    	incState();
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
    
    protected void raiseFlap() {
    	receiveServo.set(1);
    	incState();
    }
    
    protected void pauseFor(double value) {
    	Timer.delay(value);
    	incState();
    }
    
    protected void doCommand(int command, double value) {
    	switch (command) {
    	case Constants.Autonomous.WAIT_COMMAND:
    		pauseFor(value);
    		break;
    	case Constants.Autonomous.DRIVE_BACK_COMMAND:
    		driveBack();
    		break;
    	case Constants.Autonomous.DRIVE_COMMAND:
    		driveStraight();
    		break;
    	case Constants.Autonomous.DRIVE_DIST_COMMAND:
    		driveToDist(value);
    		break;
    	case Constants.Autonomous.ROTATE_COMMAND:
    		rotateTo(value);
    		break;
    	case Constants.Autonomous.VISION_COMMAND:
    		driveWithVision();
    		break;
    	case Constants.Autonomous.OPEN_COMMAND:
    		openRelease();
    		break;
    	case Constants.Autonomous.CLOSE_COMMAND:
    		closeRelease();
    		break;
    	case Constants.Autonomous.SHOOT_COMMAND:
    		startShooter();
    		break;
    	case Constants.Autonomous.STOP_COMMAND:
    		stopShooter();
    		break;
    	case Constants.Autonomous.ESTOP_COMMAND:
    		stop();
    		break;
    	case Constants.Autonomous.DANCE_COMMAND:
    		dance();
    		break;
    	case Constants.Autonomous.OPENL_COMMAND:
    		openRelease();
    		break;
    	case Constants.Autonomous.CLOSEL_COMMAND:
    		openRelease();
    		break;
    	case Constants.Autonomous.RAISE_FLAP_COMMAND:
    		raiseFlap();
    		break;
    	}
    }
    
    protected void incState() {
    	state++;
    }
}
