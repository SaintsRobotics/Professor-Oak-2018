package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class LiftTaskWithMotor extends RunEachFrameTask {
  
    private static double holdPosition = 0.11; //Add actual value later
    
    
    @Override
    protected void runEachFrame() {
        double MovementAmount = Robot.instance.oi.xboxInput.rightTrigger() - Robot.instance.oi.xboxInput.leftTrigger();
        
        if (MovementAmount != 0) {
        	Robot.instance.motors.lifter.set(MovementAmount);
        }
        else {
        	Robot.instance.motors.lifter.set(holdPosition);
        }
    	
    
    }
        
        
}
