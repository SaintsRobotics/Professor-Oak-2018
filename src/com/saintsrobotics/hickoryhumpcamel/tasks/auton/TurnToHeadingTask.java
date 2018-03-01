package com.saintsrobotics.hickoryhumpcamel.tasks.auton;

import com.github.dozer.coroutine.Task;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.saintsrobotics.hickoryhumpcamel.util.PIDReceiver;
import com.saintsrobotics.hickoryhumpcamel.util.TurnConfiguration;

public class TurnToHeadingTask extends Task {
  private double heading;
  private PIDReceiver headingPidReceiver;
  private PIDController headingPidController;
  private PIDSource gyro;

  public TurnToHeadingTask(double heading, TurnConfiguration pidConfig) {
    this.heading = heading;
    this.gyro = pidConfig.gyro;
    this.headingPidReceiver = new PIDReceiver();
    this.headingPidController = new PIDController(pidConfig.turnHeadingKP, pidConfig.turnHeadingKI,
        pidConfig.turnHeadingKD, gyro, headingPidReceiver);
    this.headingPidController.setAbsoluteTolerance(pidConfig.turnHeadingTolerance);
    this.headingPidController.setOutputRange(-0.6, 0.6);
  }

  @Override
  protected void runTask() {
    DriverStation.reportError("Running Task!", false);
    this.headingPidController.setSetpoint(this.heading);
    DriverStation.reportError("Start : " + this.gyro.pidGet(), false);
    this.headingPidController.enable();
    int frameCount = 0;
    while (frameCount < 50) {
      double headingOutput = this.headingPidReceiver.getOutput();
      SmartDashboard.putNumber("Gyro Angle", this.gyro.pidGet());
      SmartDashboard.putNumber("Gyro Pid Driving", headingOutput);
      SmartDashboard.putNumber("PID Error", this.headingPidController.getError());
      Robot.instance.motors.leftDrive.set(headingOutput);
      Robot.instance.motors.rightDrive.set(-headingOutput);
      if(this.headingPidController.onTarget()) {
        frameCount++;
      }else {
        frameCount = 0;
      }
      wait.forFrame();
    }
    DriverStation.reportError("Stopped! " + this.gyro.pidGet(),false);
    Robot.instance.motors.leftDrive.stop();
    Robot.instance.motors.rightDrive.stop();
  }
}
