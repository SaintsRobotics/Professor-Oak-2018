package com.saintsrobotics.hickoryhumpcamel.task.auton;

import com.github.dozer.coroutine.helpers.RunContinuousTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import com.saintsrobotics.hickoryhumpcamel.util.PIDReceiver;

public class TurnToHeadingTask extends RunContinuousTask {
  private double heading;
  private PIDReceiver headingPidReceiver;
  private PIDController headingPidController;
  private PIDSource gyro;

  public TurnToHeadingTask(double heading, PIDSource gyro) {
    this.heading = heading;
    this.headingPidReceiver = new PIDReceiver();
    this.headingPidController = new PIDController(0.02, 0.0006, 0.08, gyro, headingPidReceiver);
    this.headingPidController.setAbsoluteTolerance(3);
  }

  @Override
  protected boolean runContinuously() {
    wait.forFrame();
    this.headingPidController.enable();
    this.headingPidController.setSetpoint(this.heading + this.gyro.pidGet());
    double headingOutput = this.headingPidReceiver.getOutput();
    Robot.instance.motors.leftDrive.set(headingOutput);
    Robot.instance.motors.rightDrive.set(-headingOutput);
    return this.headingPidController.onTarget();
  }
}