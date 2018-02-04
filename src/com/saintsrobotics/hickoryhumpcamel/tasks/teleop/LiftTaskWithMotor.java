package com.saintsrobotics.hickoryhumpcamel.tasks.teleop;

import com.saintsrobotics.hickoryhumpcamel.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.github.dozer.coroutine.helpers.RunEachFrameTask;


public class LiftTaskWithMotor extends RunEachFrameTask {
  
    private static double holdPosition; //Add actual value later
    
    
    @Override
    protected void runEachFrame() {
    	holdPosition = SmartDashboard.getNumber("holdPosition", 0.11);
        double MovementAmount = Robot.instance.oi.xboxInput.rightTrigger() - Robot.instance.oi.xboxInput.leftTrigger();
        if (MovementAmount != 0 && Robot.instance.sensors.lifterDown.get() != true && Robot.instance.sensors.lifterUp.get() != true) {
        	Robot.instance.motors.lifter.set(MovementAmount);
        }
        else {
        	Robot.instance.motors.lifter.set(holdPosition);
        }
    	 
    }
        
        
}
