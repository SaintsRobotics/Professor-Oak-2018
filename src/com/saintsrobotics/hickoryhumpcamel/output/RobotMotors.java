package com.saintsrobotics.hickoryhumpcamel.output;

import com.github.dozer.output.Motor;
import com.github.dozer.output.MotorRamping;

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
  /**
   * @deprecated
   * I put that deprecated in there just so you'd read this javadoc, make sure to set the ramped motors in the base class or this won't work properly.
   * 
   */
  public void update() {
    for (MotorRamping motor : this.rampedMotors)
      motor.update();
  }
}