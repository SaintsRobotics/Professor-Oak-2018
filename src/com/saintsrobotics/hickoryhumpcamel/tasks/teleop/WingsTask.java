package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import java.util.function.BooleanSupplier;
import com.github.dozer.coroutine.Task;
import com.github.dozer.coroutine.helpers.RunContinuousTask;
import com.github.dozer.output.Motor;
import com.saintsrobotics.hickoryhumpcamel.Robot;

public class WingsTask extends RunContinuousTask {

  public static BooleanSupplier left = () -> !Robot.instance.sensors.wingsLeftOut.get() && Robot.instance.oi.xboxInput.B();
  public static BooleanSupplier right = () -> !Robot.instance.sensors.wingsRightOut.get() && Robot.instance.oi.xboxInput.A();


  private Motor wingMotor;
  private BooleanSupplier condition;
  
  public WingsTask(Motor wingMotor, BooleanSupplier condition) {
    this.wingMotor = wingMotor;
    this.condition = condition;
  }

  @Override
  protected void runForever() {
    wait.until(this.condition);
    this.wingMotor.set(1);
    yield(()->!this.condition.getAsBoolean());
    this.wingMotor.set(0);
    this.wingMotor.stop();
  }
}