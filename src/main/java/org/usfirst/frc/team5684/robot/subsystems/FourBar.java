/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5684.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;

/**
 * Add your docs here.
 */
public class FourBar extends Subsystem {
  private Spark fourBarMotor;
  private Encoder enc;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public FourBar()
  {
    fourBarMotor = new Spark(RobotMap.FOURBAR);
    fourBarMotor.setInverted(true);
    enc = new Encoder(RobotMap.FORBARENCODERA, RobotMap.FORBARENCODERB, true,
    Encoder.EncodingType.k4X);
    enc.setDistancePerPulse(.05);
  }


  public double getPosition()
  {
    return enc.getDistance();
  }


  public void FourBarUp(){
    fourBarMotor.set(0.75);
  }

  public void FourBarDown(){
    fourBarMotor.set(-0.5);
  }

  public void set(double speed)
  {
    fourBarMotor.set(speed);
  }

  public void stopFourBar()
  {
    fourBarMotor.set(0);
  }

  public double readEncoder()
  {
    return enc.getDistance();
  }

  /**
   * Returns the current hight of the fourbar measured from the bottom of the scoop.
   * @return Current height in feet.
   */
  public double getHeight()
  {
      return 0.0364*enc.getDistance()-0.2371;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
