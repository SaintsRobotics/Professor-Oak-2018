package com.saintsrobotics.hickoryhumpcamel.input;

import com.saintsrobotics.hickoryhumpcamel.util.AveragePIDSources;
import com.saintsrobotics.hickoryhumpcamel.util.DistanceEncoder;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public class TestSensors extends Sensors {

  @Override
  public void init() {
    this.gyro = new ADXRS450_Gyro();
    this.leftEncoder = new DistanceEncoder(1, 2, 161.9666666667, true);
    this.rightEncoder = new DistanceEncoder(3, 4, 161.9666666667, false);
    this.average = new AveragePIDSources(this.leftEncoder, this.rightEncoder,false, false);
    
    this.lifterDown = new DigitalInput(8);
    this.lifterUp = new DigitalInput(7);
    this.liftEncoder = new DistanceEncoder(6, 5, -1528, false);
    
    //SMASH
    this.intake = new DigitalInput(19);
    
    this.wingsLeftOut = new DigitalInput(24);
    this.wingsLeftIn = new DigitalInput(23);
    this.wingsRightOut = new DigitalInput(13);
    this.wingsRightIn = new DigitalInput(12);
    
  }
}
