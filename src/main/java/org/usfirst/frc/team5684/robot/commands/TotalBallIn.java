/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5684.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TotalBallIn extends CommandGroup {
  /**
   * Add your docs here.
   */
  public TotalBallIn() {
    addParallel(new BallIn());
    addParallel(new FlopIn());
  }
}
