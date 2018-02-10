package com.saintsrobotics.hickoryhumpcamel.input;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public abstract class Sensors {
	public DigitalInput intake;
	public DigitalInput lifterUp;
	public DigitalInput lifterDown;
	
	public DigitalInput wingsLeftDown;
	public DigitalInput wingsRightDown;
	public DigitalInput wingsLeftUp;
	public DigitalInput wingsRightUp;
	public Encoder wingsLeft;
	public Encoder wingsRight;
}
