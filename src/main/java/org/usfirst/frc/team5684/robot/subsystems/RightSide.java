package org.usfirst.frc.team5684.robot.subsystems;

import org.usfirst.frc.team5684.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RightSide extends PIDSubsystem{

	private Victor right;
	private Encoder rightEncoder;
	public static double set=0;
	public static double last=0.0;
	public static double delta=.075;
	
	public RightSide(){
		super(.3, 0, 0);
		rightEncoder=Robot.driveTrain.getRightEncoder();
		right = Robot.driveTrain.getRight();
		setAbsoluteTolerance(.5);
		this.setOutputRange(-1,1);
		this.setInputRange(-200, 200);
		System.out.println("delta");
	}
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return rightEncoder.getDistance();
		
	}
	
	
	

	@Override
	protected void usePIDOutput(double output) {
		output=Robot.limitChange(last, output, delta);
		right.set(output);
		last = output;
		
		System.out.println("\t" + output);
		SmartDashboard.putNumber("right Speed ", rightEncoder.getDistance());
	}

	@Override
	protected void initDefaultCommand() {
		
	}

}
