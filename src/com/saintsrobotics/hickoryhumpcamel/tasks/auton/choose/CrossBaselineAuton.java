package com.saintsrobotics.hickoryhumpcamel.tasks.auton.choose;

import com.github.dozer.coroutine.helpers.RunSequentialTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.ForwardAtHeadingTask;
import com.saintsrobotics.hickoryhumpcamel.util.ForwardConfiguration;

public class CrossBaselineAuton extends RunSequentialTask {
	
	public CrossBaselineAuton() {
		super(new ForwardAtHeadingTask(0, 4, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
	}

}
