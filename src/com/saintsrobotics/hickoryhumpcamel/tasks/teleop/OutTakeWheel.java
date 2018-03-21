package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.github.dozer.coroutine.helpers.RunContinuousTask;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class OutTakeWheel extends RunContinuousTask {

  @Override
  protected void runForever() {
    wait.until(()->Robot.instance.oi.xboxInput.LB() && !Robot.instance.oi.xboxInput.RB());
    Robot.instance.motors.intake.set(-1);
    wait.until(()->!Robot.instance.oi.xboxInput.LB() || Robot.instance.oi.xboxInput.RB());
    Robot.instance.motors.intake.set(0);
    Robot.instance.motors.intake.stop();
  }
}
