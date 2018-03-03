package com.saintsrobotics.hickoryhumpcamel.tasks.auton.choose;


	import java.util.ArrayList;
import java.util.List;

import com.github.dozer.coroutine.Task;
import com.github.dozer.coroutine.helpers.RunSequentialTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.ForwardAtHeadingTask;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.TurnToHeadingTask;
import com.saintsrobotics.hickoryhumpcamel.util.ForwardConfiguration;
import com.saintsrobotics.hickoryhumpcamel.util.TurnConfiguration;

	public class RightSwitchAuton extends RunSequentialTask {
		public RightSwitchAuton() {
			super(taskChoose());
		}

		private static Task[] taskChoose() { 
			List<Task> taskList = new ArrayList<Task>(); 
			if(Robot.instance.switchStatus) {
				taskList.add(new TurnToHeadingTask(-45, new TurnConfiguration(Robot.instance.sensors.gyro)));
				taskList.add(new ForwardAtHeadingTask(0, 5.2, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
				taskList.add(new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)));
				taskList.add(new ForwardAtHeadingTask(0, 13.7, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
				taskList.add(new TurnToHeadingTask(45, new TurnConfiguration(Robot.instance.sensors.gyro)));
				taskList.add(new ForwardAtHeadingTask(0,  3.8, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
				taskList.add(new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)));
				taskList.add(new ForwardAtHeadingTask(0, 2.8, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
				taskList.add(new TurnToHeadingTask(45, new TurnConfiguration(Robot.instance.sensors.gyro)));
				taskList.add(new ForwardAtHeadingTask(0, 2.15, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
				taskList.add(new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)));
				taskList.add(new ForwardAtHeadingTask(0, 1.9, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));

			}
			else { 
				taskList.add(new ForwardAtHeadingTask(0, 2.6, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
				taskList.add(new TurnToHeadingTask(45, new TurnConfiguration(Robot.instance.sensors.gyro)));
				taskList.add(new ForwardAtHeadingTask(0, 3.6, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
				taskList.add(new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)));
				taskList.add(new ForwardAtHeadingTask(0, 4, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
				taskList.add(new TurnToHeadingTask(-45, new TurnConfiguration(Robot.instance.sensors.gyro)));
				taskList.add(new ForwardAtHeadingTask(0, 2.2, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
				taskList.add(new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)));
				taskList.add(new ForwardAtHeadingTask(0, 1.6, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
			}
			return taskList.toArray(new Task[taskList.size()]);
		}
	}

