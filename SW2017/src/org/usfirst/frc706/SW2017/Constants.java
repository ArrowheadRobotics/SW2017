package org.usfirst.frc706.SW2017;

public class Constants {
	public class Chassis {
		//SRX CAN IDs
		public static final int LEFT_ONE = 4;
		public static final int LEFT_TWO = 5;
		public static final int RIGHT_ONE = 2;
		public static final int RIGHT_TWO = 7;
		public static final int WINCH_ONE = 3;
		public static final int WINCH_TWO = 6;
		//PCM Ports
		public static final int SHIFTER_FORWARD = 0;
		public static final int SHIFTER_REVERSE = 1;
		//Speeds & Rates
		public static final double WINCH_CURRENT_MAX = 10;
		public static final double CLIMB_SPEED = -0.5;
		
		public static final double DRIVE_RAMP = 6;
	}
	
	public class Shooter {
		//SRX CAN IDs
		public static final int CONVEYOR = 0;
		public static final int AGITATOR = 9;
		public static final int SHOOTER_LEFT = 10;
		public static final int SHOOTER_RIGHT = 1;
		//Speeds
		public static final double AGITATOR_SPEED = -1.0;
		public static final double CONVEYOR_SPEED = -1.0;
	}
	
	public class Intake {
		//SRX CAN IDs
		public static final int INTAKE = 8;
		//Speeds
		public static final double INTAKE_SPEED = -1.0;
	}
	
	public class Gear {
		//PCM Ports
		public static final int RELEASE_FORWARD = 2;
		public static final int RELEASE_REVERSE = 3;
		public static final int RECEIVE_FORWARD = 4;
		public static final int RECEIVE_REVERSE = 5;
	}
	
	public class OI {
		//Joystick Ports
		public static final int LEFT_JOY = 0;
		public static final int RIGHT_JOY = 1;
		public static final int XBOX = 2;
		
		//Joystick Buttons
		public static final int TRIGGER = 1;
		
		//Xbox Buttons
		public static final int A = 1;
		public static final int B = 2;
		public static final int X = 3;
		public static final int Y = 4;
		public static final int LB = 5;
		public static final int RB = 6;
		public static final int START = 8;
	}
	
	public class PCM {
		//PCM CAN IDs
		public static final int PCM_ONE = 0;
	}
	
	public class Autonomous {
		public static final int ULTRA_FRONT = 0;
		public static final int ULTRA_BACK = 1;
		public static final int AUTO_LEFT = 0;
		public static final int AUTO_RIGHT = 1;
		//Speeds
		public static final double DRIVE_SPEED = 0.7;
	}
}
