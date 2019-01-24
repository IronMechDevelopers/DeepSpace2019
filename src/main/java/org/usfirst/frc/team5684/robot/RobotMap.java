/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public static int LEFTWHEELENCODERA = 3;
	public static int LEFTWHEELENCODERB = 4;
	public static int RIGHTWHEELENCODERA = 1;
	public static int RIGHTWHEELENCODERB = 2;
	
	//Compressor Stuff
	public static int hatchOpen = 2;
	public static int hatchClose = 3;
	
	
	// CONSTANTS
	public static final double FEET = 1;
	public static final double INCHES = 1.0/12.0;
	public static final double WHEELDIAMETER = 6 * INCHES;
	public static int pulsePerRevolutionLeft = 250;
	public static int pulsePerRevolutionRight = 360;
	public static final double distancePerWheelPulseLeft = (Math.PI * WHEELDIAMETER) / pulsePerRevolutionLeft;
	public static final double distancePerWheelPulseRight = (Math.PI * WHEELDIAMETER) / pulsePerRevolutionRight;
	public static final double WHEELROTATION = Math.PI * WHEELDIAMETER;


	public static void updateStats()
	{
		double currentSpeed = (Robot.driveTrain.getLeftSpeed()+ Robot.driveTrain.getRightSpeed())/2.0;
		SmartDashboard.putNumber("currentSpeed", currentSpeed);
		SmartDashboard.putNumber("rightSpeed", Robot.driveTrain.getRightSpeed());
		SmartDashboard.putNumber("leftSpeed", Robot.driveTrain.getLeftSpeed());
		SmartDashboard.putNumber("currentAngle", Robot.driveTrain.getAngle());
	
		SmartDashboard.putNumber("leftTicks", Robot.driveTrain.getLeftEncoder().get());
		SmartDashboard.putNumber("rightTicks", Robot.driveTrain.getRightEncoder().get());

		SmartDashboard.putNumber("leftDistance", Robot.driveTrain.getLeftEncoder().getDistance());
		SmartDashboard.putNumber("rightDistance", Robot.driveTrain.getRightEncoder().getDistance());
	}

}
