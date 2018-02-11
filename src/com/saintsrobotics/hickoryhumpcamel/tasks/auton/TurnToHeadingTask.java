package com.saintsrobotics.hickoryhumpcamel.tasks.auton;

import com.github.dozer.coroutine.Task;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import com.saintsrobotics.hickoryhumpcamel.util.PIDConfiguration;
import com.saintsrobotics.hickoryhumpcamel.util.PIDReceiver;

public class TurnToHeadingTask extends Task {
  private double heading;
  private PIDReceiver headingPidReceiver;
  private PIDController headingPidController;
  private PIDSource gyro;

  public TurnToHeadingTask(double heading, PIDConfiguration pidConfig) {
    this.heading = heading;
    this.gyro = pidConfig.gyro;
    this.headingPidReceiver = new PIDReceiver();
    this.headingPidController = new PIDController(pidConfig.turnHeadingKP, pidConfig.turnHeadingKI,
        pidConfig.turnHeadingKD, gyro, headingPidReceiver);
    this.headingPidController.setAbsoluteTolerance(pidConfig.turnHeadingTolerance);
  }

  @Override
  protected void runTask() {
    this.headingPidController.enable();
    this.headingPidController.setSetpoint(this.heading + this.gyro.pidGet());
    while (!this.headingPidController.onTarget()) {
      double headingOutput = this.headingPidReceiver.getOutput();
      Robot.instance.motors.leftDrive.set(headingOutput);
      Robot.instance.motors.rightDrive.set(-headingOutput);
      wait.forFrame();
    }
    Robot.instance.motors.leftDrive.set(0);
    Robot.instance.motors.rightDrive.set(0);
  }
}
