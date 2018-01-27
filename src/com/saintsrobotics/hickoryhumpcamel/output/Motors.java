package com.saintsrobotics.hickoryhumpcamel.output;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.lang.reflect.*;
import com.github.dozer.output.*;

public abstract class Motors {
  private LinkedList<MotorRamping> rampedMotors;
  private LinkedList<Motor> motors;
  public Motors() {
	  int length = this.getClass().getDeclaredFields().length;
	  this.motors = new LinkedList<>();
	  try {
		for(Field f : this.getClass().getDeclaredFields()) {
		  Object obj = f.get(this);
		  if(obj instanceof Motor) {
			this.motors.addLast((Motor)obj);
			if(obj instanceof MotorRamping) {
			  this.rampedMotors.addLast((MotorRamping) obj);
			}
		  }
		}
	  } catch (IllegalArgumentException e) {
			//PUT SOME CODE THAT KILLS THE ROBOT HERE
			e.printStackTrace();
	  } catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	  }
  }
  
  public abstract void init();
  
  public void stopAll() {
    for(Motor motor : this.motors) motor.stop();
  }

  public void update() {
	  for(MotorRamping motor : this.rampedMotors) motor.update();
  }
}
