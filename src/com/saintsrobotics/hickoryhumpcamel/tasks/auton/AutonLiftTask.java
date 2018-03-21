package com.saintsrobotics.hickoryhumpcamel.tasks.auton;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.github.dozer.coroutine.Task;

//to stop at angle of 45, go up 10 inches
public class AutonLiftTask extends Task {
  private double distance;
  private Encoder liftEncoder;

  public AutonLiftTask(double distance, Encoder liftEncoder) {
    this.distance = distance;
    this.liftEncoder = liftEncoder;
  }
  
  @Override
  protected void runTask() {
    while(this.liftEncoder.getDistance() != this.distance) {
      Robot.instance.motors.lifter.set(0.2);
    }
    Robot.instance.motors.intake.set(-1);
    wait.forSeconds(2);
    Robot.instance.motors.intake.stop();
  }
  

  private void liftJiggle() {
    wait.forSeconds(0.3);
    Robot.instance.motors.lifter.set(0.7);
    wait.forSeconds(0.3); 
    Robot.instance.motors.lifter.set(-0.2);
    
  }
}
