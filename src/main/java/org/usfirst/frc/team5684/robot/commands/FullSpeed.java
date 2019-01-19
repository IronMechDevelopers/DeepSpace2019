package org.usfirst.frc.team5684.robot.commands;

import org.usfirst.frc.team5684.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class FullSpeed extends Command {
	double speed;
	Encoder left;
	Encoder right;
	double setSpeed;
	public FullSpeed(double setSpeed) {
		this.setSpeed=setSpeed;
		requires(Robot.driveTrain);
		Robot.driveTrain.getLeftEncoder().reset();
		Robot.driveTrain.getRightEncoder().reset();
		speed = 1;
	}

	protected void initialize() {
		Robot.driveTrain.resetEncoder();
		right = Robot.driveTrain.getRightEncoder();
		right.reset();
		Robot.rightWheels.setSetpoint(setSpeed);
		Robot.rightWheels.enable();
	}

	protected void execute() {
		//Robot.driveTrain.goToSpeed(speed);
		
		String temp = "";
		temp += System.currentTimeMillis() + "\t";
		temp += right.getRate() + "\t";
		temp+= Robot.rightWheels.set +"\t";
		//System.out.println(temp);
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if(Robot.rightWheels.onTarget())
		{
			System.out.println("DONE");
			return true;
		}
		return false;
	}
	
	
	// Called once after isFinished returns true
	protected void end() {
		System.out.println("END");
		Robot.driveTrain.stop();
		Robot.rightWheels.disable();
	}

}
