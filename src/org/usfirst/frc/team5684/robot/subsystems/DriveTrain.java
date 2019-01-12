/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.subsystems;

import org.usfirst.frc.team5684.robot.RobotMap;
import org.usfirst.frc.team5684.robot.commands.SimpleDrive;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
	 //Put methods for controlling this subsystem
	 //here. Call these from Commands.
	private Victor left;
	private Victor right;
	private DifferentialDrive drive;

	public void DriveTrain() {
		left = new Victor(RobotMap.LEFTWHEELMOTOR);
		right = new Victor(RobotMap.RIGHTWHEELMOTOR);
		drive = new DifferentialDrive(left, right);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new SimpleDrive());

	}
	
	
	public void simpleDrive(double forward, double turn) {
		drive.arcadeDrive(forward, turn, true);
	}

	public void stop() {
		drive.arcadeDrive(0, 0, true);
	}

	public void turn(double d) {
		drive.arcadeDrive(0, d, true);
	}
}
