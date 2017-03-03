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
		public static final int IMAGE_WIDTH = 320;
		public static final int IMAGE_HEIGHT = 240;
		public static final int IMAGE_FPS = 15;
		//PCM Ports
		public static final int SHIFTER_FORWARD = 4;
		public static final int SHIFTER_REVERSE = 5;
		//Speeds & Rates
		public static final double WINCH_CURRENT_MAX = 40;
		public static final double CLIMB_SPEED = -1.0;
		
		public static final double DRIVE_RAMP = 6;
		public static final int FRONT_CAM = 0;
		public static final double ROTATE_ZONE = 10;
	}
	
	public class Shooter {
		//SRX CAN IDs
		public static final int CONVEYOR = 0;
		public static final int AGITATOR = 9;
		public static final int SHOOTER_LEFT = 10;
		public static final int SHOOTER_RIGHT = 1;
		//Speeds
		public static final double AGITATOR_SPEED = 1.0;
		public static final double CONVEYOR_SPEED = -1.0;
		public static final double OPTIMAL_SPEED_LEFT = 0.75;
		public static final double OPTIMAL_SPEED_RIGHT = 0.75;
		//PID
		public static final double SHOOTER_LEFT_P = 0.01;
		public static final double SHOOTER_LEFT_I = 0.0;
		public static final double SHOOTER_LEFT_D = 0.0;
		public static final double SHOOTER_RIGHT_P = 0.01;
		public static final double SHOOTER_RIGHT_I = 0.0;
		public static final double SHOOTER_RIGHT_D = 0.0;
		public static final int OPTIMAL_POSITION = 60;
		public static final double CLOSE_SHOOT_SPEED = 0.7;
		public static final double SHOT_DELAY = 0.3;
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
		public static final int RECEIVE_FORWARD = 0;
		public static final int RECEIVE_REVERSE = 1;
	}
	
	public class OI {
		//Joystick Ports
		public static final int LEFT_JOY = 0;
		public static final int RIGHT_JOY = 1;
		public static final int XBOX = 2;
		
		//Joystick Buttons
		public static final int TRIGGER = 1;
		public static final int BUTT_TWO = 2;
		
		//Xbox Buttons
		public static final int A = 1;
		public static final int B = 2;
		public static final int X = 3;
		public static final int Y = 4;
		public static final int LB = 5;
		public static final int RB = 6;
		public static final int BACK = 7;
		public static final int START = 8;
		public static final double DEAD_ZONE = 0.15;
	}
	
	public class PCM {
		//PCM CAN IDs
		public static final int PCM_ONE = 0;
	}
	
	public class Autonomous {
		public static final int STATE_SELECTOR_MSB = 2;
		public static final int STATE_SELECTOR_LSB = 3;
		public static final int DRIVE_BACK_COMMAND = 0x22;
		public static final int OPENL_COMMAND = 0x33;
		public static final int CLOSEL_COMMAND = 0x44;
		public static final int DRIVE_DIST_COMMAND = 0x55;
		public static final int WAIT_COMMAND = 0x66;
		public static final int DRIVE_COMMAND = 0x77;
		public static final int ROTATE_COMMAND = 0x88;
		public static final int VISION_COMMAND = 0x99;
		public static final int OPEN_COMMAND = 0xaa;
		public static final int CLOSE_COMMAND = 0xbb;
		public static final int SHOOT_COMMAND = 0xcc;
		public static final int STOP_COMMAND = 0xdd;
		public static final int ESTOP_COMMAND = 0xee;
		public static final int DANCE_COMMAND = 0xff;
		public static final int ULTRA = 1;
		public static final int AUTO_LEFT = 2;
		public static final int AUTO_RIGHT = 3;
		//Speeds
		public static final double DRIVE_SPEED = 1.0;
		public static final double SPEED_MULTIPLIER = 0.001;
		// position values
		public static final double POS_ONE_DIST_ONE = 0;
		public static final double POS_TWO_DIST_ONE = 0;
		public static final double POS_THREE_DIST_ONE = 0;
		public static final double VISION_MIN_DIST = 20;
		public static final double MIN_ANG_ERR = 0;
		public static final double MIN_DIST_ERR = 0;
		public static final double NULL_VALUE = 0;
		public static final double SIDE_PASS_LINE_VALUE = 100;
		public static final double MID_PASS_LINE_VALUE_ONE = 60;
		public static final double RIGHT_TURN_VALUE = 90;
		public static final double MID_PASS_LINE_VALUE_TWO = 50;
		public static final double LEFT_TURN_VALUE = -90;
		public static final double MID_PASS_LINE_VALUE_THREE = 40;
		public static final double DIST_M_VALUE = 0.050942;
		public static final double DIST_B_VALUE = 2.57894;
		public static final double VISION_SPEED_HIGH = 0.4	;
		public static final double VISION_SPEED_LOW = 0.1;
	}
}
