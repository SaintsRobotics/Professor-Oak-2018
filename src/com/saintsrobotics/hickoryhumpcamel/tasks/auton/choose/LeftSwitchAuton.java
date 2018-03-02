package com.saintsrobotics.hickoryhumpcamel.tasks.auton.choose;

import java.util.ArrayList;
import java.util.List;

import com.github.dozer.coroutine.Task;
import com.github.dozer.coroutine.helpers.RunSequentialTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.AutonLiftTask;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.ForwardAtHeadingTask;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.SameSideSwitchAuton;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.TurnToHeadingTask;
import com.saintsrobotics.hickoryhumpcamel.util.ForwardConfiguration;
import com.saintsrobotics.hickoryhumpcamel.util.LiftConfiguration;
import com.saintsrobotics.hickoryhumpcamel.util.TurnConfiguration;

public class LeftSwitchAuton extends RunSequentialTask {
	public LeftSwitchAuton(ForwardConfiguration pidConfig) {
		super(Robot.instance.switchStatus ? new SameSideSwitchAuton(): new OppositeSideSwitchAuton());
	}
}

