package org.usfirst.frc706.SW2017.subsystems;

import org.usfirst.frc706.SW2017.RobotMap;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
    private final CANTalon intakeMotor = RobotMap.intakeIntakeMotor;
    
    public Intake(){
    	intakeMotor.reverseOutput(true);
    }
    
    public void initDefaultCommand() {
    }
}

