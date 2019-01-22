/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot;

import org.usfirst.frc.team5684.robot.commands.Compress;
import org.usfirst.frc.team5684.robot.commands.DriveStraightWithGyro;
import org.usfirst.frc.team5684.robot.commands.Fire;
import org.usfirst.frc.team5684.robot.commands.Follow;
import org.usfirst.frc.team5684.robot.commands.Forward;
import org.usfirst.frc.team5684.robot.commands.FullSpeed;
import org.usfirst.frc.team5684.robot.commands.GyroCalibration;
import org.usfirst.frc.team5684.robot.commands.Withdraw;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class IO {
	public static final Joystick leftStick = new Joystick(1);
	public static final Joystick rightStick = new Joystick(2);
	private Button gyroCalib = new JoystickButton(leftStick, 1);
	private Button driveStraight = new JoystickButton(leftStick, 6);
	private Button driveFullSpeed = new JoystickButton(leftStick, 9);
	private Button rad = new JoystickButton(leftStick, 7);
	private Button rad2 = new JoystickButton(leftStick, 8);
	private Button leftFire = new JoystickButton(rightStick, 1);
	private Button fire = new JoystickButton(rightStick, 11);
	private Button withdraw = new JoystickButton(rightStick, 12);
	
	public IO() {
	//gyroCalib.whenPressed(new GyroCalibration());
	driveStraight.whenPressed(new DriveStraightWithGyro(Math.PI * RobotMap.WHEELDIAMETER));
	driveFullSpeed.whenPressed(new FullSpeed(Math.PI * RobotMap.WHEELDIAMETER));
	leftFire.whileHeld(new Compress());
	fire.whenPressed(new Fire());
	withdraw.whenPressed(new Withdraw());
	rad.whileHeld(new Forward());
	rad2.whenPressed(new Follow());
	}
	
	
}
