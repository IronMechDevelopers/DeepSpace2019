/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.subsystems;

import org.usfirst.frc.team5684.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class BallIntake extends Subsystem {
    private Victor ballMotor;
    private double flopperWheelsSpeed=1;

    

    public BallIntake()
    {
    
      ballMotor = new Victor(RobotMap.BALLINTAKE);
      ballMotor.setInverted(!ballMotor.getInverted());
    }
    
    
    
    public void BallIn()
    {
      ballMotor.set(flopperWheelsSpeed);
    }
    
    public void BallOut() 
    {
      ballMotor.set(-1*flopperWheelsSpeed);
    }

    public void BallStop()
    {
      ballMotor.set(0);
    }
    
    
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
