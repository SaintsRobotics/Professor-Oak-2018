package com.saintsrobotics.hickoryhumpcamel.output;

import com.github.dozer.output.Motor;
import com.github.dozer.output.MotorGroup;
import com.github.dozer.output.MotorSimple;
import edu.wpi.first.wpilibj.Talon;

public class TestBotMotors extends RobotMotors {
  
  @Override
  public void init() {
    this.leftBack = new MotorRamping(new Talon(3), false);
    this.leftFront = new MotorRamping(new Talon(2), false);
    this.rightBack = new MotorRamping(new Talon(6), true);
    this.rightFront = new MotorRamping(new Talon(7), true);
    
    this.leftDrive = new MotorGroup(this.leftBack, this.leftFront);
    this.rightDrive = new MotorGroup(this.rightBack, this.rightFront);
    this.intake = new MotorSimple(new Talon(4), false);
    this.lifter = new MotorSimple(new Talon(5), false);
    
    this.rightWing = new MotorSimple(new Talon(8), false);
    this.leftWing = new MotorSimple(new Talon(1), false);
    this.allMotors = new Motor[] {
        this.leftDrive,
        this.rightDrive,
        this.intake,
        this.lifter,
        this.leftWing,
        this.rightWing,
        this.leftBack,
        this.leftFront,
        this.rightBack,
        this.rightFront
   };
   this.rampedMotors = new MotorRamping[] {
       (MotorRamping) this.leftBack,
       (MotorRamping) this.rightBack,
       (MotorRamping) this.leftFront,
       (MotorRamping) this.rightFront
   };
  }
}
