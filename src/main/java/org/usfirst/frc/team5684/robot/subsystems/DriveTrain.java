/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SPI;
import org.usfirst.frc.team5684.robot.RobotMap;
import org.usfirst.frc.team5684.robot.commands.SimpleDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
	 //Put methods for controlling this subsystem
	 //here. Call these from Commands.
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	double maxPeriod = .8;
	int minRate = 8;
	int samplesToAverage = 10;
	private VictorSP left;
	private VictorSP right;
	private DifferentialDrive drive;
	private static final double kVoltsPerDegreePerSecond = 0.0128;
	private static final int kGyroPort = 0;
	private AnalogGyro mini_gyro = new AnalogGyro(kGyroPort);
	public static final ADIS16448_IMU imu = new ADIS16448_IMU();


	public DriveTrain() {
		imu.calibrate();
		mini_gyro.setSensitivity(kVoltsPerDegreePerSecond);
		mini_gyro.calibrate();

		left = new VictorSP(RobotMap.LEFTWHEELMOTOR);
		right = new VictorSP(RobotMap.RIGHTWHEELMOTOR);
		right.setInverted(true);
		left.setInverted(false);
		drive = new DifferentialDrive(left, right);
		drive.setRightSideInverted(false);
		
		

		
		leftEncoder = new Encoder(RobotMap.LEFTWHEELENCODERA, RobotMap.LEFTWHEELENCODERB, true,
				Encoder.EncodingType.k2X);
		leftEncoder.setMaxPeriod(maxPeriod);
		leftEncoder.setMinRate(minRate);
		leftEncoder.setDistancePerPulse(RobotMap.distancePerWheelPulseLeft);
		leftEncoder.setSamplesToAverage(samplesToAverage);
		rightEncoder = new Encoder(RobotMap.RIGHTWHEELENCODERA, RobotMap.RIGHTWHEELENCODERB, false,
				Encoder.EncodingType.k2X);
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
		imu.calibrate();
	}

	public ADIS16448_IMU getGyro() {
		return imu;
	}
	
	public void resetGyro() {
		if (imu != null) {
			imu.reset();
		}
	}

	public double getAngle()
	{
		SmartDashboard.putNumber("TIME", System.currentTimeMillis());
		SmartDashboard.putNumber("MINI", mini_gyro.getAngle());
		SmartDashboard.putNumber("BIG", imu.getAngle());
		SmartDashboard.putNumber("BIGX", imu.getAngleX());
		SmartDashboard.putNumber("BIGY", imu.getAngleY());
		SmartDashboard.putNumber("BIGZ", imu.getAngleZ());
		return mini_gyro.getAngle();
	}
	
	public void resetEncoder() { 
		leftEncoder.reset();
		rightEncoder.reset();
	}
	public void open() {
		

	}

}