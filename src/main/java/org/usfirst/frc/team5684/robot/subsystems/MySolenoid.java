/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class MySolenoid extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  DoubleSolenoid exampleDouble;

  public MySolenoid()
  {
    exampleDouble = new DoubleSolenoid(3,2);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void open()
  {
    exampleDouble.set(DoubleSolenoid.Value.kForward);
  }
  public void close()
  {
    exampleDouble.set(DoubleSolenoid.Value.kReverse);
  }
  public void kill()
  {
    exampleDouble.set(DoubleSolenoid.Value.kOff);
  }
}
