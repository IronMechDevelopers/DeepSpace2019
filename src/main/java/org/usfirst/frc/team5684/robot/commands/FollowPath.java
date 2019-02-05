/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.commands;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.PathfinderFRC;
import jaci.pathfinder.Trajectory;

public class FollowPath extends Command {
  private String k_path_name = "leftHatch";
  private SpeedController m_left_motor;
  private SpeedController m_right_motor;



  public FollowPath() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    Trajectory left_trajectory = PathfinderFRC.getTrajectory(k_path_name + ".left");
    Trajectory right_trajectory = PathfinderFRC.getTrajectory(k_path_name + ".right");
    
    //EncoderFollower m_left_follower = new EncoderFollower(left_trajectory);
    //EncoderFollower m_right_follower = new EncoderFollower(right_trajectory);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //double right_speed = m_right_follower.calculate(m_right_encoder.get());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
