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
  private double maxSpeed = .75;
  private double minSpeed = -1*maxSpeed;
  public FourBarToHeight(double goal) {
    requires(Robot.fourBar);
    goalHeight=goal;
    currentHeight= Robot.fourBar.getHeight();
    startHeight= Robot.fourBar.getHeight();
    System.out.println("GOAL: " + goalHeight);
    System.out.println("Current: " + currentHeight);
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
    currentHeight= Robot.fourBar.getHeight();
    startHeight= Robot.fourBar.getHeight();
    System.out.println("GOAL: " + goalHeight);
    System.out.println("Current: " + currentHeight);
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
    speed = bound(speed,maxSpeed,minSpeed);
    Robot.fourBar.set(speed);
    System.out.println("Speed is at: " + speed);
    System.out.println("Postion is at : " + Robot.fourBar.getHeight());
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Math.abs(Robot.fourBar.getHeight()-goal)<=2 * RobotMap.INCHES)
    {
      System.out.println("\t\t" + Math.abs(Robot.fourBar.getHeight()-goal));
      System.out.println("Thank you for flying Rad airways");
      return true;
    }
      if (Robot.fourBar.getHeight()>=RobotMap.MAXFOURBARHIEGHT ||Robot.fourBar.getHeight()<=RobotMap.MINFOURBARHEIGHT )
      {
        System.out.println("Stopped for saftey reasons");
      return true;
      }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.fourBar.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();

  }

  private double bound(double value, double max, double min)
  {
    return Math.max(Math.min(value,max),min);
  }

}
