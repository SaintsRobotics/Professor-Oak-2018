package com.saintsrobotics.hickoryhumpcamel.util;

import com.saintsrobotics.hickoryhumpcamel.output.Motors;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;

public class UpdateMotors extends RunEachFrameTask {
  private Motors motors;

  public UpdateMotors(Motors motors) {
    this.motors = motors;
  }

  @Override
  protected void runEachFrame() {
    motors.update();
  }
}
