/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot;

import org.usfirst.frc.team5684.robot.commands.BallIn;
import org.usfirst.frc.team5684.robot.commands.BallOut;
import org.usfirst.frc.team5684.robot.commands.DriveStraightWithGyro;
import org.usfirst.frc.team5684.robot.commands.Forward;
import org.usfirst.frc.team5684.robot.commands.FourBarDown;
import org.usfirst.frc.team5684.robot.commands.FourBarUp;
import org.usfirst.frc.team5684.robot.commands.LightOff;
import org.usfirst.frc.team5684.robot.commands.LightOn;

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
	//private Button gyroCalib = new JoystickButton(leftStick, 1);
	private Button driveStraight = new JoystickButton(leftStick, 6);
	private Button driveFullSpeed = new JoystickButton(leftStick, 9);
	private Button forward = new JoystickButton(leftStick, 7);
	private Button follow = new JoystickButton(leftStick, 8);
	private Button leftFire = new JoystickButton(rightStick, 1);
	private Button armUp = new JoystickButton(leftStick, 1);
	private Button armDown = new JoystickButton(rightStick, 1);
	private Button ballIn = new JoystickButton(rightStick,5);
	private Button ballOut = new JoystickButton(rightStick,3);
	private Button lightOn = new JoystickButton(leftStick, 11);
	private Button lightOff = new JoystickButton(leftStick, 10);

	
	public IO() {
	//gyroCalib.whenPressed(new GyroCalibration());
	driveStraight.whenPressed(new DriveStraightWithGyro(Math.PI * RobotMap.WHEELDIAMETER));
	forward.whileHeld(new Forward());
	armUp.whileHeld(new FourBarUp());
	armDown.whileHeld(new FourBarDown());
	ballIn.whileHeld(new BallIn());
	ballOut.whileHeld(new BallOut());
	lightOn.whileHeld(new LightOn());
	lightOff.whileHeld(new LightOff());
	}
	
	
}



