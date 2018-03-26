package com.saintsrobotics.hickoryhumpcamel.tasks.auton.choose;


	import java.util.ArrayList;
import java.util.List;
import com.github.dozer.coroutine.Task;
import com.github.dozer.coroutine.helpers.RunSequentialTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.ForwardAtHeadingTask;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.TurnToHeadingTask;


	public class RightSwitchAuton extends RunSequentialTask {
		public RightSwitchAuton() {
			super(taskChoose());
		}

		private static Task[] taskChoose() { 
			List<Task> taskList = new ArrayList<Task>(); 
			if(Robot.instance.flags.switchStatus) {
			    //goes to left side of switch
			    taskList.add(new ForwardAtHeadingTask(0, 3.5, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(-45, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(-45, 63.553, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(-90, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(-90, 164.69, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(-45, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(-45, 46.067, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(0, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(0, 34.056, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(45, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(45, 23.395, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(90, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(90, 22.916, Robot.instance.sensors.forwardConfig));
			}
			else {
			    //goes to right side of switch
				taskList.add(new ForwardAtHeadingTask(0, 35.181, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(45, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(45, 43.916, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(0, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(0, 55.27, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(-45, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(-45, 10, Robot.instance.sensors.forwardConfig));
				taskList.add(new TurnToHeadingTask(-90, Robot.instance.sensors.turnConfig));
				taskList.add(new ForwardAtHeadingTask(-90, 10, Robot.instance.sensors.forwardConfig));
			}
			return taskList.toArray(new Task[taskList.size()]);
		}
	}

