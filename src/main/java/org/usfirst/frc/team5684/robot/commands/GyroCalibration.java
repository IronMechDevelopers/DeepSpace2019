package org.usfirst.frc.team5684.robot.commands;

import org.usfirst.frc.team5684.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GyroCalibration extends Command {

	private boolean isFinished;
	
	public GyroCalibration()
	{
		requires(Robot.driveTrain);
		isFinished = false;
		System.out.println("init Gyro Calibrated");
	}
	protected void execute() {
		System.out.println("start Gyro Calibrated");
		isFinished = true;
		Robot.driveTrain.calibrateGyro();
		
	System.out.println("Gyro Calibrated");
	}
	 protected void initialize() {
	// this does nothing
		 }

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isFinished;
	}
	
	

}
