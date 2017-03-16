package org.usfirst.frc706.SW2017.subsystems;

import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.Robot;
import org.usfirst.frc706.SW2017.RobotMap;
import org.usfirst.frc706.SW2017.commands.Drive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {
    private final CANTalon leftDriveOne = RobotMap.chassisLeftDriveOne;
    private final CANTalon leftDriveTwo = RobotMap.chassisLeftDriveTwo;
    private final CANTalon rightDriveOne = RobotMap.chassisRightDriveOne;
    private final CANTalon rightDriveTwo = RobotMap.chassisRightDriveTwo;
    private final CANTalon winchOne = RobotMap.chassisWinchOne;
    private final CANTalon winchTwo = RobotMap.chassisWinchTwo;
    private final DoubleSolenoid shiftSol = RobotMap.chassisShiftSol;
    private final CANTalon intake = RobotMap.intakeIntakeMotor;
    
    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
    }
    
    public Chassis() {
    	leftDriveOne.set(0);
    	leftDriveTwo.set(0);
    	rightDriveOne.set(0);
    	rightDriveTwo.set(0);
    	winchOne.set(0);
    	winchTwo.set(0);
    	shiftSol.set(Value.kForward);
    	intake.set(0);
    }
    
    public void move(double rightSpeed, double leftSpeed){
    	leftSpeed = Math.abs(leftSpeed) > Constants.OI.DEAD_ZONE ? leftSpeed : 0;
    	rightSpeed = Math.abs(rightSpeed) > Constants.OI.DEAD_ZONE ? rightSpeed : 0;
    	if (leftSpeed > 0 || rightSpeed > 0) {
    		//intake.set(Constants.Intake.INTAKE_SPEED);
    	}
    	else {
    		if (!(Robot.oi.a.get())) {
    			intake.set(0);
    		}
    	}
    	leftDriveOne.set(leftSpeed*-1);
    	leftDriveTwo.set(leftSpeed*-1);
    	rightDriveOne.set(rightSpeed);
    	rightDriveTwo.set(rightSpeed);
    }
}

