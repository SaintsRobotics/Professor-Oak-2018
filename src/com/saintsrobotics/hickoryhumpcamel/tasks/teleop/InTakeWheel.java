package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class InTakeWheel extends RunEachFrameTask {

    @Override
    protected void runEachFrame() {
        boolean trig = Robot.instance.oi.xboxInput.Y();
        
        while(Robot.instance.sensors.intake.get() != true && trig) {
        	Robot.instance.motors.intake.set(0.1);
        	
        }
    }
}
