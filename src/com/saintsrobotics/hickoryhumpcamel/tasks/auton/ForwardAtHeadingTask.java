package com.saintsrobotics.hickoryhumpcamel.tasks.auton;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.saintsrobotics.hickoryhumpcamel.util.PIDConfiguration;
import com.saintsrobotics.hickoryhumpcamel.util.PIDReceiver;
import com.github.dozer.coroutine.Task;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;

public class ForwardAtHeadingTask extends Task {
  private double heading;
  private double distance;
  private PIDSource gyro;
  private PIDSource average;
  private PIDReceiver headingPidReceiver;
  private PIDController headingPidController;
  private PIDReceiver distancePidReceiver;
  private PIDController distancePidController;

  public ForwardAtHeadingTask(double heading, double distance, PIDConfiguration pidConfig) {
    this.heading = heading;
    this.distance = distance;
    this.gyro = pidConfig.gyro;
    this.average = pidConfig.average;
    this.headingPidReceiver = new PIDReceiver();
    this.headingPidController = new PIDController(pidConfig.forwardHeadingKP,
        pidConfig.forwardHeadingKI, pidConfig.forwardHeadingKD, gyro, headingPidReceiver);
    this.headingPidController.setAbsoluteTolerance(pidConfig.forwardHeadingTolerance);
    this.distancePidReceiver = new PIDReceiver();
    this.distancePidController = new PIDController(pidConfig.forwardDistanceKP,
        pidConfig.forwardDistanceKI, pidConfig.forwardDistanceKD, average, distancePidReceiver);
    this.distancePidController.setAbsoluteTolerance(pidConfig.forwardDistanceTolerance);
  }

  @Override
  protected void runTask() {
    this.headingPidController.enable();
    this.headingPidController.setSetpoint(this.heading + this.gyro.pidGet());
    this.distancePidController.enable();
    this.distancePidController.setSetpoint(this.distance + this.average.pidGet());
    while (!this.distancePidController.onTarget()) {
      double headingOutput = this.headingPidReceiver.getOutput();
      double distanceOutput = this.distancePidReceiver.getOutput();
      Robot.instance.motors.leftDrive.set(distanceOutput + headingOutput);
      Robot.instance.motors.rightDrive.set(distanceOutput - headingOutput);
      wait.forFrame();
    }
    Robot.instance.motors.leftDrive.stop();
    Robot.instance.motors.rightDrive.stop();
  }
}
