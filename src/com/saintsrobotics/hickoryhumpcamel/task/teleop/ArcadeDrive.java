package com.saintsrobotics.hickoryhumpcamel.task.teleop;

import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.DriverStation;

public class ArcadeDrive extends RunEachFrameTask {
  @Override
  public void runEachFrame() {
    double forward = Robot.instance.oi.xboxInput.leftStickY();
    double turn = Robot.instance.oi.xboxInput.rightStickX();
    Robot.instance.motors.leftDrive.set(forward + turn);
    Robot.instance.motors.rightDrive.set(forward - turn);
  }
}
