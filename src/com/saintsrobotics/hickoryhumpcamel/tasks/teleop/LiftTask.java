package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class LiftTask extends RunEachFrameTask {
    
   
    
    @Override
    protected void runEachFrame() {
        double Rightamount = Robot.instance.oi.xboxInput.rightTrigger(); 
        double Leftamount = Robot.instance.oi.xboxInput.leftTrigger(); 
        double currentAmount = Robot.instance.servos.lifter.getAngle();
        
        if (Rightamount > 0) {
        
        Robot.instance.servos.lifter.setAngle(currentAmount+Rightamount);
        	
        }
        if (Leftamount > 0) {
        	Robot.instance.servos.lifter.setAngle(currentAmount-Leftamount);
        }
        	}
    
    
}
