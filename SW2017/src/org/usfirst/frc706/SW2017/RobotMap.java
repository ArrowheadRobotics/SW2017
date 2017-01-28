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
    public static DoubleSolenoid chassisShiftSol;
    public static DoubleSolenoid gearReceiveFlap;

    public static void init() {
        chassisLeftDriveOne = new CANTalon(Constants.Chassis.LEFT_ONE); 
        chassisLeftDriveTwo = new CANTalon(Constants.Chassis.LEFT_TWO);
        chassisRightDriveOne = new CANTalon(Constants.Chassis.RIGHT_ONE);
        chassisRightDriveTwo = new CANTalon(Constants.Chassis.RIGHT_TWO);
        chassisWinchOne = new CANTalon(Constants.Chassis.WINCH_ONE);
        chassisWinchTwo = new CANTalon(Constants.Chassis.WINCH_TWO);
        shooterConveyorMotor = new CANTalon(Constants.Shooter.CONVEYOR);
        shooterAgitatorMotor = new CANTalon(Constants.Shooter.AGITATOR);
        shooterLeftShooter = new CANTalon(Constants.Shooter.SHOOTER_LEFT);
        shooterRightShooter = new CANTalon(Constants.Shooter.SHOOTER_RIGHT);
        intakeIntakeMotor = new CANTalon(Constants.Intake.INTAKE);
        chassisShiftSol = new DoubleSolenoid(Constants.PCM.PCM_ONE, Constants.Chassis.SHIFTER_FORWARD, Constants.Chassis.SHIFTER_REVERSE);
        gearReleaseFlap = new DoubleSolenoid(Constants.PCM.PCM_ONE, Constants.Gear.RELEASE_FORWARD, Constants.Gear.RELEASE_REVERSE);
        gearReceiveFlap = new DoubleSolenoid(Constants.PCM.PCM_ONE, Constants.Gear.RECEIVE_FORWARD, Constants.Gear.RECEIVE_REVERSE);
    }
}
