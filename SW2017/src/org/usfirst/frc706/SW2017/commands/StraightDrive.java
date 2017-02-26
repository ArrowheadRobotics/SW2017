package org.usfirst.frc706.SW2017.commands;

import org.usfirst.frc706.SW2017.Constants;
import org.usfirst.frc706.SW2017.Robot;
import org.usfirst.frc706.SW2017.RobotMap;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;

public class StraightDrive extends Command {
	CANTalon leftOne = RobotMap.chassisLeftDriveOne;
	CANTalon leftTwo = RobotMap.chassisLeftDriveTwo;
	CANTalon rightOne = RobotMap.chassisRightDriveOne;
	CANTalon rightTwo = RobotMap.chassisRightDriveTwo;
	AHRS nav = RobotMap.nav;
	double goalAng;
	
    public StraightDrive() {
    }

    protected void initialize() {
    	goalAng = nav.getYaw() + 540;
    }

    protected void execute() {
    	double err = nav.getYaw() + 540 - goalAng;
    	double joySpd = Robot.oi.getLeftJoy().getY();
    	joySpd = Math.abs(joySpd) > Constants.OI.DEAD_ZONE ? joySpd : 0;
    	double leftSpd = joySpd + err*0.01;
    	double rightSpd = joySpd - err*0.01;
    	leftOne.set(leftSpd*-1);
    	leftTwo.set(leftSpd*-1);
    	rightOne.set(rightSpd);
    	rightTwo.set(rightSpd);
    }
    
    protected boolean isFinished() {
        return !(Robot.oi.leftButtTwo.get());
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
