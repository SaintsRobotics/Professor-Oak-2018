package com.saintsrobotics.hickoryhumpcamel.util;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class AveragePIDSources implements PIDSource {
  private PIDSource source1;
  private PIDSource source2;
  private int source1Multiplier;
  private int source2Multiplier;

  private PIDSourceType sourceType;

  public AveragePIDSources(PIDSource source1, PIDSource source2, boolean isSource1Inverted,
      boolean isSource2Inverted) {
    this.source1 = source1;
    this.source2 = source2;
    this.source1Multiplier = isSource1Inverted ? -1 : 1;
    this.source2Multiplier = isSource2Inverted ? -1 : 1;
    this.sourceType = this.source1.getPIDSourceType();

  }

  public void setPIDSourceType(PIDSourceType pidSource) {
    this.sourceType = pidSource;
  }

  public PIDSourceType getPIDSourceType() {
    return this.sourceType;
  }

  public double pidGet() {
    double source1Value = source1.pidGet() * source1Multiplier;
    double source2Value = source2.pidGet() * source2Multiplier;
    return (source1Value + source2Value) / 2;
  }
}
