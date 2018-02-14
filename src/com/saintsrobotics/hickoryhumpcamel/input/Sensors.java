package com.saintsrobotics.hickoryhumpcamel.input;

import com.saintsrobotics.hickoryhumpcamel.util.AveragePIDSources;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public abstract class Sensors {
  public DigitalInput intake;
  public DigitalInput lifterUp;
  public DigitalInput lifterDown;

  public ADXRS450_Gyro gyro;

  public Encoder rightEncoder;
  public Encoder leftEncoder;
  public Encoder liftEncoder;
  public AveragePIDSources average;

  public DigitalInput wingsLeftDown;
  public DigitalInput wingsRightDown;
  public DigitalInput wingsLeftUp;
  public DigitalInput wingsRightUp;
  public Encoder wingsLeft;
  public Encoder wingsRight;

  public abstract void init();
}
