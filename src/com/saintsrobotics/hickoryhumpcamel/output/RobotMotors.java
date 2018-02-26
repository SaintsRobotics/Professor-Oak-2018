package com.saintsrobotics.hickoryhumpcamel.output;

import com.github.dozer.output.Motor;

public abstract class RobotMotors extends Motors {
  public Motor leftDrive;
  public Motor rightDrive;
  public Motor intake;
  public Motor lifter;
  public Motor leftWing;
  public Motor rightWing;
  public Motor leftBack;
  public Motor leftFront;
  public Motor rightBack;
  public Motor rightFront;
  
  protected Motor[] allMotors;
  protected MotorRamping[] rampedMotors;
  
  public RobotMotors() {
    
  }
  
  public void stopAll() {
    for (Motor motor : this.allMotors)
      motor.stop();
  }
  
  public void update() {
    for (MotorRamping motor : this.rampedMotors)
      motor.update();
  }
}