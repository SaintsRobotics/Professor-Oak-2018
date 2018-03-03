package com.saintsrobotics.hickoryhumpcamel.tasks.auton;

import com.github.dozer.coroutine.Task;
import com.saintsrobotics.hickoryhumpcamel.Robot;

public class SimpleMoveForward extends Task {

  @Override
  protected void runTask() {
    Robot.instance.motors.leftDrive.set(0.3);
    Robot.instance.motors.rightDrive.set(0.3);
    wait.forSeconds(5.0);
    Robot.instance.motors.leftDrive.set(0);
    Robot.instance.motors.leftDrive.stop();
    Robot.instance.motors.rightDrive.set(0.3);
    Robot.instance.motors.rightDrive.stop();
  }
}
