package org.usfirst.frc706.SW2017;

import com.ctre.CANTalon;
//import com.kauailabs.navx.frc.AHRS;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.Servo;

public class RobotMap {
    public static CANTalon chassisLeftDriveOne, chassisLeftDriveTwo;
    public static CANTalon chassisRightDriveOne, chassisRightDriveTwo;
    public static CANTalon chassisWinchOne, chassisWinchTwo;
    public static CANTalon shooterConveyorMotor;
    public static CANTalon shooterAgitatorMotor;
    public static CANTalon shooterLeftShooter, shooterRightShooter;
    public static CANTalon intakeIntakeMotor;
    public static DoubleSolenoid gearReleaseFlap, gearSqueezeSol;
    public static DoubleSolenoid chassisShiftSol;
    public static DoubleSolenoid pickUpSol;
    public static Servo receiveServo;
    public static AnalogInput ultra;
    public static AnalogInput autoLeft, autoRight;
    public static DigitalInput stateReadOne, stateReadTwo;
    public static AHRS nav;
    public static DigitalOutput leds, timeLight;
    
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
        pickUpSol = new DoubleSolenoid(Constants.PCM.PCM_ONE, Constants.Gear.PICK_UP_FORWARD, Constants.Gear.PICK_UP_REVERSE);
        gearSqueezeSol = new DoubleSolenoid(Constants.PCM.PCM_ONE, Constants.Gear.SQUEEZE_FORWARD, Constants.Gear.SQUEEZE_REVERSE);
        receiveServo = new Servo(Constants.Gear.SERVO);
        ultra = new AnalogInput(Constants.Autonomous.ULTRA);
        autoLeft = new AnalogInput(Constants.Autonomous.AUTO_LEFT);
        autoRight = new AnalogInput(Constants.Autonomous.AUTO_RIGHT);
        stateReadOne = new DigitalInput(Constants.Autonomous.STATE_SELECTOR_MSB);
        stateReadTwo = new DigitalInput(Constants.Autonomous.STATE_SELECTOR_LSB);
        
        leds = new DigitalOutput(4);
        timeLight = new DigitalOutput(5);
        
        nav = new AHRS(Port.kMXP);
    }
}
