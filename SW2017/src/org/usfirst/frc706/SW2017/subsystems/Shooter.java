package org.usfirst.frc706.SW2017.subsystems;

import org.usfirst.frc706.SW2017.RobotMap;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
    private final CANTalon conveyorMotor = RobotMap.shooterConveyorMotor;
    private final CANTalon agitatorMotor = RobotMap.shooterAgitatorMotor;
    private final CANTalon leftShooter = RobotMap.shooterLeftShooter;
    private final CANTalon rightShooter = RobotMap.shooterRightShooter;

    public Shooter() {

    }
    
    public void initDefaultCommand() {
    }
}

