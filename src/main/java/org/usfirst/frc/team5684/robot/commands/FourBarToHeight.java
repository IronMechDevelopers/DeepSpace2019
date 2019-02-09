/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.commands;

import org.usfirst.frc.team5684.robot.Robot;
import org.usfirst.frc.team5684.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class FourBarToHeight extends Command {
  private double goal;
  private double delta=.05;
  private double speed;
  private double startHeight;
  private double goalHeight;
  private double currentHeight;
  private int forward;
  private double midpoint;
  public FourBarToHeight(double goal) {
    requires(Robot.fourBar);
    goalHeight=goal;
    currentHeight= Robot.fourBar.getHeight();
    startHeight= Robot.fourBar.getHeight();
    midpoint=(goalHeight+currentHeight)/2.0;
    //check to see if we need to go up or down.  if we are going down we will invert all
    //ou operations.
    if(goalHeight>currentHeight)
    {
      forward=1;
    }
    else
    {
      forward=-1;
    }
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    speed=0;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(forward * Robot.fourBar.getHeight() <= forward * midpoint)
    {
      speed+=forward*delta;
      System.out.println(Robot.fourBar.getHeight()+"\t increase speed");
     }
    else
    {
      speed-=forward*delta;
      System.out.println(Robot.fourBar.getHeight()+"\t decrease speed");
    }
    Robot.fourBar.set(speed);
    System.out.println("Speed is at: " + speed);
    System.out.println("Postion is at : " + Robot.fourBar.getHeight());
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Math.abs(Robot.fourBar.getHeight()-goal)>=2 * RobotMap.INCHES)
      return true;
      if (Robot.fourBar.getHeight()>=RobotMap.MAXFOURBARHIEGHT ||Robot.fourBar.getHeight()<=RobotMap.MINFOURBARHEIGHT )
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
