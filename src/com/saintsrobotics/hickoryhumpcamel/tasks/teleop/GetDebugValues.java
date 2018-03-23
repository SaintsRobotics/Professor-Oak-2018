package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.saintsrobotics.hickoryhumpcamel.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GetDebugValues extends RunEachFrameTask {

	@Override
	protected void runEachFrame() {
		//Other Debug Code
		SmartDashboard.putNumber("Encoder Distance", Robot.instance.sensors.leftEncoder.get());
		SmartDashboard.putNumber("Encoder Avg Distance", Robot.instance.sensors.average.pidGet());

		for (int i : new int[] { 0, 1, 2, 3, 12, 13, 14, 15 }) {
			SmartDashboard.putNumber("Current: " + i, Robot.instance.pdp.getCurrent(i));
		}        

		SmartDashboard.putNumber("Right Current", Robot.instance.motors.rightBack.get());
		SmartDashboard.putNumber("left Current", Robot.instance.motors.leftBack.get());
		SmartDashboard.putBoolean("intake", Robot.instance.sensors.intake.get());
	

		
	}
	
}
