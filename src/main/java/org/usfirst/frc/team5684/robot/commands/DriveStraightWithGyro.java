package org.usfirst.frc.team5684.robot.commands;

import org.usfirst.frc.team5684.robot.Robot;
import org.usfirst.frc.team5684.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraightWithGyro extends Command {
	double distance;
	double kp = .25;
	double speed;
	final double DELTA = .01;

	public DriveStraightWithGyro(double distance) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);
		Robot.driveTrain.getLeftEncoder().reset();
		Robot.driveTrain.getRightEncoder().reset();
		this.distance = distance;
		speed = 0;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
	
		Robot.driveTrain.resetEncoder();
		Robot.driveTrain.resetGyro();
		this.distance = distance;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putNumber("LeftWheels", Robot.driveTrain.getLeftEncoder().getDistance());
		SmartDashboard.putNumber("RightWheels", Robot.driveTrain.getRightEncoder().getDistance());
		SmartDashboard.putNumber("X: ", Robot.driveTrain.getGyro().getAngleX());
		SmartDashboard.putNumber("Y: ", Robot.driveTrain.getGyro().getAngleY());
		SmartDashboard.putNumber("Z: ", Robot.driveTrain.getGyro().getAngleZ());
		double angle = -1 * Robot.driveTrain.getGyro().getAngleZ();
		if (distance >= 0) {

			if (getTraveledDistance() >= distance / 2.0) {
				speed = Math.max(speed - DELTA, .65);
			} else {
				speed = speed + DELTA;
			}
			speed = Math.min(speed, 1);
			speed = Math.max(speed, -1);
			Robot.driveTrain.simpleDrive(speed, angle * kp);
		} else {
			if (Math.abs(getTraveledDistance()) >= Math.abs(3.0 * distance / 4.0)) {
				speed = Math.max(speed - DELTA, .65);
			} else {
				speed = speed + DELTA;
			}
			speed = Math.min(speed, 1);
			speed = Math.max(speed, -1);
			SmartDashboard.putNumber("Auto Speed", speed);

			Robot.driveTrain.simpleDrive(-1 * speed, -1 * angle * kp);
		}
	}

	private double getTraveledDistance() {
		return (Math.abs(Robot.driveTrain.getRightDistance() + Robot.driveTrain.getLeftDistance()) / 2.0);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if ((Math.abs(Robot.driveTrain.getRightDistance() + Robot.driveTrain.getLeftDistance()) / 2.0) >= Math
				.abs(distance))
			return true;
		else
			return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
		//RobotMap.writeLog("DriveStraightWithGyro end");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
