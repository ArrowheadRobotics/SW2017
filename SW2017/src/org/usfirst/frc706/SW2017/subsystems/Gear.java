package org.usfirst.frc706.SW2017.subsystems;

import org.usfirst.frc706.SW2017.RobotMap;
import org.usfirst.frc706.SW2017.commands.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Gear extends Subsystem {

    private final DoubleSolenoid releaseFlap = RobotMap.gearReleaseFlap;
    private final Solenoid receiveFlap = RobotMap.gearReceiveFlap;

    public void initDefaultCommand() {
    }
}

