/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.subsystems;

import org.usfirst.frc.team5684.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class LinearActuator extends Subsystem {
  // Put methods for controlling this subsystem
  private Servo linearAct;
 
  
 public LinearActuator()
 {
 linearAct = new Servo(RobotMap.LINEARACTUATOR);
 }

 public void set(double num)
 {
  linearAct.set(num);
 }
public void LinearTurnRight()
{
  linearAct.set(0.5);
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
