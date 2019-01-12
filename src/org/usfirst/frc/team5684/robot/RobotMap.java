/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// PWM Ports
	public static int RIGHTWHEELMOTOR = 1;
	public static int LEFTWHEELMOTOR = 0 ;
	
	
	
	// DIO ports
	public static int LEFTWHEELENCODERA = 1;
	public static int LEFTWHEELENCODERB = 2;
	public static int RIGHTWHEELENCODERA = 3;
	public static int RIGHTWHEELENCODERB = 4;
	
	
	
	// CONSTANTS
	public static final double WHEELDIAMETER = 6;
	public static double pulsePerRevolutionLeft = 360;
	public static double pulsePerRevolutionRight = 250;
	public static final double distancePerWheelPulseLeft = Math.PI * WHEELDIAMETER / pulsePerRevolutionLeft;
	public static final double distancePerWheelPulseRight = Math.PI * WHEELDIAMETER / pulsePerRevolutionRight;
	public static final int FEET = 12;
	public static final int INCHES = 1;
	public static final double WHEELROTATION = Math.PI * WHEELDIAMETER;
	public static final int TURNRIGHT = -90;
	public static final int TURNLEFT = 90;
}
