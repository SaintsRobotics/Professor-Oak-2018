package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class OutTakeWheel extends RunEachFrameTask {
	private long time = 0;
	private long startTime;
    @Override
    protected void runEachFrame() {
        boolean trig = Robot.instance.oi.xboxInput.LB();
        
        if(trig) {
        	startTime = System.currentTimeMillis();
        	while (time < 3000) { //Adjust time limit as needed
        		Robot.instance.motors.intake.set(-0.1);
        		this.time = System.currentTimeMillis() - startTime;
        	}
        	
        }
    }
}
