/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5684.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;

/**
 * Add your docs here.
 */
public class Flopper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Victor intakeMotor;
  private Victor flopperMotor;
  private double flopperSpeed = .5;
  private double intakeSpeed = 1;
  private DigitalInput limitSwitchUp = new DigitalInput(RobotMap.LINITFLOPPERUP);
  private DigitalInput limitSwitchDown = new DigitalInput(RobotMap.LINITFLOPPERDOWN);
  

  
  public Flopper() {
   intakeMotor = new Victor(RobotMap.FLOPPERINTAKE);
   flopperMotor = new Victor(RobotMap.FLOPPER);
   
  }
  public void FlopUp()
  {
    flopperMotor.set(flopperSpeed);
  }
  public void FlopDown()
  {
    flopperMotor.set(-1*flopperSpeed);
  }
  public void FlopIn()
  {
    intakeMotor.set(intakeSpeed*-1);
  }
  public void FlopOut()
   {
     intakeMotor.set(intakeSpeed);
   }
   public void killIntake()
   {
     intakeMotor.set(0);
   }
   public void killFlop()
   {
     flopperMotor.set(0);
   }
   public void killBoth()
    {
      flopperMotor.set(0);
      intakeMotor.set(0);
    }

    public boolean isFlopperUp()
    {
      return limitSwitchUp.get();
    }

  @Override
  protected void initDefaultCommand() {

  }
public boolean isFlopperDown() {
	return limitSwitchDown.get();
}
}
