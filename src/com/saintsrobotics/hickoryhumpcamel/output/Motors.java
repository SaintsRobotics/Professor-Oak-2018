package com.saintsrobotics.hickoryhumpcamel.output;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.*;
import com.github.dozer.output.*;

public abstract class Motors {
  private List<MotorRamping> rampedMotors;
  private List<Motor> motors;
  
  public Motors() {
	  Field[] declaredFields = getClass().getDeclaredFields();
	  this.motors = new ArrayList<>(declaredFields.length);
	  try {
		for(Field f : declaredFields) {
		  Object obj = f.get(this);
		  if(obj instanceof Motor) {
			this.motors.add((Motor)obj);
			if(obj instanceof MotorRamping) {
			  this.rampedMotors.add((MotorRamping) obj);
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
