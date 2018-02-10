package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.github.dozer.coroutine.Task;
import com.saintsrobotics.hickoryhumpcamel.Robot;

public class WingsRightTask extends Task {

	@Override
	protected void runTask() {
		//Down
		yield(()->Robot.instance.oi.xboxInput.B());
		Robot.instance.motors.rightWing.set(-1);
		
		
		yield(()->Robot.instance.sensors.wingsRightDown.get());
		Robot.instance.motors.rightWing.stop();
		

		//Up
		yield(()->Robot.instance.oi.xboxInput.B());
		Robot.instance.motors.rightWing.set(1);
		
		
		yield(()->Robot.instance.sensors.wingsRightUp.get());
		Robot.instance.motors.rightWing.stop();
		
		
		yield(()->Robot.instance.sensors.wingsRight.get() > 90);
		Robot.instance.motors.rightWing.stop();
		
		
	} 

}