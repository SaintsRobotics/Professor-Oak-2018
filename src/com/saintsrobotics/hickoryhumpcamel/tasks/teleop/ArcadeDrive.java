package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.DriverStation;

public class ArcadeDrive extends RunEachFrameTask {
  @Override
  public void runEachFrame() {
    double forward = Robot.instance.oi.xboxInput.leftStickY() * -0.4;
    double turn = Robot.instance.oi.xboxInput.rightStickX() * 0.4;
    Robot.instance.motors.leftDrive.set(forward + turn);
    Robot.instance.motors.rightDrive.set(forward - turn);
  }
}
