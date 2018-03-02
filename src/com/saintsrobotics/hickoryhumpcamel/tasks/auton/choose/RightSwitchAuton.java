package com.saintsrobotics.hickoryhumpcamel.tasks.auton.choose;

import com.github.dozer.coroutine.helpers.RunSequentialTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.ForwardAtHeadingTask;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.SameSideSwitchAuton;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.TurnToHeadingTask;
import com.saintsrobotics.hickoryhumpcamel.util.ForwardConfiguration;
import com.saintsrobotics.hickoryhumpcamel.util.TurnConfiguration;

public class RightSwitchAuton {
	public RightSwitchAuton() {
		super(Robot.instance.switchStatus ? new OppositeSideSwitchAuton(-1): new SameSideSwitchAuton(-1));

	}

	
	
	new RunSequentialTask(
			new TurnToHeadingTask(-45, new TurnConfiguration(Robot.instance.sensors.gyro)),
			new ForwardAtHeadingTask(0, 5.2, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)),
			new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)),
			new ForwardAtHeadingTask(0, 13.7, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)),
			new TurnToHeadingTask(45, new TurnConfiguration(Robot.instance.sensors.gyro)),
			new ForwardAtHeadingTask(0, 3.8, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)),
			new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)),
			new ForwardAtHeadingTask(0, 2.8, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)),
			new TurnToHeadingTask(45, new TurnConfiguration(Robot.instance.sensors.gyro)),
			new ForwardAtHeadingTask(0, 2.15, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)),
			new TurnToHeadingTask(0, new TurnConfiguration(Robot.instance.sensors.gyro)),
			new ForwardAtHeadingTask(0, 1.9, new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average)),
}
}
