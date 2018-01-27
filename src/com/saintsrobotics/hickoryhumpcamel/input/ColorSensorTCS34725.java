package com.saintsrobotics.hickoryhumpcamel.input;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

public class ColorSensorTCS34725 {
  private I2C i2c;
  private static final int DEVICE_ADDRESS = 0x29;
  private static final int COLOR_BYTES = 2;
  private static final int COMMAND_BIT = 0x80;

  private static final int ENABLE_REGISTER = 0x00;
  private static final int ENABLE_VALUE_PON = 0x01;
  private static final int ENABLE_VALUE_AEN = 0x02;
  private static final int TIMING_REGISTER = 0x01;
  private static final int CONTROL_REGISTER = 0x0F;
  private static final int STATUS_REGISTER = 0x13;

  private boolean initialized = false;

  public ColorSensorTCS34725(Port port) {
    this.i2c = new I2C(port, DEVICE_ADDRESS);
  }

  // write sleep method to get rid of try-catch stuff
  private void zsleep(int t) {
    try {
      Thread.sleep(t);
    } catch (InterruptedException e) {
    }
  }

  /**
   * Enables device
   */
  public void enable() {
    this.i2c.write(ENABLE_REGISTER, ENABLE_VALUE_PON);
    this.zsleep(3);
    this.i2c.write(ENABLE_REGISTER, ENABLE_VALUE_PON | ENABLE_VALUE_AEN);
    this.initialized = true;
  }

  /**
   * Sets RGBC Gain Control
   * 
   * @param gain
   */
  public void setGain(Gain gain) {
    this.i2c.write(COMMAND_BIT | CONTROL_REGISTER, gain.value);
  }

  /**
   * Sets RGBC Timing
   * 
   * @param time
   */
  public void setIntegrationTime(IntegrationTime time) {
    this.i2c.write(COMMAND_BIT | TIMING_REGISTER, time.value);
  }

  /**
   * Gets color by reading high and low registers and combining two values
   * 
   * @param color
   * @return
   */
  public int getColor(Color color) {
    if (!this.initialized) {
      this.enable();
    }
    byte[] buffer = new byte[COLOR_BYTES];
    this.i2c.read(COMMAND_BIT | color.value, COLOR_BYTES, buffer);
    return (Byte.toUnsignedInt(buffer[1]) << 8) | Byte.toUnsignedInt(buffer[0]);
  }

  private int getByte(int address) {
    byte[] buffer = new byte[1];
    this.i2c.read(COMMAND_BIT | address, 1, buffer);
    return buffer[0];
  }

  /**
   * Checks if RGBC is valid
   * 
   * @return
   */
  public boolean isRGBCValid() {
    if (!this.initialized) {
      this.enable();
    }
    return (this.getByte(STATUS_REGISTER) & 1) == 1;
  }

  /**
   * Possible values for integration time
   */
  public static enum IntegrationTime {
    /**
     * Sets integration cycles to 1 with time of 2.4 ms
     */
    TIME_2_4(0xFF),

    /**
     * Sets integration cycles to 10 with time of 24 ms
     */
    TIME_24(0xF6),

    /**
     * Sets integration cycles to 42 with time of 101 ms
     */
    TIME_101(0xD5),

    /**
     * Sets integration cycles to 64 with time of 154 ms
     */
    TIME_154(0xC0),

    /**
     * Sets integration cycles to 256 with time of 700 ms
     */
    TIME_700(0x00);

    private int value;

    private IntegrationTime(int value) {
      this.value = value;
    }
  }

  /**
   * Possible values for gain
   */
  public static enum Gain {
    /**
     * Sets gain to 1x
     */
    GAIN_1(0x00),

    /**
     * Sets gain to 4x
     */
    GAIN_4(0x01),

    /**
     * Sets gain to 16x
     */
    GAIN_16(0x02),

    /**
     * Sets gain to 60x
     */
    GAIN_60(0x03);

    private int value;

    private Gain(int value) {
      this.value = value;
    }

  }

  /**
   * Possible colors to read
   */
  public static enum Color {
    /**
     * Reads clear
     */
    CLEAR(0x14),

    /**
     * Reads red
     */
    RED(0x16),

    /**
     * Reads green
     */
    GREEN(0x18),

    /**
     * Reads blue
     */
    BLUE(0x1A);

    private int value;

    private Color(int value) {
      this.value = value;
    }
  }
}
