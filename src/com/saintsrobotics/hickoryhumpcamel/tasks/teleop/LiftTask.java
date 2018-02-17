package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class LiftTask extends RunEachFrameTask {
  
  private double liftDistance; //stand-in for encoder distance 


  @Override
  protected void runEachFrame() {
    SmartDashboard.putNumber("liftDistance", Robot.instance.sensors.liftEncoder.getDistance());
    liftDistance = 10000/*SmartDashboard.getNumber("liftDistance", 1000)*/;
    double movementAmount =
        Robot.instance.oi.xboxInput.rightTrigger() - Robot.instance.oi.xboxInput.leftTrigger();
    if (!Robot.instance.sensors.lifterUp.get() && movementAmount > 0) {
      movementAmount = 0;
      Robot.instance.motors.lifter.stop();
      Robot.instance.sensors.liftEncoder.reset();

    }
    if (!Robot.instance.sensors.lifterDown.get() && movementAmount < 0) {
      movementAmount = 0;
      Robot.instance.sensors.liftEncoder.reset();
      Robot.instance.motors.lifter.stop();
    }
    double distanceRatio = liftDistance / Robot.instance.sensors.liftEncoder.getDistance() ;
    if(Robot.instance.sensors.liftEncoder.getDistance() >= liftDistance) {
      distanceRatio = 0; 
    }
    SmartDashboard.putNumber("liftEncoder", Robot.instance.sensors.liftEncoder.getDistance());
    SmartDashboard.putNumber("distanceRatio", distanceRatio);
    double overallMove = movementAmount * distanceRatio;
    SmartDashboard.putNumber("overallMove", overallMove);
    Robot.instance.motors.lifter.set(overallMove);
    
  }
}


