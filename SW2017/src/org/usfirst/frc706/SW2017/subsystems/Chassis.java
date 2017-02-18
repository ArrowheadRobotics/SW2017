package org.usfirst.frc706.SW2017.subsystems;

import org.usfirst.frc706.SW2017.RobotMap;
import org.usfirst.frc706.SW2017.commands.Drive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {
    private final CANTalon leftDriveOne = RobotMap.chassisLeftDriveOne;
    private final CANTalon leftDriveTwo = RobotMap.chassisLeftDriveTwo;
    private final CANTalon rightDriveOne = RobotMap.chassisRightDriveOne;
    private final CANTalon rightDriveTwo = RobotMap.chassisRightDriveTwo;
    private final CANTalon winchOne = RobotMap.chassisWinchOne;
    private final CANTalon winchTwo = RobotMap.chassisWinchTwo;
    private final DoubleSolenoid shiftSol = RobotMap.chassisShiftSol;
    
    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
    }
    
    public Chassis() {
    	
    }
    
    public void move(double rightSpeed, double leftSpeed){
    	leftSpeed = Math.abs(leftSpeed) > 0.15 ? leftSpeed : 0;
    	rightSpeed = Math.abs(rightSpeed) > 0.15 ? rightSpeed : 0;
    	leftDriveOne.set(leftSpeed*-1);
    	leftDriveTwo.set(leftSpeed*-1);
    	rightDriveOne.set(rightSpeed);
    	rightDriveTwo.set(rightSpeed);
    }
}

