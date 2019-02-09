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
import org.usfirst.frc.team5684.robot.commands.FourBarDown;
import org.usfirst.frc.team5684.robot.commands.FourBarToHeight;
import org.usfirst.frc.team5684.robot.commands.FourBarUp;
import org.usfirst.frc.team5684.robot.commands.HatchDown;
import org.usfirst.frc.team5684.robot.commands.HatchUp;
import org.usfirst.frc.team5684.robot.commands.LightOff;
import org.usfirst.frc.team5684.robot.commands.LightOn;
import org.usfirst.frc.team5684.robot.commands.MoveServo;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class IO {
	public static final Joystick coStick = new Joystick(1);
	public static final Joystick leftStick = new Joystick(0);
	public static final Joystick rightStick = new Joystick(2);
	//private Button gyroCalib = new JoystickButton(leftStick, 1);
	private Button armUp = new JoystickButton(coStick, 6);
	private Button armDown = new JoystickButton(coStick, 7);
	private Button hatchUp = new JoystickButton(rightStick, 4);
	private Button hatchDown = new JoystickButton(rightStick, 6);
	private Button ballIn = new JoystickButton(rightStick,5);
	private Button ballOut = new JoystickButton(rightStick,3);
	private Button lightOn = new JoystickButton(leftStick, 11);
	private Button lightOff = new JoystickButton(leftStick, 10);
	private Button coHatchDown = new JoystickButton(coStick, 10);
	private Button coHatchUp = new JoystickButton(coStick, 11);

	private Button RadTest = new JoystickButton(coStick, 1);

	private Button midRocket = new JoystickButton(leftStick, 7);
	private Button bottomRocket = new JoystickButton(leftStick, 9);
	private Button ground = new JoystickButton(leftStick, 11);

	
	public IO() {

	armUp.whileHeld(new FourBarUp());
	armDown.whileHeld(new FourBarDown());
	ballIn.whileHeld(new BallIn());
	ballOut.whileHeld(new BallOut());
	lightOn.whileHeld(new LightOn());
	lightOff.whileHeld(new LightOff());
	hatchDown.whileHeld(new HatchDown());
	hatchUp.whileHeld(new HatchUp());
	coHatchDown.whileHeld(new HatchDown());
	coHatchUp.whileHeld(new HatchUp());
	midRocket.whenPressed(new FourBarToHeight(RobotMap.MIDDLECARGOHOLEROCKET));
	bottomRocket.whenPressed(new FourBarToHeight(RobotMap.BOTTOMCARGOHOLEROCKET));
	ground.whenPressed(new FourBarToHeight(3 * RobotMap.INCHES));

	RadTest.whenPressed(new MoveServo());
	}
	
	
}



