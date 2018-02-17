package com.saintsrobotics.hickoryhumpcamel.output;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.github.dozer.output.MotorGroup;
import com.github.dozer.output.MotorSimple;

public class TestBotMotors extends RobotMotors {
  
  @Override
  public void init() {
    this.leftBack = new MotorSimple(new WPI_TalonSRX(3), true);
    this.leftFront = new MotorSimple(new WPI_TalonSRX(2), true);
    this.rightBack = new MotorSimple(new WPI_TalonSRX(6), false);
    this.rightFront = new MotorSimple(new WPI_TalonSRX(7), false);
    
    this.leftDrive = new MotorGroup(this.leftBack, this.leftFront);
    this.rightDrive = new MotorGroup(this.rightBack, this.rightFront);
    this.intake = new MotorSimple(new WPI_TalonSRX(4), false);
    this.lifter = new MotorSimple(new WPI_TalonSRX(5), false);
    
    
  }
}
