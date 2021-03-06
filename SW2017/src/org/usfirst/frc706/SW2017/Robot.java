package org.usfirst.frc706.SW2017;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc706.SW2017.commands.*;
import org.usfirst.frc706.SW2017.subsystems.*;

public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    public static Chassis chassis;
    public static Shooter shooter;
    public static Intake intake;
    public static Gear gear;
    public static UsbCamera frontCam;
    public static boolean auton;

    public Robot() {
        frontCam = CameraServer.getInstance().startAutomaticCapture("Front Cam", Constants.Chassis.FRONT_CAM);
    }
    
    public void robotInit() {
    	RobotMap.init();
        chassis = new Chassis();
        shooter = new Shooter();
        intake = new Intake();
        gear = new Gear();
        oi = new OI();
        autonomousCommand = new AutonomousCommand();
        frontCam.setResolution(Constants.Chassis.IMAGE_WIDTH, Constants.Chassis.IMAGE_HEIGHT);
        frontCam.setFPS(Constants.Chassis.IMAGE_FPS);
    }

    public void disabledInit(){}

    public void disabledPeriodic() {}

    public void autonomousInit() {
    	RobotMap.leds.set(false);
    	auton = true;
    	RobotMap.nav.zeroYaw();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
    	auton = true;
    	Scheduler.getInstance().run();
    	
    	RobotMap.leds.set(false);
    	
    }

    public void teleopInit() {
    	auton = false;
    	RobotMap.pickUpSol.set(Value.kForward);
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
    	auton = false;
    	
    	if((DriverStation.getInstance().getMatchTime() < 30) && !Robot.auton) {
    		RobotMap.timeLight.set(true);
    	}
    	else {
    		RobotMap.leds.set(true);
    	}
    	Scheduler.getInstance().run();
    	
    	
    }

    public void testPeriodic() {}
}
