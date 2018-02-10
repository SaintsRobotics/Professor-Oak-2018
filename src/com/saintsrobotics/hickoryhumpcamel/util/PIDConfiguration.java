package com.saintsrobotics.hickoryhumpcamel.util;

import edu.wpi.first.wpilibj.PIDSource;

public class PIDConfiguration {
  public double turnHeadingKP;
  public double turnHeadingKI;
  public double turnHeadingKD;
  
  public double forwardDistanceKP;
  public double forwardDistanceKI;
  public double forwardDistanceKD;
  public double forwardHeadingKP;
  public double forwardHeadingKI;
  public double forwardHeadingKD;
  
  public double turnHeadingTolerance;
  public double forwardHeadingTolerance;
  public double forwardDistanceTolerance;
  
  public PIDSource gyro;
  public PIDSource average;
  
  public PIDConfiguration(PIDSource gyro) {
    this.turnHeadingKP = 0.005;
    this.turnHeadingKI = 0.0003;
    this.turnHeadingKD = 0.08;
    
    this.turnHeadingTolerance = 1;
    this.gyro = gyro;
    
  }
  
  public PIDConfiguration(PIDSource gyro, PIDSource average) {
    this.forwardDistanceKP = 0.005;
    this.forwardDistanceKI = 0.0003;
    this.forwardDistanceKD = 0.06;
    this.forwardHeadingKP = 0.0025;
    this.forwardHeadingKI = 0;
    this.forwardHeadingKD = 0;
    
    this.forwardHeadingTolerance = 1;
    this.forwardDistanceTolerance = 23.2;
    this.gyro = gyro;
    this.average = average;
  }
}
