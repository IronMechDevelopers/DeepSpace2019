/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot;

import org.usfirst.frc.team5684.robot.commands.DriveStraightWithGyro;
import org.usfirst.frc.team5684.robot.commands.GyroCalibration;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class IO {
	public static final Joystick leftStick = new Joystick(1);
	public static final Joystick rightStick = new Joystick(0);
	private Button gyroCalib = new JoystickButton(leftStick, 1);
	private Button driveStraight = new JoystickButton(leftStick, 6);
	
	public IO() {
	gyroCalib.whenPressed(new GyroCalibration());
	driveStraight.whenPressed(new DriveStraightWithGyro(Math.PI * RobotMap.WHEELDIAMETER));
	}
	
	
}
