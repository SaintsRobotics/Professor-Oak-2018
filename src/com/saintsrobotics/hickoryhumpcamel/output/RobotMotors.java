package com.saintsrobotics.hickoryhumpcamel.output;

import com.github.dozer.output.Motor;
import com.github.dozer.output.MotorGroup;

public abstract class RobotMotors extends Motors {
  public MotorGroup leftDrive;
  public MotorGroup rightDrive;
  public Motor intake;
  public Motor lifter;
  public Motor leftWing;
  public Motor rightWing;

}
