/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team5684.robot.IO;
import org.usfirst.frc.team5684.robot.Robot;

/**
 * An example command. You can replace me with your own command.
 */
public class SimpleDrive extends Command {
	
	private Joystick left;
	private Joystick right;

	public SimpleDrive() {

	//Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

 //Called just before this Command runs the first time
@Override
 protected void initialize() {
 left = IO.leftStick;
 right = IO.rightStick;
 }

// Called repeatedly when this Command is scheduled to run
@Override
 protected void execute() {
 double leftInput = left.getX(GenericHID.Hand.kLeft);
 double rightInput = right.getY(GenericHID.Hand.kRight);
 Robot.driveTrain.simpleDrive(leftInput, rightInput);
 }

// Make this return true when this Command no longer needs to run execute()
@Override
 protected boolean isFinished() {
 return false;
 }

// Called once after isFinished returns true
@Override
 protected void end() {
 }

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
@Override
 protected void interrupted() {
 }
 }
