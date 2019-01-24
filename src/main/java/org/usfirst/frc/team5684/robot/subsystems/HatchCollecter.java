/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.subsystems;
import org.usfirst.frc.team5684.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class HatchCollecter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private DoubleSolenoid hatch = new DoubleSolenoid(RobotMap.hatchOpen, RobotMap.hatchClose);

  public void open() {

    hatch.set(DoubleSolenoid.Value.kForward);
  }
  public void close() {
    hatch.set(DoubleSolenoid.Value.kReverse);
  }

  public void kill()
  {
    hatch.set(DoubleSolenoid.Value.kOff);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
