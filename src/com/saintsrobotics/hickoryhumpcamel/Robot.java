package com.saintsrobotics.hickoryhumpcamel;

import com.github.dozer.TaskRobot;
import com.github.dozer.coroutine.Task;
import com.github.dozer.coroutine.helpers.RunSequentialTask;
import com.saintsrobotics.hickoryhumpcamel.input.OI;
import com.saintsrobotics.hickoryhumpcamel.output.*;
import com.saintsrobotics.hickoryhumpcamel.task.auton.SimpleMoveBackward;
import com.saintsrobotics.hickoryhumpcamel.task.auton.SimpleMoveForward;
import com.saintsrobotics.hickoryhumpcamel.task.auton.TurnToHeadingTask;
import com.saintsrobotics.hickoryhumpcamel.task.teleop.ArcadeDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TaskRobot {
  
  public TestMotors motors;
  public OI oi;
  public Flags flags;
  
  public static Robot instance;
  
  @Override
  public void robotInit() {
    this.oi = new OI();
    this.motors = new SetTestMotors();
    this.motors.init();
    this.flags = new Flags();
    Robot.instance = this;
    this.autonomousTasks =  new Task[]{new RunSequentialTask(new TurnToHeadingTask(90), new TurnToHeadingTask(30))};
    this.teleopTasks = new Task[]{new ArcadeDrive()};
  }
}