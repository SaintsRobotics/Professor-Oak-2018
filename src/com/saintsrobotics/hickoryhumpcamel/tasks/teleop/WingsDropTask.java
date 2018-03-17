package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.github.dozer.coroutine.Task;
import com.saintsrobotics.hickoryhumpcamel.Robot;

public class WingsDropTask extends Task {
  @Override
  protected void runTask() {
    wait.forSeconds(105);
    wait.until(()->Robot.instance.oi.xboxInput.START());
    Robot.instance.motors.leftWing.set(-1);
    wait.untilWithTimeout(()->Robot.instance.sensors.wingsLeftIn.get() || Robot.instance.sensors.wingsRightIn.get(), 0.5);
    Robot.instance.motors.leftWing.set(0);
    Robot.instance.motors.leftWing.stop();
  }
}
