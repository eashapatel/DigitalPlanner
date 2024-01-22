package cs3500.pa05.model;

import javax.naming.directory.InvalidAttributesException;

/**
 * This class represents a time.
 */
public class Time { //24 hour time

  private int hour;
  private int min;

  /**
   * constructor for time
   *
   * @param hour time in hours
   * @param min  time in minutes
   */
  public Time(int hour, int min) throws InvalidAttributesException {
    if (hour >= 0 && hour < 24) {
      this.hour = hour;
    } else {
      throw new InvalidAttributesException("invalid time (hour) input");
    }
    if (min >= 0 && min < 60) {
      this.min = min;
    } else {
      throw new InvalidAttributesException("invalid time (minute) input");
    }
  }

  /**
   * gets minute value of time
   *
   * @return minutes into the hour
   */
  public int getMin() {
    return this.min;
  }

  /**
   * gets hour value of time
   *
   * @return hour into the day
   */
  public int getHour() {
    return this.hour;
  }

  /**
   * gets grid row value, so that event/task can be placed in the correct pane
   *
   * @return int value representing AM vs PM
   */
  public int toInt() {
    if (hour >= 0 && hour < 12) {
      return 1;
    } else {
      return 2;
    }
  }

  /**
   * converts time object into a string
   *
   * @return string representing time
   */
  @Override
  public String toString() {
    return Integer.toString(hour) + ":" + Integer.toString(min);
  }

}

