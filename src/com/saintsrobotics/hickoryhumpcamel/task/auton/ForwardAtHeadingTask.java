package com.saintsrobotics.hickoryhumpcamel.task.auton;

import com.github.dozer.coroutine.Task;

public class ForwardAtHeadingTask extends Task {
  private double heading;
  private double distance;

  public ForwardAtHeadingTask(double heading, double distance) {
    this.heading = heading;
    this.distance = distance;
  }

  @Override
  protected void runTask() {
    
  }
}
