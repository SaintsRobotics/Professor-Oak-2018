package com.saintsrobotics.hickoryhumpcamel;

import com.github.dozer.TaskRobot;
import com.github.dozer.coroutine.Task;
import com.saintsrobotics.hickoryhumpcamel.input.OI;
import com.saintsrobotics.hickoryhumpcamel.input.Sensors;
import com.saintsrobotics.hickoryhumpcamel.output.Servos;
import com.saintsrobotics.hickoryhumpcamel.output.TestMotors;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TaskRobot {
  public static Robot instance;
	
  protected Task[] autonomousTasks = {};
  protected Task[] teleopTasks = {};
  protected Task[] testTasks = {};
  protected Task[] disabledTasks = {};
  
  public OI oi;
  public Flags flags;
  public TestMotors motors;
  public Servos servos;
  public Sensors sensors;
}