package com.saintsrobotics.hickoryhumpcamel.tasks.auton;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.saintsrobotics.hickoryhumpcamel.util.PIDReceiver;
import com.saintsrobotics.hickoryhumpcamel.util.LiftConfiguration;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.github.dozer.coroutine.Task;


public class AutonLiftTask extends Task {
  private PIDReceiver distancePidReceiver;
  private PIDController distancePidController;
  private double distance;
  private PIDSource liftDistance;

  public AutonLiftTask(double distance, LiftConfiguration pidConfig) {
    this.distance = distance;
    this.liftDistance = pidConfig.liftDistance;
    this.distancePidReceiver = new PIDReceiver();
    this.distancePidController = new PIDController(pidConfig.liftDistanceKP,
        pidConfig.liftDistanceKI, pidConfig.liftDistanceKD, liftDistance, distancePidReceiver);
    this.distancePidController.setAbsoluteTolerance(pidConfig.liftDistanceTolerance);
    this.distancePidController.setOutputRange(-0.3, 0.3);
  }
  
  @Override
  protected void runTask() {
    this.distancePidController.enable();
    this.distancePidController.setSetpoint(this.distance + this.liftDistance.pidGet());
    DriverStation.reportWarning("Going up, encoders at " + this.liftDistance.pidGet(), false);
    int frameCount = 0;
    while (frameCount < 20) {
      double distanceOutput = this.distancePidReceiver.getOutput();
      SmartDashboard.putNumber("Distance Pid Driving", distanceOutput);
      SmartDashboard.putNumber("Distance PID Error", this.distancePidController.getError());
      Robot.instance.motors.lifter.set(distanceOutput);
      if(this.distancePidController.onTarget()) {
        frameCount++;
      }else {
        frameCount = 0;
      }
      wait.forFrame();
    }
    DriverStation.reportError("Stopped! " + this.liftDistance.pidGet(), false);
    Robot.instance.motors.lifter.stop();
  }
}
