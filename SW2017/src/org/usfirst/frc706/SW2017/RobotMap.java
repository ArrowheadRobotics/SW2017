package org.usfirst.frc706.SW2017;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class RobotMap {
    public static CANTalon chassisLeftDriveOne, chassisLeftDriveTwo;
    public static CANTalon chassisRightDriveOne, chassisRightDriveTwo;
    public static CANTalon chassisWinchOne, chassisWinchTwo;
    public static CANTalon shooterConveyorMotor;
    public static CANTalon shooterAgitatorMotor;
    public static CANTalon shooterLeftShooter, shooterRightShooter;
    public static CANTalon intakeIntakeMotor;
    public static DoubleSolenoid gearReleaseFlap;
    public static Solenoid chassisShiftSol;
    public static Solenoid gearReceiveFlap;

    public static void init() {
        chassisLeftDriveOne = new CANTalon(0); 
        chassisLeftDriveTwo = new CANTalon(1);
        chassisRightDriveOne = new CANTalon(2);
        chassisRightDriveTwo = new CANTalon(3);
        chassisWinchOne = new CANTalon(4);
        chassisWinchTwo = new CANTalon(5);
        chassisShiftSol = new Solenoid(0, 1);
        shooterConveyorMotor = new CANTalon(6);
        shooterAgitatorMotor = new CANTalon(7);
        shooterLeftShooter = new CANTalon(8);
        shooterRightShooter = new CANTalon(9);
        intakeIntakeMotor = new CANTalon(10);
        gearReleaseFlap = new DoubleSolenoid(0, 2, 3);
        gearReceiveFlap = new Solenoid(0, 4);
    }
}
