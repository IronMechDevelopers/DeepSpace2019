/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.usfirst.frc.team5684.robot.RobotMap;
import org.usfirst.frc.team5684.robot.commands.SimpleDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// import com.ctre.phoenix.motorcontroller.*;
// import com.ctre.phoenix.motorcontroller.can.*;
/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	double maxPeriod = .8;
	int minRate = 8;
	int samplesToAverage = 10;
	private DifferentialDrive drive;
	private static final int kGyroPort = 0;
	private AnalogGyro mini_gyro = new AnalogGyro(kGyroPort);
	//public static final ADIS16448_IMU imu = new ADIS16448_IMU();
	private VictorSPX leftMaster;
	private VictorSPX leftSlave;
	private VictorSPX rightMaster;
	private VictorSPX rightSlave;
	


	public DriveTrain() {

		rightMaster= new VictorSPX(RobotMap.RIGHTMASTER);
		rightSlave= new VictorSPX(RobotMap.RIGHTSLAVE);
		rightMaster.configFactoryDefault();
		rightSlave.follow(rightMaster);

		leftMaster= new VictorSPX(RobotMap.LEFTMASTER);
		leftSlave= new VictorSPX(RobotMap.LEFTSLAVE);
		leftMaster.configFactoryDefault();

		rightMaster.setInverted(true);
		rightSlave.setInverted(true);

		leftMaster.setNeutralMode(NeutralMode.Brake);
		rightMaster.setNeutralMode(NeutralMode.Brake);
		leftSlave.setNeutralMode(NeutralMode.Brake);
		rightSlave.setNeutralMode(NeutralMode.Brake);

		leftSlave.follow(leftMaster);
		
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

	public void setUpGyro()
	{
		// imu.reset();
		// imu.calibrate();
		mini_gyro.reset();
		mini_gyro.calibrate();
	}
	
	
	public void simpleDrive(double xSpeed, double zRotation) {
		xSpeed = xSpeed * RobotMap.GEAR;
		zRotation = zRotation * RobotMap.GEAR;
		leftMaster.set(ControlMode.PercentOutput,xSpeed+zRotation);
		rightMaster.set(ControlMode.PercentOutput,xSpeed-zRotation);
	}

	public void tankDrive(double left, double right)
	{
		left = left * RobotMap.GEAR;
		right = right * RobotMap.GEAR;
		leftMaster.set(ControlMode.PercentOutput,left);
		rightMaster.set(ControlMode.PercentOutput,right);
	}

	public void setLeftRight(double leftSpeed, double rightSpeed)
	{
		leftMaster.set(ControlMode.PercentOutput,leftSpeed);
		rightMaster.set(ControlMode.PercentOutput,rightSpeed);

	}

	public void stop() {
		leftMaster.set(ControlMode.PercentOutput,0);
		rightMaster.set(ControlMode.PercentOutput,0);
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
	
	public VictorSPX getRight() {
		return rightMaster;
	}
	public VictorSPX getLeft() {
		return leftMaster;
	}
	public void calibrateGyro() {
		// imu.calibrate();
	}

	public ADIS16448_IMU getGyro() {
		// return imu;
		return null;
	}
	
	public void resetGyro() {
		// if (imu != null) {
		// 	imu.reset();
		// }
	}

	public double getAngle()
	{
		// SmartDashboard.putNumber("TIME", System.currentTimeMillis());
		// SmartDashboard.putNumber("MINI", mini_gyro.getAngle());
		// SmartDashboard.putNumber("BIG", imu.getAngle());
		// SmartDashboard.putNumber("BIGX", imu.getAngleX());
		// SmartDashboard.putNumber("BIGY", imu.getAngleY());
		// SmartDashboard.putNumber("BIGZ", imu.getAngleZ());
		// return imu.getAngleX();
		return mini_gyro.getAngle();
	}

	public double getTinyAngle()
	{
		return mini_gyro.getAngle();
	}
	
	public void resetEncoder() { 
		leftEncoder.reset();
		rightEncoder.reset();
	}
	public void open() {
		

	}

}