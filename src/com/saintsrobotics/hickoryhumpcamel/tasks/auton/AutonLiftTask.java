package com.saintsrobotics.hickoryhumpcamel.tasks.auton;

import com.github.dozer.coroutine.Task;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.Encoder;

//to stop at angle of 45, go up 10 inches
public class AutonLiftTask extends Task {
  private double distance;

  public AutonLiftTask(double distance) {
    this.distance = distance;
  }
  
  @Override
  protected void runTask() {
    Robot.instance.motors.lifter.set(0.5);
    wait.untilWithTimeout(() -> Robot.instance.sensors.liftEncoder.getDistance() >= this.distance, 1.5);
    Robot.instance.motors.lifter.stop();
// NON EVENT CODE    
//    while(this.liftEncoder.getDistance() != this.distance) {
//      Robot.instance.motors.lifter.set(0.2);
//    }
//    Robot.instance.motors.intake.set(-1);
//    wait.forSeconds(2);
//    Robot.instance.motors.intake.stop();
  }
  

  private void liftJiggle() {
    wait.forSeconds(0.3);
    Robot.instance.motors.lifter.set(0.7);
    wait.forSeconds(0.3); 
    Robot.instance.motors.lifter.set(-0.2);
    
  }
}
