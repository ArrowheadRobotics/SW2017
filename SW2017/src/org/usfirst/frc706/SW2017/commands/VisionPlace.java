package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.Robot;
import org.usfirst.frc706.SW2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class VisionPlace extends Command {
	AnalogInput leftDrive, rightDrive;
	Servo receiveServo;
	CANTalon rightMotorOne, rightMotorTwo;
	CANTalon leftMotorOne, leftMotorTwo;
	
    public VisionPlace() {
    	leftDrive = RobotMap.autoLeft;
    	rightDrive = RobotMap.autoRight;
    	rightMotorOne = RobotMap.chassisRightDriveOne;
    	rightMotorTwo = RobotMap.chassisRightDriveTwo;
    	leftMotorOne = RobotMap.chassisLeftDriveOne;
    	leftMotorTwo = RobotMap.chassisLeftDriveTwo;
    	receiveServo = RobotMap.receiveServo;
    }

    protected void initialize() {
    	Robot.auton = true;
    	receiveServo.set(0.8);
    	Timer.delay(0.5);
    }

    protected void execute() {
   		leftMotorOne.set(getInputs()[0] ? 0.5 : 0.25);
   		leftMotorTwo.set(getInputs()[0] ? 0.5 : 0.25);
   		rightMotorOne.set(getInputs()[1] ? 0.5*-1 : 0.25*-1);
   		rightMotorTwo.set(getInputs()[1] ? 0.5*-1 : 0.25*-1);
    }
    
    protected boolean isFinished() {
        return !(Robot.oi.leftButtThree.get());
    }

    protected boolean[] getInputs() {
    	return new boolean[]{leftDrive.getValue() > 512, rightDrive.getValue() > 512};
    }
    
    protected void end() {
    	Robot.auton = false;
    }

    protected void interrupted() {
    }
}
