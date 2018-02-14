package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class LiftTaskWithMotor extends RunEachFrameTask {


  @Override
  protected void runEachFrame() {
    double movementAmount =
        Robot.instance.oi.xboxInput.rightTrigger() - Robot.instance.oi.xboxInput.leftTrigger();
    if (Robot.instance.sensors.lifterUp.get() && movementAmount > 0) {
      movementAmount = 0;
    }
    if (Robot.instance.sensors.lifterDown.get() && movementAmount < 0) {
      movementAmount = 0;
    }
    Robot.instance.motors.lifter.set(movementAmount);
  }
}
