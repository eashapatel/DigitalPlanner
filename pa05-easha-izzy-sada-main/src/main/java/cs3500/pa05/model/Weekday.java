package cs3500.pa05.model;

/**
 * This class represents a weekday.
 */
public enum Weekday {
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

  /**
   * returns integer representation of weekday, for gridpane placement purposes
   *
   * @return integer representation of a weekday
   */
  public int toInt() {
    if (this.toString().equalsIgnoreCase("monday")) {
      return 1;
    } else if (this.toString().equalsIgnoreCase("tuesday")) {
      return 2;
    } else if (this.toString().equalsIgnoreCase("wednesday")) {
      return 3;
    } else if (this.toString().equalsIgnoreCase("thursday")) {
      return 4;
    } else if (this.toString().equalsIgnoreCase("friday")) {
      return 5;
    } else if (this.toString().equalsIgnoreCase("saturday")) {
      return 6;
    } else {
      return 7;
    }
  }
}

