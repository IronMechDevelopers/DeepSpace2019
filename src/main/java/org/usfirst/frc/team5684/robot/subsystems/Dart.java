/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.subsystems;

import org.usfirst.frc.team5684.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 * Add your docs here.
 */
public class Dart extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Potentiometer pot;
  private Victor motor;

  @Override
  public void initDefaultCommand() {
    
    pot = new AnalogPotentiometer(0, 360*10, 30);;
    motor = new Victor(RobotMap.DART);
  }

  public void dartOut()
  {
    motor.set(RobotMap.DARTSPEED);
  }

  public void dartIn()
  {
    motor.set(-1*RobotMap.DARTSPEED);
  }

  public void stopDart()
  {
    motor.set(0);
  }

  public double readPot()
  {
    return pot.get();
  }
}
