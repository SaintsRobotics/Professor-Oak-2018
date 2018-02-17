package com.saintsrobotics.hickoryhumpcamel.input;

import com.saintsrobotics.hickoryhumpcamel.util.AveragePIDSources;
import com.saintsrobotics.hickoryhumpcamel.util.DistanceEncoder;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public class TestSensors extends Sensors {

  @Override
  public void init() {
    //this.gyro = new ADXRS450_Gyro();
    //this.rightEncoder = new DistanceEncoder(0, 1, 232);
    //this.leftEncoder = new DistanceEncoder(2, 3, 232);
    //this.average = new AveragePIDSources(rightEncoder, leftEncoder, false, true);
    this.lifterDown = new DigitalInput(0);
    this.lifterUp = new DigitalInput(9);
    //liftEncoder is 127 ticks per in., 1528 ticks per foot
    this.liftEncoder = new DistanceEncoder(6, 5, 1528);
  }
}
