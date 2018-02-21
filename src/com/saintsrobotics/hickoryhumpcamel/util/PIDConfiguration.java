package com.saintsrobotics.hickoryhumpcamel.util;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Preferences;

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
    Preferences prefs =Preferences.getInstance();
    this.turnHeadingKP = prefs.getDouble("turnHeadingKP", 0.005);
    this.turnHeadingKI = prefs.getDouble("turnHeadingKI", 0.0003);
    this.turnHeadingKD = prefs.getDouble("turnHeadingKD", 0.08);

    this.turnHeadingTolerance = 1.75;
    this.gyro = gyro;

  }

  public PIDConfiguration(PIDSource gyro, PIDSource average) {
    Preferences prefs =Preferences.getInstance();
    this.forwardDistanceKP =  prefs.getDouble("forwardDistanceKP", 0.005);
    this.forwardDistanceKI = prefs.getDouble("forwardDistanceKI",0.0003);
    this.forwardDistanceKD = prefs.getDouble("forwardDistanceKD", 0.06);
    this.forwardHeadingKP = prefs.getDouble("forwardHeadingKP", 0.0025);
    this.forwardHeadingKI = prefs.getDouble("forwardHeadingKI", 0);
    this.forwardHeadingKD = prefs.getDouble("forwardHeadingKD", 0);

    this.forwardHeadingTolerance = 1.5;
    this.forwardDistanceTolerance = 0.05;
    this.gyro = gyro;
    this.average = average;
  }
}
