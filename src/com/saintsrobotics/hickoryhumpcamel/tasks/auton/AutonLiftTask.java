package com.saintsrobotics.hickoryhumpcamel.tasks.auton;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.saintsrobotics.hickoryhumpcamel.util.PIDReceiver;
import com.saintsrobotics.hickoryhumpcamel.util.DistanceEncoder;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.github.dozer.coroutine.Task;


public class AutonLiftTask extends Task {
  private double distance;
  private Encoder liftEncoder;

  public AutonLiftTask(double distance, Encoder liftEncoder) {
    this.distance = distance;
    this.liftEncoder = liftEncoder;
    
    Robot.instance.motors.lifter.set(0.2);
  }
  
  @Override
  protected void runTask() {
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
