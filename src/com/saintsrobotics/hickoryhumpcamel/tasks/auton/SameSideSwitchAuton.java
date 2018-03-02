package com.saintsrobotics.hickoryhumpcamel.tasks.auton;

import com.github.dozer.coroutine.helpers.RunSequentialTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.saintsrobotics.hickoryhumpcamel.util.ForwardConfiguration;
import com.saintsrobotics.hickoryhumpcamel.util.TurnConfiguration;

public class SameSideSwitchAuton extends RunSequentialTask {
	//TODO: The values are not actually the same, woops 
	public SameSideSwitchAuton(int inverse) {
	super(
		new ForwardAtHeadingTask(0, 2, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)),
		new TurnToHeadingTask(-45 * inverse, new TurnConfiguration(Robot.instance.sensors.gyro)),
		new ForwardAtHeadingTask(0, 2.82, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)),
		new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)),
		new ForwardAtHeadingTask(0, 6.18, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)),
		new TurnToHeadingTask(45 * inverse, new TurnConfiguration(Robot.instance.sensors.gyro)),
		new ForwardAtHeadingTask(0, 1.161, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)),
		new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)),
		new ForwardAtHeadingTask(0 * inverse, 1.23, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)));
	}
	public SameSideSwitchAuton() {
		this(1);
	}
}
