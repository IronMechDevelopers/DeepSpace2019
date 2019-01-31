/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5684.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;

/**
 * Add your docs here.
 */
public class FourBar extends Subsystem {
  private Spark fourBarMotor;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public FourBar()
  {
    fourBarMotor = new Spark(RobotMap.FOURBAR);
  }
  public void FourBarUp(){
    fourBarMotor.set(0.50);
  }

  public void FourBarDown(){
    fourBarMotor.set(-0.75);
  }

  public void stopFourBar()
  {
    fourBarMotor.set(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
