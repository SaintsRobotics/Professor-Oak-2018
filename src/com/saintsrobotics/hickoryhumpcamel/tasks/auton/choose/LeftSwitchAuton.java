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
		if(Robot.instance.flags.switchStatus) {
		    //goes to left
			taskList.add(new ForwardAtHeadingTask(0, 27.5, Robot.instance.sensors.forwardConfig));
			taskList.add(new TurnToHeadingTask(-45, Robot.instance.sensors.turnConfig));
			taskList.add(new ForwardAtHeadingTask(0, 33.94, Robot.instance.sensors.forwardConfig));
			taskList.add(new TurnToHeadingTask(45, Robot.instance.sensors.turnConfig));
			taskList.add(new ForwardAtHeadingTask(0, 74.209, Robot.instance.sensors.forwardConfig));
            taskList.add(new TurnToHeadingTask(45, Robot.instance.sensors.turnConfig));
            taskList.add(new ForwardAtHeadingTask(0, 13.942, Robot.instance.sensors.forwardConfig));
            taskList.add(new TurnToHeadingTask(45, Robot.instance.sensors.turnConfig));
            taskList.add(new ForwardAtHeadingTask(0, 14.793, Robot.instance.sensors.forwardConfig));
			
		}
		else {
		    //goes to right
			taskList.add(new ForwardAtHeadingTask(0, 27.5, Robot.instance.sensors.forwardConfig));
			taskList.add(new TurnToHeadingTask(45, Robot.instance.sensors.turnConfig));
			taskList.add(new ForwardAtHeadingTask(0, 31.023, Robot.instance.sensors.forwardConfig));
			taskList.add(new TurnToHeadingTask(45, Robot.instance.sensors.turnConfig));
			taskList.add(new ForwardAtHeadingTask(0, 199.999, Robot.instance.sensors.forwardConfig));
			taskList.add(new TurnToHeadingTask(-45, Robot.instance.sensors.turnConfig));
			taskList.add(new ForwardAtHeadingTask(0, 35.858, Robot.instance.sensors.forwardConfig));
			taskList.add(new TurnToHeadingTask(-45, Robot.instance.sensors.turnConfig));
			taskList.add(new ForwardAtHeadingTask(0, 36.715, Robot.instance.sensors.forwardConfig));
			taskList.add(new TurnToHeadingTask(-45, Robot.instance.sensors.turnConfig));
			taskList.add(new ForwardAtHeadingTask(0, 30.241, Robot.instance.sensors.forwardConfig));
			taskList.add(new TurnToHeadingTask(-45, Robot.instance.sensors.turnConfig));
			taskList.add(new ForwardAtHeadingTask(0, 39.508, Robot.instance.sensors.forwardConfig));
		}
		return taskList.toArray(new Task[taskList.size()]);
	}

	@Override
	public Task get() {
		return this; 
	}
}
