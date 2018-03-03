package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import java.util.function.BooleanSupplier;
import com.github.dozer.coroutine.Task;
import com.github.dozer.coroutine.helpers.RunContinuousTask;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.github.dozer.output.Motor;
import com.saintsrobotics.hickoryhumpcamel.Robot;

public class WingsTask extends RunEachFrameTask {

  public static BooleanSupplier leftOut = () -> Robot.instance.sensors.wingsLeftOut.get() && Robot.instance.oi.xboxInput.Y();
  public static BooleanSupplier leftIn = () -> Robot.instance.sensors.wingsLeftIn.get() && Robot.instance.oi.xboxInput.A();
  public static BooleanSupplier rightOut = () -> Robot.instance.sensors.wingsRightOut.get() && Robot.instance.oi.xboxInput.DPAD_UP();
  public static BooleanSupplier rightIn = () -> Robot.instance.sensors.wingsRightIn.get() && Robot.instance.oi.xboxInput.DPAD_UP();


  private Motor wingMotor;
  private BooleanSupplier outCondition;
  private BooleanSupplier inCondition;
  
  public WingsTask(Motor wingMotor, BooleanSupplier upCondition, BooleanSupplier downCondition) {
    this.wingMotor = wingMotor;
    this.outCondition = upCondition;
    this.inCondition = downCondition;
  }

  @Override
  protected void runEachFrame() {
    double moveAmount = 0;
    if(this.outCondition.getAsBoolean()) moveAmount += 1;
    if(this.inCondition.getAsBoolean()) moveAmount -= 1;
    else this.wingMotor.stop();
    this.wingMotor.set(moveAmount);
  }

}