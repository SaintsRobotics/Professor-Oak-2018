package com.saintsrobotics.hickoryhumpcamel.tasks.auton;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.saintsrobotics.hickoryhumpcamel.util.ForwardConfiguration;
import com.saintsrobotics.hickoryhumpcamel.util.PIDReceiver;
import com.github.dozer.coroutine.Task;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ForwardAtHeadingTask extends Task {
  private double heading;
  private double distance;
  private PIDSource gyro;
  private PIDSource average;
  private PIDReceiver headingPidReceiver;
  private PIDController headingPidController;
  private PIDReceiver distancePidReceiver;
  private PIDController distancePidController;

  public ForwardAtHeadingTask(double heading, double distance, ForwardConfiguration pidConfig) {
    this.heading = heading;
    this.distance = distance;
    this.gyro = pidConfig.gyro;
    this.average = pidConfig.average;
    this.headingPidReceiver = new PIDReceiver();
    this.headingPidController = new PIDController(pidConfig.forwardHeadingKP,
        pidConfig.forwardHeadingKI, pidConfig.forwardHeadingKD, gyro, headingPidReceiver);
    //this.headingPidController.setAbsoluteTolerance(pidConfig.forwardHeadingTolerance);
    this.headingPidController.setOutputRange(-0.5, 0.5);
    this.distancePidReceiver = new PIDReceiver();
    this.distancePidController = new PIDController(pidConfig.forwardDistanceKP,
        pidConfig.forwardDistanceKI, pidConfig.forwardDistanceKD, average, distancePidReceiver);
    this.distancePidController.setAbsoluteTolerance(pidConfig.forwardDistanceTolerance);
    this.distancePidController.setOutputRange(-0.3, 0.3);
  }

  @Override
  protected void runTask() {
    this.headingPidController.enable();
    this.headingPidController.setSetpoint(this.heading);
    this.distancePidController.enable();
    this.distancePidController.setSetpoint(this.distance + this.average.pidGet());
    DriverStation.reportWarning("Going forward, encoders at " + this.average.pidGet(), false);
    int frameCount = 0;
    while (frameCount < 20) {
      double headingOutput = this.headingPidReceiver.getOutput();
      double distanceOutput = this.distancePidReceiver.getOutput();
      SmartDashboard.putNumber("Gyro Angle", this.gyro.pidGet());
      SmartDashboard.putNumber("Gyro Pid Driving", headingOutput);
      SmartDashboard.putNumber("PID Error", this.headingPidController.getError());
      SmartDashboard.putNumber("Distance Pid Driving", distanceOutput);
      SmartDashboard.putNumber("Distance PID Error", this.distancePidController.getError());
      Robot.instance.motors.leftDrive.set(distanceOutput + headingOutput);
      Robot.instance.motors.rightDrive.set(distanceOutput - headingOutput);
      if(this.distancePidController.onTarget()) {
        frameCount++;
      }else {
        frameCount = 0;
      }
      wait.forFrame();
    }
    DriverStation.reportError("Stopped! " + this.average.pidGet(), false);
    Robot.instance.motors.leftDrive.stop();
    Robot.instance.motors.rightDrive.stop();
  }
}
