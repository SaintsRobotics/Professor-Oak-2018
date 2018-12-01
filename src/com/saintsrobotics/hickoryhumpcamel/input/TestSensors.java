package com.saintsrobotics.hickoryhumpcamel.input;

import com.saintsrobotics.hickoryhumpcamel.Robot;
import com.saintsrobotics.hickoryhumpcamel.util.AveragePIDSources;
import com.saintsrobotics.hickoryhumpcamel.util.DistanceEncoder;
import com.saintsrobotics.hickoryhumpcamel.util.ForwardConfiguration;
import com.saintsrobotics.hickoryhumpcamel.util.TurnConfiguration;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public class TestSensors extends Sensors {

  @Override
  public void init() {
    this.gyro = new ADXRS450_Gyro();
    this.leftEncoder = new Encoder(1, 2, true);
    this.rightEncoder = new Encoder(3, 4, false);
    this.leftEncoder.setDistancePerPulse(1/167.0/*inches per pulse*/);
    this.rightEncoder.setDistancePerPulse(1/167.0);
    this.average = new AveragePIDSources(this.leftEncoder, this.rightEncoder,false, false);
    
    this.lifterDown = new DigitalInput(8);
    this.lifterUp = new DigitalInput(7);
    this.liftEncoder = new DistanceEncoder(6, 5, 1528, true);
    
    //SMASH
    this.intake = new DigitalInput(19);
    
    this.wingsLeftOut = new DigitalInput(24);
    this.wingsLeftIn = new DigitalInput(23);
    this.wingsRightOut = new DigitalInput(13);
    this.wingsRightIn = new DigitalInput(12);
    
    this.forwardConfig = new ForwardConfiguration(Robot.instance.sensors.gyro, Robot.instance.sensors.average);
    this.turnConfig = new TurnConfiguration(Robot.instance.sensors.gyro);
    
  }
}
