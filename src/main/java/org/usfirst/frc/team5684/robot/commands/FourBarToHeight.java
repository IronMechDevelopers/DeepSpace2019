/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.commands;

import org.usfirst.frc.team5684.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class FourBarToHeight extends Command {
  private double goal;
  private double delta=.05;
  private boolean isForward;
  private double speed;
  private double halfwayPoint;
  public FourBarToHeight(double goal) {
    this.goal=goal;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.fourBar);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    speed=0;
     double current = Robot.fourBar.getPosition();
      halfwayPoint = (goal-current)/2;
     if(current<goal)
     {
       isForward=true;
     }
     else
     {
       isForward=false;
     }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // if(Robot.fourBar.getPosition() <= halfwayPoint)
    // {
      speed+=delta;
    // }
    // else
    // {
    //   speed-=delta;
    // }
    Robot.fourBar.set(speed);
    System.out.println("Speed is at: " + speed);
    System.out.println("Postion is at : " + Robot.fourBar.getPosition());
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.fourBar.getPosition()>=800)
      return true;
    if(Math.abs(Robot.fourBar.getPosition() - goal) <= 5)
      return true;
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
