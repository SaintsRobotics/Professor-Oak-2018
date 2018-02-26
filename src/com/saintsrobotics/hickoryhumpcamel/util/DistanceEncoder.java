package com.saintsrobotics.hickoryhumpcamel.util;

import edu.wpi.first.wpilibj.Encoder;

public class DistanceEncoder extends Encoder {
  private double ticksPerUnit;
  
  public DistanceEncoder(int port1, int port2, double ticksPerUnit, boolean reversed) {
    super(port1, port2, reversed);
    this.ticksPerUnit = ticksPerUnit;
  }
  
  @Override
  public double getDistance() {
    return super.get() / this.ticksPerUnit;
  }
  
  @Override
  public double pidGet() {
    return super.get() / this.ticksPerUnit;
  }
}