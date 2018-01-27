package com.saintsrobotics.hickoryhumpcamel.output;

import java.util.HashMap;
import java.util.Map;
import com.github.dozer.output.*;

public abstract class Motors {
  private Map<String, MotorRamping> motorList = new HashMap<>();

  public void stopAll() {
    motorList.values().forEach(MotorRamping::stop);
  }

  public void update() {
    motorList.values().forEach(MotorRamping::update);
  }
  public Motor get(String motorName) {
	  return this.motorList.get(motorName);
  }
}
