/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// PWM Ports
	public static final int FOURBAR = 3;
	public static final int BALLINTAKE=2;
	public static final int HATCH = 1;
	public static final int LINEARACTUATOR = 9;

	//CAN ID's
	public static final int RIGHTMASTER = 0;
	public static final int RIGHTSLAVE = 1;
	public static final int LEFTMASTER = 2;
	public static final int LEFTSLAVE = 3;
	
	
	
	
	// DIO ports
	public static  final int RIGHTWHEELENCODERA = 1;
	public static final  int RIGHTWHEELENCODERB = 2;
	public static final int LEFTWHEELENCODERA = 3;
	public static  final int LEFTWHEELENCODERB = 4;
	public static final  int FORBARENCODERA = 5;
	public static final  int FORBARENCODERB = 6;
	
	
	// CONSTANTS
	public static final double FEET = 1.0;
	public static final double INCHES = 1.0/12.0;
	public static final double WHEELDIAMETER = 6 * INCHES;
	public static int pulsePerRevolutionLeft = 3600;
	public static int pulsePerRevolutionRight = 360;
	public static int pulsePerRevolutionFourBar = 20;
	public static final double distancePerWheelPulseLeft = (Math.PI * WHEELDIAMETER) / pulsePerRevolutionLeft;
	public static final double distancePerWheelPulseRight = (Math.PI * WHEELDIAMETER) / pulsePerRevolutionRight;
	public static final double WHEELROTATION = Math.PI * WHEELDIAMETER;
	public static final double BOTTOMCARGOHOLEROCKET = 19.49 * INCHES;
	public static final double MIDDLECARGOHOLEROCKET = 47.49* INCHES;
	public static final double TOPCARGOHOLEROCKET = 75.49* INCHES;
	public static final double MAXFOURBARHIEGHT = 4.5 * FEET;
	public static final double MINFOURBARHEIGHT = -6* INCHES;
	public static double GEAR=1;
	


	public static void updateStats()
	{
		double currentSpeed = (Robot.driveTrain.getLeftSpeed()+ Robot.driveTrain.getRightSpeed())/2.0;
		
		SmartDashboard.putNumber("Speed", currentSpeed);
		SmartDashboard.putNumber("rightSpeed", Robot.driveTrain.getRightSpeed());
		SmartDashboard.putNumber("leftSpeed", Robot.driveTrain.getLeftSpeed());
		SmartDashboard.putNumber("currentAngle", Robot.driveTrain.getAngle());
	
		SmartDashboard.putNumber("leftTicks", Robot.driveTrain.getLeftEncoder().get());
		SmartDashboard.putNumber("rightTicks", Robot.driveTrain.getRightEncoder().get());

		SmartDashboard.putNumber("leftDistance", Robot.driveTrain.getLeftEncoder().getDistance());
		SmartDashboard.putNumber("rightDistance", Robot.driveTrain.getRightEncoder().getDistance());
		SmartDashboard.putNumber("fourBar", Robot.fourBar.getHeight() * 12);
		SmartDashboard.putNumber("tinyGyro",Robot.driveTrain.getTinyAngle());

		SmartDashboard.putNumber("GEAR",RobotMap.GEAR);
	}

}
