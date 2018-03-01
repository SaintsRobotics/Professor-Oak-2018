package com.saintsrobotics.hickoryhumpcamel.util;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Preferences;

public class TurnConfiguration {
  public double turnHeadingKP;
  public double turnHeadingKI;
  public double turnHeadingKD;
  
  public PIDSource gyro;
  public double turnHeadingTolerance;
  
  public TurnConfiguration(PIDSource gyro) {
    Preferences prefs = Preferences.getInstance();
    this.turnHeadingKP = prefs.getDouble("turnHeadingKP", 0.005);
    this.turnHeadingKI = prefs.getDouble("turnHeadingKI", 0.0003);
    this.turnHeadingKD = prefs.getDouble("turnHeadingKD", 0.08);
    DriverStation.reportWarning("Turn heading KP" + this.turnHeadingKP, false);

    this.turnHeadingTolerance = 1.75;
    this.gyro = gyro;
  }

}
