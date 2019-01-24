/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.subsystems;

import org.usfirst.frc.team5684.robot.RobotMap;
import org.usfirst.frc.team5684.robot.commands.SimpleDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team5684.robot.subsystems.MyCompressor;
import org.usfirst.frc.team5684.robot.subsystems.MySolenoid;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
	 //Put methods for controlling this subsystem
	 //here. Call these from Commands.
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	double maxPeriod = .1;
	int minRate = 0;
	int samplesToAverage = 7;
	private VictorSP left;
	private VictorSP right;
	private DifferentialDrive drive;
	//public static  ADIS16448_IMU gyro;
	private Gyro gyro;

	public DriveTrain() {
		//gyro = new ADIS16448_IMU();
		gyro = new Gyro(true);
		left = new VictorSP(RobotMap.LEFTWHEELMOTOR);
		right = new VictorSP(RobotMap.RIGHTWHEELMOTOR);
		right.setInverted(true);
		left.setInverted(false);
		drive = new DifferentialDrive(left, right);
		drive.setRightSideInverted(false);
		
		

		
		leftEncoder = new Encoder(RobotMap.LEFTWHEELENCODERA, RobotMap.LEFTWHEELENCODERB, true,
				Encoder.EncodingType.k4X);
		leftEncoder.setMaxPeriod(maxPeriod);
		leftEncoder.setMinRate(minRate);
		leftEncoder.setDistancePerPulse(RobotMap.distancePerWheelPulseLeft);
		leftEncoder.setSamplesToAverage(samplesToAverage);
		rightEncoder = new Encoder(RobotMap.RIGHTWHEELENCODERA, RobotMap.RIGHTWHEELENCODERB, false,
				Encoder.EncodingType.k4X);
		rightEncoder.setMaxPeriod(maxPeriod);
		rightEncoder.setMinRate(minRate);
		rightEncoder.setDistancePerPulse(RobotMap.distancePerWheelPulseRight);
		rightEncoder.setSamplesToAverage(samplesToAverage);
		
		leftEncoder.reset();
		rightEncoder.reset();
		
			
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new SimpleDrive());

	}
	
	
	public void simpleDrive(double xSpeed, double zRotation) {
		drive.arcadeDrive(xSpeed, zRotation);
	}

	public void setLeftRight(double leftSpeed, double rightSpeed)
	{
		left.set(leftSpeed);
		right.set(rightSpeed);

	}

	public void stop() {
		drive.arcadeDrive(0, 0, true);
	}

	public void turn(double d) {
		drive.arcadeDrive(0, d, true);
	}
	public double getLeftDistance() {
		return leftEncoder.getDistance();
	}

	public double getRightDistance() {
		return rightEncoder.getDistance();
	}

	public double getLeftSpeed() {
		return leftEncoder.getRate();
	}

	public double getRightSpeed() {
		return rightEncoder.getRate();
	}
	public Encoder getLeftEncoder() {
		return leftEncoder;
	}

	public Encoder getRightEncoder() {
		return rightEncoder;
	}
	
	public VictorSP getRight() {
		return right;
	}
	public VictorSP getLeft() {
		return left;
	}
	public void calibrateGyro() {
		gyro.calibrate();
	}

	public Gyro getGyro() {
		return gyro;
	}
	
	public void resetGyro() {
		if (gyro != null) {
			gyro.reset();
		}
	}

	public double getAngle()
	{
		return gyro.getAngleX();
	}
	
	public void resetEncoder() { 
		leftEncoder.reset();
		rightEncoder.reset();
	}
	public void open() {
		

	}

}