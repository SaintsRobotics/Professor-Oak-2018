package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class LiftTask extends RunEachFrameTask {
  private long startTime;

  public LiftTask() {
    this.startTime = System.currentTimeMillis();
  }


  @Override
  protected void runEachFrame() {
    double Rightamount = Robot.instance.oi.xboxInput.rightTrigger();
    double Leftamount = Robot.instance.oi.xboxInput.leftTrigger();
    double currentAmount = Robot.instance.servos.lifter.getAngle();
    long currentTime = System.currentTimeMillis();
    long timeDifference = currentTime - startTime;
    if (Rightamount > 0 && Robot.instance.sensors.lifterUp.get() != true) {

      Robot.instance.servos.lifter.setPosition(currentAmount + Rightamount * timeDifference);

    }
    if (Leftamount > 0 && Robot.instance.sensors.lifterDown.get() != true) {
      Robot.instance.servos.lifter.setPosition(currentAmount - Leftamount * timeDifference);
    }

    this.startTime = currentTime;

  }
}
