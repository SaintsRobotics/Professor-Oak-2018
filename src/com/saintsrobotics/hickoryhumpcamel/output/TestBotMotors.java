package com.saintsrobotics.hickoryhumpcamel.output;

import com.github.dozer.output.Motor;
import com.github.dozer.output.MotorGroup;
import com.github.dozer.output.MotorRamping;
import com.github.dozer.output.MotorSimple;
import edu.wpi.first.wpilibj.Talon;

public class TestBotMotors extends RobotMotors {
  
  
  @Override
  public void init() {
    this.leftBack = new MotorSimple(new Talon(3), true);
    this.leftFront = new MotorSimple(new Talon(2), true);
    this.rightBack = new MotorSimple(new Talon(6), false);
    this.rightFront = new MotorSimple(new Talon(7), false);
    
    this.leftDrive = new MotorGroup(this.leftBack, this.leftFront);
    this.rightDrive = new MotorGroup(this.rightBack, this.rightFront);
    
    this.intake = new MotorSimple(new Talon(4), false);

    this.lifter = new MotorSimple(new Talon(5), false);
  }
}