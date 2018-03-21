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

	public class CenterSwitchAuton extends RunSequentialTask {
		
	    public CenterSwitchAuton() {
			super(taskChoose());
		}

		private static Task[] taskChoose() { 
		  List<Task> taskList = new ArrayList<Task>(); 
			if(Robot.instance.flags.switchStatus) {
			    //goes to left side of switch
				taskList.add(new TurnToHeadingTask(-45, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(0, 55.589, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(45, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(0, 67.607, Robot.instance.sensors.forwardConfig));
			}
			else { 
			    //goes to right side of switch
				taskList.add(new ForwardAtHeadingTask(0, 3.5, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(45, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(0, 57.28, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(45, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(0, 37.366, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(-45, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(0, 35.875, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(-45, Robot.instance.sensors.turnConfig));
                taskList.add(new ForwardAtHeadingTask(0, 37.545, Robot.instance.sensors.forwardConfig));
			}
			return taskList.toArray(new Task[taskList.size()]);
		}
	}

