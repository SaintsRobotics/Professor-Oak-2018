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
    this.lifterDown = new DigitalInput(0);
    this.lifterUp = new DigitalInput(9);
    
    this.liftEncoder = new DistanceEncoder(6, 5, 1528);
    this.leftEncoder = new Encoder(1, 2);
    this.rightEncoder = new Encoder(3, 4);
  }
}
