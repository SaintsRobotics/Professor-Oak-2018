package com.saintsrobotics.hickoryhumpcamel;

import com.github.dozer.TaskRobot;
import com.github.dozer.coroutine.Task;
import com.saintsrobotics.hickoryhumpcamel.input.OI;
import com.saintsrobotics.hickoryhumpcamel.input.Sensors;
import com.saintsrobotics.hickoryhumpcamel.output.Servos;
import com.saintsrobotics.hickoryhumpcamel.output.SetTestMotors;
import com.saintsrobotics.hickoryhumpcamel.output.TestMotors;
import com.saintsrobotics.hickoryhumpcamel.task.teleop.ArcadeDrive;

public class Robot extends TaskRobot {
  public static Robot instance;
	
  protected Task[] autonomousTasks = {};
  protected Task[] teleopTasks = {};
  protected Task[] testTasks = {};
  protected Task[] disabledTasks = {};
  
  public TestMotors motors;
  public Servos servos;
  public Sensors sensors;
  
  public OI oi;
  public Flags flags;  
  @Override
  public void robotInit() {
    this.oi = new OI();
    this.motors = new SetTestMotors();
    this.motors.init();
    this.flags = new Flags();
    Robot.instance = this;
    this.autonomousTasks =  new Task[]{new TheShuffle()};
    this.teleopTasks = new Task[]{new ArcadeDrive()};
  }
}