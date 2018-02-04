package com.saintsrobotics.hickoryhumpcamel.output;

import com.github.dozer.output.MotorSimple;
import edu.wpi.first.wpilibj.Talon;

public class SetTestMotors extends TestMotors {  
  @Override
  public void init() {
    this.leftDrive = new MotorSimple(new Talon(0), false);
    this.rightDrive = new MotorSimple(new Talon(1), false);
    this.intake = new MotorSimple(new Talon(9), false);
  }
}