package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.github.dozer.coroutine.Task;
import com.saintsrobotics.hickoryhumpcamel.Robot;

public class WingsLeftTask extends Task {

	@Override
	protected void runTask() {
		//Down
		yield(()->Robot.instance.oi.xboxInput.B());
		Robot.instance.motors.leftWing.set(-1);
		
		
		yield(()->Robot.instance.sensors.wingsLeftDown.get());
		Robot.instance.motors.leftWing.stop();
		

		//Up
		yield(()->Robot.instance.oi.xboxInput.B());
		Robot.instance.motors.leftWing.set(1);
		
		
		yield(()->Robot.instance.sensors.wingsLeftUp.get());
		Robot.instance.motors.leftWing.stop();
		
		
		yield(()->Robot.instance.sensors.wingsLeft.get() > 90);
		Robot.instance.motors.leftWing.stop();
		
		
	} 

}
