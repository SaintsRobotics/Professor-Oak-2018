package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.github.dozer.coroutine.Task;
import com.github.dozer.coroutine.helpers.RunContinuousTask;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class InTakeWheel extends RunContinuousTask {

  @Override
  protected void runForever() {
    wait.until(() -> Robot.instance.oi.xboxInput.RB());
    Robot.instance.motors.intake.set(0.2);
    wait.until(() -> !Robot.instance.oi.xboxInput.RB() || Robot.instance.sensors.intake.get());
    Robot.instance.motors.intake.stop();
  }

}
