package cs3500.pa05.model;

/**
 * This class represents an event.
 */
public class Event {

  private String name;
  private String description; //optional
  private Time time;
  private int duration;
  private Weekday weekday;
  private Category category;


  /**
   * constructor for event
   *
   * @param name        The name of an event.
   * @param description The description of an event.
   * @param time        The time of an event.
   * @param duration    The duration of an event.
   * @param weekday     The weekday of an event.
   * @param category    The category of an event.
   */
  public Event(String name, String description, Time time,
               int duration, Weekday weekday, Category category) {
    this.name = name;
    this.description = description;
    this.time = time;
    this.duration = duration;
    this.weekday = weekday;
    this.category = category;
  }

  /**
   * converts an event into a string representation
   *
   * @return string representing details of an event
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append(name + ": \n");
    sb.append(description + "\n");
    sb.append(time.toString() + ", " + duration + " minutes");

    return sb.toString();
  }

  /**
   * getter for name
   *
   * @return The name of an event.
   */
  public String getName() {
    return this.name;
  }

  /**
   * getter for description
   *
   * @return The description of an event.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * getter for time
   *
   * @return The time of an event.
   */
  public Time getTime() {
    return this.time;
  }

  /**
   * getter for duration
   *
   * @return The duration of an event.
   */
  public int getDuration() {
    return this.duration;
  }

  /**
   * getter for weekday
   *
   * @return The weekday of an event.
   */
  public Weekday getWeekday() {
    return this.weekday;
  }

  /**
   * getter for category
   *
   * @return The category of an event.
   */
  public Category getCategory() {
    return this.category;
  }


}
