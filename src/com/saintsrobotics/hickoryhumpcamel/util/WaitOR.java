package com.saintsrobotics.hickoryhumpcamel.util;

import java.util.function.BooleanSupplier;

public class WaitOR implements BooleanSupplier {
  private BooleanSupplier[] targets;

  public WaitOR(BooleanSupplier... orTargets) {
    this.targets = orTargets;
  }

  @Override
  public boolean getAsBoolean() {
    for (BooleanSupplier target : this.targets) {
      if (target.getAsBoolean())
        return true;
    }
    return false;
  }
}
