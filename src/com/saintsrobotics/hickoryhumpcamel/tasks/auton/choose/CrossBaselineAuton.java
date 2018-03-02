package com.saintsrobotics.hickoryhumpcamel.tasks.auton.choose;

import com.github.dozer.coroutine.helpers.RunSequentialTask;
import com.saintsrobotics.hickoryhumpcamel.tasks.auton.ForwardAtHeadingTask;
import com.saintsrobotics.hickoryhumpcamel.util.ForwardConfiguration;

public class CrossBaselineAuton extends RunSequentialTask {
	
	public CrossBaselineAuton(ForwardConfiguration pidConfig) {
		super(new ForwardAtHeadingTask(0, 4, pidConfig));
	}

}
