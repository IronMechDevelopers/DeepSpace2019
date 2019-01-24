/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Gyro extends Subsystem {
  private static final int kGyroPort = 0;

	// gyro calibration constant, may need to be adjusted;
	// gyro value of 360 is set to correspond to one full revolution
  private static final double kVoltsPerDegreePerSecond = 0.0128;
  private AnalogGyro m_gyro = new AnalogGyro(kGyroPort);
  public static ADIS16448_IMU bigGyro;
  // Put methods for controlling this subsystem
  // here. Cal=l these from Commands.
  private boolean isBig;

  public Gyro(boolean isBig)
  {
    this.isBig=isBig;
    m_gyro.setSensitivity(kVoltsPerDegreePerSecond);
    System.out.println("Start calibrate");
    m_gyro.calibrate();
    bigGyro=new ADIS16448_IMU();
    bigGyro.calibrate();
    System.out.println("end calibrate");
  }

  public double getAngleX()
  {
    if(isBig)
    {
      return bigGyro.getAngleX();
    }
    return m_gyro.getAngle();
  }

  public double getAngleY()
  {
    if(isBig)
    {
      return bigGyro.getAngleY();
    }
    return m_gyro.getAngle();
  }

  public double getAngleZ()
  {
    if(isBig)
    {
      return bigGyro.getAngleZ();
    }
    return m_gyro.getAngle();
  }

  public void reset()
  {
    m_gyro.reset();
    bigGyro.reset();
  }

  public void calibrate()
  {
    m_gyro.calibrate();
    bigGyro.reset();
  }

  @Override
  protected void initDefaultCommand() {

  }

}
