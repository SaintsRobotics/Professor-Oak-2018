package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class LiftTask extends RunEachFrameTask {
    private long startTime = System.currentTimeMillis();
   
    
    @Override
    protected void runEachFrame() {
        double Rightamount = Robot.instance.oi.xboxInput.rightTrigger(); 
        double Leftamount = Robot.instance.oi.xboxInput.leftTrigger(); 
        double currentAmount = Robot.instance.servos.lifter.getAngle();
        long currentTime = System.currentTimeMillis();
        long DifferentTime = currentTime-startTime;
        if (Rightamount > 0) {
        
        Robot.instance.servos.lifter.setPosition(currentAmount+Rightamount*DifferentTime);
        	
        }
        if (Leftamount > 0) {
        	Robot.instance.servos.lifter.setPosition(currentAmount-Leftamount*DifferentTime);
        }
        	}
    	startTime = currentTime;
    
}
