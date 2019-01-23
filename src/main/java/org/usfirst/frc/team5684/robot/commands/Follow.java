/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.commands;

import org.usfirst.frc.team5684.robot.Robot;
import org.usfirst.frc.team5684.robot.RobotMap;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.PathfinderFRC;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

public class Follow extends Command {
  private static final int k_ticks_per_rev_left = RobotMap.pulsePerRevolutionLeft;
  private static final int k_ticks_per_rev_right = RobotMap.pulsePerRevolutionRight;
  private static final double k_wheel_diameter = RobotMap.WHEELDIAMETER;
  private static final double k_max_velocity = .5;

  private static final String k_path_name = "leftHatch";

  private EncoderFollower m_left_follower;
  private EncoderFollower m_right_follower;


  public Follow() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveTrain);
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveTrain.resetEncoder();
    SmartDashboard.putNumber("time", System.currentTimeMillis());
    Trajectory left_trajectory = PathfinderFRC.getTrajectory(k_path_name + ".left");
    Trajectory right_trajectory = PathfinderFRC.getTrajectory(k_path_name + ".right");

    m_left_follower = new EncoderFollower(left_trajectory);
    m_right_follower = new EncoderFollower(right_trajectory);



    m_left_follower.configureEncoder(Robot.driveTrain.getLeftEncoder().get(), k_ticks_per_rev_left, k_wheel_diameter);
    // You must tune the PID values on the following line!
    m_left_follower.configurePIDVA(1.2, 0.0, 0.0, 1 / k_max_velocity, 0);

    m_right_follower.configureEncoder(Robot.driveTrain.getRightEncoder().get(), k_ticks_per_rev_right, k_wheel_diameter);
    // You must tune the PID values on the following line!
    m_right_follower.configurePIDVA(1.2, 0.0, 0.0, 1 / k_max_velocity, 0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    SmartDashboard.putNumber("right Speed", Robot.driveTrain.getRightSpeed());
    SmartDashboard.putNumber("left Speed", Robot.driveTrain.getLeftSpeed());
    double left_speed = m_left_follower.calculate(Robot.driveTrain.getLeftEncoder().get());
    double right_speed = m_right_follower.calculate(Robot.driveTrain.getRightEncoder().get());
    double heading = Robot.driveTrain.getAngle();
    
      
    double desired_heading = Pathfinder.r2d(m_left_follower.getHeading());
    heading = desired_heading;
    double heading_difference = Pathfinder.boundHalfDegrees(desired_heading - heading);
    double turn =  0.8 * (-1.0/80.0) * heading_difference;
    Robot.driveTrain.setLeftRight(left_speed + turn,right_speed - turn );

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (m_left_follower.isFinished() || m_right_follower.isFinished()) {
      return true;
    }
    else{
      return false;
    }
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
