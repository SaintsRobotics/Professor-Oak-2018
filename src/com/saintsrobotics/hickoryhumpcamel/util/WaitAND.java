package com.saintsrobotics.hickoryhumpcamel.util;

import java.util.function.BooleanSupplier;

public class WaitAND implements BooleanSupplier {
  private BooleanSupplier[] targets;

  public WaitAND(BooleanSupplier... andTargets) {
    this.targets = andTargets;
  }

  @Override
  public boolean getAsBoolean() {
    for (BooleanSupplier target : this.targets) {
      if (!target.getAsBoolean())
        return false;
    }
    return true;
  }
}
