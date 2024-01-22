package cs3500.pa05.model;

/**
 * This class represents a task.
 */
public class Task {

  private String name;
  private String description; //optional
  private Weekday weekday;
  private Category category;
  private boolean complete;

  /**
   * constructor for task
   *
   * @param name        The name of a task.
   * @param description The description of a task.
   * @param weekday     The weekday of a task.
   * @param category    The category of a task.
   */
  public Task(String name, String description, Weekday weekday, Category category) {
    this.name = name;
    this.description = description;
    this.weekday = weekday;
    this.category = category;
    this.complete = false;
  }

  /**
   * string representation of a task
   *
   * @return string containing details of a task
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (complete) {
      sb.append(name + ": \n" + description + "\n" + "completed: true");
    } else {
      sb.append(name + ": \n" + description + "\n" + "completed: false");
    }

    return sb.toString();
  }


  /**
   * getter for name
   *
   * @return The name of a task.
   */
  public String getName() {
    return this.name;
  }

  /**
   * getter for description
   *
   * @return The description of a task.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * getter for Weekday
   *
   * @return The weekday of a task.
   */
  public Weekday getWeekday() {
    return this.weekday;
  }

  /**
   * getter for category
   *
   * @return The category of a task.
   */
  public Category getCategory() {
    return this.category;
  }

  /**
   * getter for complete
   *
   * @return The completion status of a task.
   */
  public boolean isComplete() {
    return this.complete;
  }

  /**
   * marks a task as complete
   */
  public void markComplete() {
    this.complete = true;
  }


}
