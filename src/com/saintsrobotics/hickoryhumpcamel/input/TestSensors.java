package com.saintsrobotics.hickoryhumpcamel.input;

import com.saintsrobotics.hickoryhumpcamel.util.AveragePIDSources;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public class TestSensors extends Sensors {

  @Override
  public void init() {
    this.gyro = new ADXRS450_Gyro();
    this.lifterDown = new DigitalInput(0);
    this.lifterUp = new DigitalInput(9);
  }
}
