package org.usfirst.frc.team5684.robot.subsystems;

import org.usfirst.frc.team5684.robot.Robot;
import org.usfirst.frc.team5684.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MyCompressor extends Subsystem {

    Compressor c;
    public MyCompressor()
    {
        c= new Compressor(0);
    }

    public void open()
    {
        c.setClosedLoopControl(true);
    }

    public void close()
    {
        c.setClosedLoopControl(false);
    }

    @Override
    protected void initDefaultCommand() {

    }

}