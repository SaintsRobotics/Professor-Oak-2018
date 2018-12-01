package com.saintsrobotics.hickoryhumpcamel;

import com.saintsrobotics.hickoryhumpcamel.util.ForwardConfiguration;
import com.saintsrobotics.hickoryhumpcamel.util.TurnConfiguration;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class Flags {
  public double liftEncoderValue; 
  
  public String gameMessage;
  public ForwardConfiguration forwardPidConfig;
  public TurnConfiguration turnPidConfig;
  //public SpeedController[] temp;
  public PowerDistributionPanel pdp;
  
  public boolean switchStatus; //left True right False


}
