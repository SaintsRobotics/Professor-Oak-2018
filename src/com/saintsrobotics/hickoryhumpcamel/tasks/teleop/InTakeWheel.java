package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.github.dozer.coroutine.helpers.RunContinuousTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;


public class InTakeWheel extends RunContinuousTask {

  @Override
  protected void runForever() {
    wait.until(() -> Robot.instance.oi.xboxInput.RB() && Robot.instance.sensors.intake.get());
    Robot.instance.motors.intake.set(1);
    wait.until(() -> !Robot.instance.oi.xboxInput.RB() || !Robot.instance.sensors.intake.get());
    Robot.instance.motors.intake.stop();
    Robot.instance.motors.intake.set(0);
  }

}
