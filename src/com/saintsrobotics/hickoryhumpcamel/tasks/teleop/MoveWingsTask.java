package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;

public class MoveWingsTask extends RunEachFrameTask {
	@Override
	protected void runEachFrame(){
		//right Wing
		double moveAmount =0;
		if(Robot.instance.oi.xboxInput.B()) moveAmount += 1;
		if(Robot.instance.oi.xboxInput.X()) moveAmount -= 1;

		Robot.instance.motors.rightWing.set(moveAmount);

		//left wing
		moveAmount = 0;
		if(Robot.instance.oi.xboxInput.Y()) moveAmount += 1;
		if(Robot.instance.oi.xboxInput.A()) moveAmount -= 1;

		Robot.instance.motors.leftWing.set(moveAmount);

	}

}
