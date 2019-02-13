/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.PathfinderFRC;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

import org.usfirst.frc.team5684.robot.Robot;
import org.usfirst.frc.team5684.robot.RobotMap;


import edu.wpi.first.wpilibj.Encoder;

public class FollowPath extends Command {
private String k_path_name;
  private Encoder m_left_encoder=Robot.driveTrain.getLeftEncoder();
  private Encoder m_right_encoder=Robot.driveTrain.getRightEncoder();
  private EncoderFollower m_left_follower;
  private EncoderFollower m_right_follower;
  private static final double k_max_velocity = 10;




  public FollowPath(String k_path_name) {
    this.k_path_name=k_path_name;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveTrain);
    Trajectory left_trajectory = PathfinderFRC.getTrajectory(k_path_name + ".right");
    Trajectory right_trajectory = PathfinderFRC.getTrajectory(k_path_name + ".left");
    
    
    m_left_follower = new EncoderFollower(left_trajectory);
    m_right_follower = new EncoderFollower(right_trajectory);
    m_left_follower.configureEncoder(m_left_encoder.get(), RobotMap.pulsePerRevolutionLeft, RobotMap.WHEELDIAMETER);
    // You must tune the PID values on the following line!
    m_left_follower.configurePIDVA(1.0, 0.0, 0.0, 1 / k_max_velocity, 0);

    m_right_follower.configureEncoder(m_right_encoder.get(),RobotMap.pulsePerRevolutionRight, RobotMap.WHEELDIAMETER);
    // You must tune the PID values on the following line!
    m_right_follower.configurePIDVA(1.0, 0.0, 0.0, 1 / k_max_velocity, 0);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (m_left_follower.isFinished() || m_right_follower.isFinished()) {
      this.end();
    }else {
      double left_speed = m_left_follower.calculate(m_left_encoder.get());
      double right_speed = m_right_follower.calculate(m_right_encoder.get());
      System.out.println("left_speed: " + left_speed+"\t" + m_left_encoder.getRate());
      System.out.println("right_speed: " + right_speed + "\t" + m_right_encoder.getRate());
      double heading = Robot.driveTrain.getAngle();
      double desired_heading = Pathfinder.r2d(m_left_follower.getHeading());
      heading = desired_heading;
      //TODO assume the heading is correct.
      double heading_difference = Pathfinder.boundHalfDegrees(desired_heading - heading);
      double turn =  0.8 * (-1.0/80.0) * heading_difference;
      Robot.driveTrain.setLeftRight(left_speed + turn,right_speed - turn);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.setLeftRight(0,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}