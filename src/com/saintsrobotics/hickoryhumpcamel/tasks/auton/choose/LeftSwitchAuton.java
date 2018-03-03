package com.saintsrobotics.hickoryhumpcamel.tasks.auton.choose;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.github.dozer.coroutine.Task;
import com.github.dozer.coroutine.helpers.RunSequentialTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.ForwardAtHeadingTask;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.TurnToHeadingTask;
import com.saintsrobotics.hickoryhumpcamel.util.ForwardConfiguration;
import com.saintsrobotics.hickoryhumpcamel.util.TurnConfiguration;



public class LeftSwitchAuton extends RunSequentialTask implements Supplier<Task> {
	static List<Task> taskList = new ArrayList<Task>(); 
	public LeftSwitchAuton() {
		super(taskChoose());
	}

	private static Task[] taskChoose() { 
		List<Task> taskList = new ArrayList<Task>(); 
		if(Robot.instance.switchStatus) {
			taskList.add(new ForwardAtHeadingTask(0, 2, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
			taskList.add(new TurnToHeadingTask(-45, new TurnConfiguration(Robot.instance.sensors.gyro)));
			taskList.add(new ForwardAtHeadingTask(0, 2.82, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
			taskList.add(new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)));
			taskList.add(new ForwardAtHeadingTask(0, 6.18, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
			taskList.add(new TurnToHeadingTask(45, new TurnConfiguration(Robot.instance.sensors.gyro)));
			taskList.add(new ForwardAtHeadingTask(0, 1.161, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
			taskList.add(new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)));
			taskList.add(new ForwardAtHeadingTask(0, 1.23, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
		}
		else { 
			taskList.add(new ForwardAtHeadingTask(0, 2, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
			taskList.add(new TurnToHeadingTask(45, new TurnConfiguration(Robot.instance.sensors.gyro)));
			taskList.add(new ForwardAtHeadingTask(0, 2.58, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
			taskList.add(new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)));
			taskList.add(new ForwardAtHeadingTask(0, 16.6, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
			taskList.add(new TurnToHeadingTask(-45, new TurnConfiguration(Robot.instance.sensors.gyro)));
			taskList.add(new ForwardAtHeadingTask(0, 2.98, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
			taskList.add(new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)));
			taskList.add(new ForwardAtHeadingTask(0, 3, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
			taskList.add(new TurnToHeadingTask(-45, new TurnConfiguration(Robot.instance.sensors.gyro)));
			taskList.add(new ForwardAtHeadingTask(0, 2.52, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
			taskList.add(new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)));
			taskList.add(new ForwardAtHeadingTask(0, 3.29, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
		}
		return taskList.toArray(new Task[taskList.size()]);
	}

	@Override
	public Task get() {
		return this; 
	}
}
