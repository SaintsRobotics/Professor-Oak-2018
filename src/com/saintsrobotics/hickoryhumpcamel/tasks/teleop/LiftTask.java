package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class LiftTask extends RunEachFrameTask {

  @Override
  protected void runEachFrame() {
    Robot.instance.flags.liftEncoderValue = Robot.instance.sensors.liftEncoder.getDistance();
    double movementAmount =
        Robot.instance.oi.xboxInput.rightTrigger() - Robot.instance.oi.xboxInput.leftTrigger();
    SmartDashboard.putNumber("LIFT", Robot.instance.sensors.liftEncoder.getDistance() );
    if(Robot.instance.sensors.liftEncoder.getDistance() > 3.4 && movementAmount > 0.3) {
      movementAmount = 0.3;
    }
    if(Robot.instance.sensors.liftEncoder.getDistance() < 0.3 && movementAmount < -0.3) {
      movementAmount = -0.3;
    }
    if (!Robot.instance.sensors.lifterUp.get() && movementAmount > 0) {
      movementAmount = 0;
      Robot.instance.motors.lifter.stop();
    }
    if (!Robot.instance.sensors.lifterDown.get() && movementAmount < 0) {
      movementAmount = 0;
      Robot.instance.sensors.liftEncoder.reset();
      Robot.instance.motors.lifter.stop();
    }
    Robot.instance.motors.lifter.set(movementAmount+0.05);
    
  }
}
