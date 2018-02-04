package com.saintsrobotics.hickoryhumpcamel.task.auton;

import com.github.dozer.coroutine.Task;
import com.saintsrobotics.hickoryhumpcamel.Robot;

public class SimpleMoveForward extends Task {
  
  @Override
  protected void runTask() {
    Robot.instance.motors.leftDrive.set(0.2);
    Robot.instance.motors.rightDrive.set(0.2);
    wait.forSeconds(5.0);
  }
}