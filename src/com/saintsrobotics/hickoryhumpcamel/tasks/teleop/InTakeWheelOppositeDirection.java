package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.github.dozer.coroutine.Task;
import com.github.dozer.coroutine.helpers.RunContinuousTask;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class InTakeWheelOppositeDirection extends RunContinuousTask {

  @Override
  protected void runForever() {
    wait.until(() -> Robot.instance.oi.xboxInput.A() && Robot.instance.sensors.intake.get());
    Robot.instance.motors.intakeLeft.set(-0.5);
    Robot.instance.motors.intakeRight.set(0.5);
    wait.until(() -> !Robot.instance.oi.xboxInput.A() || !Robot.instance.sensors.intake.get());
    Robot.instance.motors.intakeLeft.stop();
    Robot.instance.motors.intakeRight.stop();
  }

}
