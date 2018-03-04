package com.saintsrobotics.hickoryhumpcamel.util;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Preferences;

public class ForwardConfiguration {
  public double forwardDistanceKP;
  public double forwardDistanceKI;
  public double forwardDistanceKD;
  public double forwardHeadingKP;
  public double forwardHeadingKI;
  public double forwardHeadingKD;
  public double forwardHeadingTolerance;
  public double forwardDistanceTolerance;
  public PIDSource gyro;
  public PIDSource average;
  
  
  public ForwardConfiguration(PIDSource gyro, PIDSource average) {
    Preferences prefs = Preferences.getInstance();
    this.forwardDistanceKP =  prefs.getDouble("forwardDistanceKP", 0.4);
    this.forwardDistanceKI = prefs.getDouble("forwardDistanceKI",0.00000007);
    this.forwardDistanceKD = prefs.getDouble("forwardDistanceKD", 0.06); //default not in SmartDashboard
    this.forwardHeadingKP = prefs.getDouble("forwardHeadingKP", 0.03);
    this.forwardHeadingKI = prefs.getDouble("forwardHeadingKI", 0); //default not in SmartDashboard
    this.forwardHeadingKD = prefs.getDouble("forwardHeadingKD", 0.07);

    this.forwardHeadingTolerance = 1.5;
    this.forwardDistanceTolerance = 1;
    this.gyro = gyro;
    this.average = average;
  }
  

}
