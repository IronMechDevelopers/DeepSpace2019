/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.subsystems;

import org.usfirst.frc.team5684.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class HatchCollector extends Subsystem {
private Spark hatchMotor;


  public HatchCollector() {

    hatchMotor = new Spark(RobotMap.HATCH);
    hatchMotor.setInverted(true);
  }

  public void HatchUp() {

    hatchMotor.set(.75);
  }
  public void HatchDown() {

    hatchMotor.set(-.6);
  }
  public void HatchStop() {

    hatchMotor.set(0);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
