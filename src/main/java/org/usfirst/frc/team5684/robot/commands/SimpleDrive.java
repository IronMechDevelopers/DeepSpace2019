/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.commands;

import org.usfirst.frc.team5684.robot.IO;
import org.usfirst.frc.team5684.robot.Robot;
import org.usfirst.frc.team5684.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command. You can replace me with your own command.
 */
public class SimpleDrive extends Command {
	
	private Joystick left;
	private Joystick right;
	private double DEADZONE=.07;

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
	 RobotMap.updateStats();
	double leftInput = left.getRawAxis(1);
	double rightInput = right.getRawAxis(0);
	double tempRightInput = right.getRawAxis(1);
	if(leftInput>0 && leftInput>DEADZONE)
	{
		leftInput=Robot.map(leftInput,DEADZONE,1,0,1);
	}
	else if(leftInput<0 && leftInput<-1*DEADZONE)
	{
		leftInput=Robot.map(leftInput,-1*DEADZONE,-1,0,-1);
	}
	else if(Math.abs(leftInput)<DEADZONE)
	{
		leftInput=0;
	}
	double currentSpeed = (Robot.driveTrain.getRightEncoder().getRate()+Robot.driveTrain.getLeftEncoder().getRate())/2.0;
	double maxTurn=1;


	if(currentSpeed>=60)
	{
		maxTurn=.5;
	}
	if(rightInput>0 && rightInput>DEADZONE)
	{
		rightInput=Robot.map(rightInput,DEADZONE,1,0,maxTurn);
	}
	else if(rightInput<0 && rightInput<-1*DEADZONE)
	{
		rightInput=Robot.map(rightInput,-1*DEADZONE,-1,0,-1*maxTurn);
	}
	else if(Math.abs(rightInput)<DEADZONE)
	{
		rightInput=0;
	}
	 //Robot.driveTrain.simpleDrive(-1*leftInput, rightInput);
	 Robot.driveTrain.tankDrive(-1*  left.getRawAxis(1), -1*right.getRawAxis(1));
 
 }

// Make this return true when this Comman no longer needs to run execute()
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
