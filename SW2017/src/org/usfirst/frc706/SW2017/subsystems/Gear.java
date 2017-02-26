package org.usfirst.frc706.SW2017.subsystems;

import org.usfirst.frc706.SW2017.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gear extends Subsystem {

    private final DoubleSolenoid releaseFlap = RobotMap.gearReleaseFlap;
    private final DoubleSolenoid receiveFlap = RobotMap.gearReceiveFlap;

    public void initDefaultCommand() {
    }
    
    public Gear() {
    	releaseFlap.set(Value.kReverse);
    	receiveFlap.set(Value.kReverse);
    }
}

