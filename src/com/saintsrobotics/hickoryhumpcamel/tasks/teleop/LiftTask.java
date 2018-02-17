package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class LiftTask extends RunEachFrameTask {
  
  private double liftDistance; //stand-in for encoder distance 


  @Override
  protected void runEachFrame() {
    liftDistance = SmartDashboard.getNumber("liftDistance", 1528);
    double movementAmount =
        Robot.instance.oi.xboxInput.rightTrigger() - Robot.instance.oi.xboxInput.leftTrigger();
    if (!Robot.instance.sensors.lifterUp.get() && movementAmount > 0) {
      movementAmount = 0;
      Robot.instance.motors.lifter.stop();
    }
    if (!Robot.instance.sensors.lifterDown.get() && movementAmount < 0) {
      movementAmount = 0;
      Robot.instance.sensors.liftEncoder.reset();
      Robot.instance.motors.lifter.stop();
    }
    if(Robot.instance.sensors.liftEncoder.getDistance() > 3.9 && movementAmount > 0.15) {
      movementAmount = 0.15;
    }
    if(Robot.instance.sensors.liftEncoder.getDistance() < 0.1 && movementAmount < -0.15) {
      movementAmount = -0.15;
    }
    Robot.instance.motors.lifter.set(movementAmount);
    
  }
}
