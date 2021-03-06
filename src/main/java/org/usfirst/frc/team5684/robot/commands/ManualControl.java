/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.commands;

import org.usfirst.frc.team5684.robot.IO;
import org.usfirst.frc.team5684.robot.Robot;
import org.usfirst.frc.team5684.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ManualControl extends Command {
  private Joystick control;
  private double DEADZONE=.07;
  private boolean stop;
  
  public ManualControl() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.fourBar);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    control=IO.coStick;
    stop=false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double num = control.getRawAxis(1);
    if (num< DEADZONE && num >-1*DEADZONE)
    {
      num=0;
    }
    if(RobotMap.LOCK){
    if(Robot.fourBar.getHeight()>=RobotMap.MAXFOURBARHIEGHT && num>0)
    {
      num=0;
    }
    
   }
  if(num<0 && Robot.fourBar.isAtBottom())
    {
      Robot.fourBar.resetEncoder();
      num=0;
      stop=true;
    }

    Robot.fourBar.set(num);
  }
 

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return stop;
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
}
