/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
//import jaci.pathfinder.Trajectory;
//import jaci.pathfinder.followers.EncoderFollower;

public class Follow extends Command {
  private static final int k_ticks_per_rev = 360;
  private static final double k_wheel_diameter = 6.0 / 12.0;
  private static final double k_max_velocity = 4.0;
  //Trajectory left_trajectory;
  //Trajectory right_trajectory;
  //private EncoderFollower m_left_follower;
  //private EncoderFollower m_right_follower;

  private static final String k_path_name = "Unnamed";
  public Follow() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    //left_trajectory = PathfinderFRC.getTrajectory(k_path_name + ".left");
    //right_trajectory = PathfinderFRC.getTrajectory(k_path_name + ".right");
    //m_left_follower=new EncoderFollower(left_trajectory);
    //m_right_follower=new EncoderFollower(right_trajectory);

    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
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
