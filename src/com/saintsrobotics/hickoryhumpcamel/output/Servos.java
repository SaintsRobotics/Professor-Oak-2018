package com.saintsrobotics.hickoryhumpcamel.output;

import java.util.HashMap;
import java.util.Map;
import com.github.dozer.output.Servo;

public abstract class Servos {

  private Map<String, Servo> servos = new HashMap<>();

  public Servo get(String name){
    return this.servos.get(name);
  }
}
