package com.saintsrobotics.hickoryhumpcamel.output;

import edu.wpi.first.wpilibj.SpeedController;

public class MotorRamping extends com.github.dozer.output.MotorRamping {
  public MotorRamping(SpeedController speedController, boolean inverted) {
    super(speedController, inverted);
  }

  public static final double MOTOR_RAMPING = 0.01;

  private SpeedController speedController;


  private double setpoint = 0;
  private double current = 0;

  public double get(){
    return speedController.get();
  }


  public void set(double speed) {
    setpoint = speed;
  }

  public void stop() {
    speedController.stopMotor();
    setpoint = 0;
    current = 0;
  }

  public void update() {
    if (Math.abs(setpoint - current) < MOTOR_RAMPING) {
      current = setpoint;
      return;
    } 
    if(setpoint > 0) {
      if (setpoint > current) {
        current += MOTOR_RAMPING;
      } else {
        current = setpoint;
      }
    }else if(setpoint < 0){
      if (setpoint < current) {
        current -= MOTOR_RAMPING;
      } else {
        current = setpoint;
      }
    }else {
      current = 0;
    }
    speedController.set(current);
  }

}
