package com.saintsrobotics.hickoryhumpcamel.tasks.auton;

import com.github.dozer.coroutine.Task;
import com.saintsrobotics.hickoryhumpcamel.Robot;

public class SpinOutTask extends Task {

  @Override
  protected void runTask() {
    Robot.instance.motors.intake.set(-1);
    wait.forSeconds(2);
    Robot.instance.motors.intake.stop();

  }

}
