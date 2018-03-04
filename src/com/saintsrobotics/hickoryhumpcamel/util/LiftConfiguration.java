package com.saintsrobotics.hickoryhumpcamel.util;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Preferences;

public class LiftConfiguration {
  
  public double liftDistanceKP;
  public double liftDistanceKI;
  public double liftDistanceKD;
  public double liftDistanceTolerance;
  public PIDSource liftDistance;

  public LiftConfiguration(PIDSource liftDistance) {
    Preferences prefs = Preferences.getInstance();
    this.liftDistanceKP =  prefs.getDouble("forwardDistanceKP", 0.4);
    this.liftDistanceKI = prefs.getDouble("forwardDistanceKI",0.00000007);
    this.liftDistanceKD = prefs.getDouble("forwardDistanceKD", 0.06); //not in SmartDashBoard
    
    this.liftDistanceTolerance = 1;
    this.liftDistance = liftDistance;
  }

}
