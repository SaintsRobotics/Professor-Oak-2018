package com.saintsrobotics.hickoryhumpcamel.input;

import com.saintsrobotics.hickoryhumpcamel.util.AveragePIDSources;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;

public class TestSensors extends Sensors {

  @Override
  public void init() {
    this.gyro = new ADXRS450_Gyro();
    this.rightEncoder = new Encoder(0, 1);
    this.leftEncoder = new Encoder(2, 3);
    this.average = new AveragePIDSources(rightEncoder, leftEncoder, false, true);
  }
}
