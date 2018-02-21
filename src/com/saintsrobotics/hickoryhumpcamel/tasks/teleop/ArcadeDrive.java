package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArcadeDrive extends RunEachFrameTask {
  @Override
  public void runEachFrame() {
    double forward = -Robot.instance.oi.xboxInput.leftStickY() * 0.8;
    double turn = -Robot.instance.oi.xboxInput.rightStickX() * 0.6;
    Robot.instance.motors.leftDrive.set(forward - turn);
    Robot.instance.motors.rightDrive.set(forward + turn);
  }
}
