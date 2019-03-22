/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.commands;

import org.usfirst.frc.team5684.robot.IO;
import org.usfirst.frc.team5684.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {
  private double kP=.01;
    private Joystick gas;
  public DriveStraight() {
    
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveTrain.getRightEncoder().reset();
    Robot.driveTrain.getLeftEncoder().reset();
    gas=IO.leftStick;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double error = Robot.driveTrain.getLeftEncoder().getDistance() -Robot.driveTrain.getRightEncoder().getDistance();
    System.out.print("RIGHT: " + Robot.driveTrain.getRightEncoder().getDistance());
    System.out.print("\tLeft: " + Robot.driveTrain.getLeftEncoder().getDistance());
    System.out.println("\tERROR: " + error);
    double turn_power = kP * error;
    double power = gas.getRawAxis(1);
    Robot.driveTrain.DriveStraight(-1*power, turn_power);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.DriveStraight(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}
