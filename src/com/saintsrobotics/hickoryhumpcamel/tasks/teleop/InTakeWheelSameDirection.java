package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.github.dozer.coroutine.Task;
import com.github.dozer.coroutine.helpers.RunContinuousTask;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class InTakeWheelSameDirection extends RunContinuousTask {

  @Override
  protected void runForever() {
    wait.until(() -> Robot.instance.oi.xboxInput.RB() && Robot.instance.sensors.intake.get());
    Robot.instance.motors.intake.set(1);
    wait.until(() -> !Robot.instance.oi.xboxInput.RB() || !Robot.instance.sensors.intake.get());
    Robot.instance.motors.intake.stop();
  }

}
