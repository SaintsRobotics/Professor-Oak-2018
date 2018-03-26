package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArcadeDrive extends RunEachFrameTask {
  @Override
  public void runEachFrame() {
    double speedMultiplier = (Robot.instance.flags.liftEncoderValue > 2.8) ? Math.abs( (4.5 - Robot.instance.flags.liftEncoderValue) / 4.5) : 1;
    SmartDashboard.putNumber("speedMultiplier", speedMultiplier);

    double forward = -Robot.instance.oi.xboxInput.leftStickY() * (Robot.instance.oi.xboxInput.B()? 1 : 0.6);
    double turn = -Robot.instance.oi.xboxInput.rightStickX() * 0.75;
    Robot.instance.motors.leftDrive.set((forward - turn) * speedMultiplier);
    Robot.instance.motors.rightDrive.set((forward + turn) * speedMultiplier);
  }
}
