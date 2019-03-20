/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot;

import org.usfirst.frc.team5684.robot.commands.DriveStraight;
import org.usfirst.frc.team5684.robot.commands.FourBarToHeight;
import org.usfirst.frc.team5684.robot.commands.HatchDown;
import org.usfirst.frc.team5684.robot.commands.HatchUp;
import org.usfirst.frc.team5684.robot.commands.ManualControl;
import org.usfirst.frc.team5684.robot.commands.ManualFlop;
import org.usfirst.frc.team5684.robot.commands.ShiftDown;
import org.usfirst.frc.team5684.robot.commands.SwitchCamera;
import org.usfirst.frc.team5684.robot.commands.TotalBallIn;
import org.usfirst.frc.team5684.robot.commands.TotalBallOut;
import org.usfirst.frc.team5684.robot.commands.TotalFlopDown;
import org.usfirst.frc.team5684.robot.commands.TotalFlopUp;
import org.usfirst.frc.team5684.robot.commands.Unlock;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class IO {
	// Basic Driving
	public static final Joystick coStick = new Joystick(1);
	public static final Joystick leftStick = new Joystick(0);
	public static final Joystick rightStick = new Joystick(2);

	private Button driveStraight = new JoystickButton(leftStick, 1);

	// Hatch
	private Button hatchUp = new JoystickButton(rightStick, 4);
	private Button hatchDown = new JoystickButton(rightStick, 6);


	// Ball Intake
	private Button ballIn = new JoystickButton(rightStick,5);
	private Button ballOut = new JoystickButton(rightStick,3);

	// Lights & Camera
	private Button switchCamera = new JoystickButton(rightStick, 1);

	// Flopper
	private Button flopUp = new JoystickButton(coStick, 10 );
	private Button flopDown = new JoystickButton(coStick, 11 );
	private Button mannualDown = new JoystickButton(coStick, 7);
	private Button mannualUp = new JoystickButton(coStick, 6);

	private Button manualControl = new JoystickButton(coStick, 1);

	// Preset Heights
	private Button midRocket = new JoystickButton(leftStick, 7);
	private Button bottomRocket = new JoystickButton(leftStick, 9);
	private Button ground = new JoystickButton(leftStick, 11);
	private Button gear = new JoystickButton(rightStick, 2);

	// Misc
	private Button unlock = new JoystickButton(coStick,8);
	
	public IO() {

	ballIn.whileHeld(new TotalBallIn());
	ballOut.whileHeld(new TotalBallOut());
	hatchDown.whileHeld(new HatchDown());
	hatchUp.whileHeld(new HatchUp());
	midRocket.whenPressed(new FourBarToHeight(RobotMap.MIDDLECARGOHOLEROCKET));
	bottomRocket.whenPressed(new FourBarToHeight(RobotMap.BOTTOMCARGOHOLEROCKET));
	ground.whenPressed(new FourBarToHeight(3 * RobotMap.INCHES));
	gear.whileHeld(new ShiftDown());
	manualControl.whileHeld(new ManualControl());
	unlock.whenPressed(new Unlock());
	switchCamera.whenPressed(new SwitchCamera());
	mannualDown.whileHeld(new ManualFlop(0));
	mannualUp.whileHeld(new ManualFlop(1));
	//flopUp.whenPressed(new TotalFlopUp());
	//flopDown.whenPressed(new TotalFlopDown());
	driveStraight.whileHeld(new DriveStraight());
	}
	
}



