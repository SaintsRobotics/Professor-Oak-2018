package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class OutTakeWheel extends RunEachFrameTask {
    @Override
    protected void runEachFrame() {
        boolean trig = Robot.instance.oi.xboxInput.LB();
        
        while(trig) {
        	Robot.instance.motors.intake.set(-0.1);
        	
        }
    }
}
