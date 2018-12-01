package com.saintsrobotics.hickoryhumpcamel.tasks.auton;

import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class EncoderReportTask extends RunEachFrameTask {

  @Override
  protected void runEachFrame() {
    SmartDashboard.putNumber("Left Encoder Distance", Robot.instance.sensors.leftEncoder.get());
    SmartDashboard.putNumber("Right Encoder Distance", Robot.instance.sensors.rightEncoder.get());
    SmartDashboard.putNumber("Encoder Avg Distance", Robot.instance.sensors.average.pidGet());
    SmartDashboard.putNumber("Lift Height", Robot.instance.sensors.liftEncoder.getDistance());
  }

}
