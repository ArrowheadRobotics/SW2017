package org.usfirst.frc706.SW2017;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SW2017.commands.*;
import org.usfirst.frc706.SW2017.subsystems.*;

public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    public static Chassis chassis;
    public static Shooter shooter;
    public static Intake intake;
    public static Gear gear;
    public static CameraServer frontCam, backCam;

    public void robotInit() {
    RobotMap.init();
        chassis = new Chassis();
        shooter = new Shooter();
        intake = new Intake();
        gear = new Gear();
        oi = new OI();
        autonomousCommand = new AutonomousCommand();
        frontCam = CameraServer.getInstance();
        backCam = CameraServer.getInstance();
        frontCam.startAutomaticCapture();
        backCam.startAutomaticCapture();
    }

    public void disabledInit(){}

    public void disabledPeriodic() {}

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {}

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {}

    public void testPeriodic() {}
}
