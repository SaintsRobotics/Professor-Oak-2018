package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import java.util.function.BooleanSupplier;

import com.github.dozer.coroutine.Task;
import com.github.dozer.output.Motor;
import com.saintsrobotics.hickoryhumpcamel.Robot;

public class WingsTask extends Task {
	
	public static BooleanSupplier leftDown = ()-> Robot.instance.sensors.wingsLeftDown.get();
	public static BooleanSupplier rightDown = ()-> Robot.instance.sensors.wingsRightDown.get();
	
	public static BooleanSupplier leftUp = ()-> Robot.instance.sensors.wingsLeft.get() > 90 || Robot.instance.sensors.wingsLeftUp.get();
	public static BooleanSupplier rightUp = ()-> Robot.instance.sensors.wingsRight.get() > 90 || Robot.instance.sensors.wingsRightUp.get();
	
	private Motor wingMotor;
	private BooleanSupplier downCondition;
	private BooleanSupplier upCondition;
	
	public WingsTask(Motor wingMotor,
					BooleanSupplier downCondition,
					BooleanSupplier upCondition) {
		this.wingMotor = wingMotor;
		this.downCondition = downCondition;
		this.upCondition = upCondition;
	}
	
	@Override
	protected void runTask() {
		//Down
		wait.until(()->Robot.instance.oi.xboxInput.B());
		this.wingMotor.set(-1);
		
		wait.until(this.downCondition);
		this.wingMotor.stop();
		

		//Up
		wait.until(()->Robot.instance.oi.xboxInput.B());
		this.wingMotor.set(1);
				
		
		yield(this.upCondition);
		this.wingMotor.stop();
		
	} 
	
}
