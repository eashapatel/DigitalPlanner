package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * represents a calendar
 */
public class Calendar {

  @JsonProperty("events")
  private ArrayList<Event> events;
  @JsonProperty("tasks")
  private ArrayList<Task> tasks;

  @JsonProperty("theme")
  private Theme theme;
  @JsonProperty("maxTasks")
  private int maxTasks;
  @JsonProperty("maxEvents")
  private int maxEvents;

  /**
   * constructor for calendar
   *
   * @param theme of the calendar view
   * @param maxTasks allowed for user to place in calendar
   * @param maxEvents allowed for user to place in calendar
   */
  public Calendar(Theme theme, int maxTasks, int maxEvents) {
    this.theme = theme;
    this.maxTasks = maxTasks;
    this.maxEvents = maxEvents;
    this.events = new ArrayList<Event>();
    this.tasks = new ArrayList<Task>();
  }

  /**
   * convenience constructor for calendar
   */
  public Calendar() {
    this.theme = Theme.LIGHT;
    this.maxTasks = 0;
    this.maxEvents = 0;
    this.events = new ArrayList<Event>();
    this.tasks = new ArrayList<Task>();
  }


  /**
   * adds a task to the calendar
   *
   * @param task the task to be added
   * @throws IOException if the max tasks has been reached
   */
  public void addTask(Task task) throws IOException {
    if (this.tasks.size() <= this.maxTasks) {
      this.tasks.add(task);
    } else {
      throw new IOException("Max tasks reached");
    }
  }

  /**
   * adds an event to the calendar
   *
   * @param event the event to be added
   * @throws IOException if the max events has been reached
   */
  public void addEvent(Event event) throws IOException {
    if (this.events.size() <= this.maxEvents) {
      this.events.add(event);
    } else {
      throw new IOException("Max events reached");
    }
  }


  /**
   * sets the theme of a calendar
   *
   * @param theme of the calendar visually
   */
  @JsonSetter("theme")
  public void setTheme(Theme theme) {
    this.theme = theme;
  }

  /**
   * sets the max amount of tasks allowed on a calendar
   *
   * @param maxTasks int of tasks allowed
   */
  @JsonSetter("maxTasks")
  public void setMaxTasks(int maxTasks) {
    this.maxTasks = maxTasks;
  }

  /**
   * sets max amount of events allowed on a calendar
   *
   * @param maxEvents int of events allowed
   */
  @JsonSetter("maxEvents")
  public void setMaxEvents(int maxEvents) {
    this.maxEvents = maxEvents;
  }

  /**
   * sets a list of events in a calendar
   *
   * @param events a list of events
   */
  @JsonSetter("events")
  public void setEvents(ArrayList<Event> events) {
    this.events = events;
  }

  /**
   * sets a list of tasks in a calendar
   *
   * @param tasks a list of tasks
   */
  @JsonSetter("tasks")
  public void setTasks(ArrayList<Task> tasks) {
    this.tasks = tasks;
  }

  /**
   * gets the theme of a calendar
   *
   * @return the theme
   */
  public Theme getTheme() {
    return theme;
  }

  /**
   * gets the max amount of tasks allowed
   *
   * @return int of tasks allowed
   */
  public int getMaxTasks() {
    return this.maxTasks;
  }

  /**
   * gets max amount of events allowed
   *
   * @return int of events allowed
   */
  public int getMaxEvents() {
    return this.maxEvents;
  }

  /**
   * returns list of calendar tasks
   *
   * @return tasks in a calendar
   */
  public ArrayList<Task> getTasks() {
    return this.tasks;
  }

  /**
   * returns list of calendar events
   *
   * @return events in a calendar
   */
  public ArrayList<Event> getEvents() {
    return this.events;
  }

  /**
   * Calculates the percentage of completed tasks.
   */
  public String percentTasksCompleted() {
    List<Task> tasks = this.getTasks();
    List<Task> completedTasks = new ArrayList<>();

    for (Task task : tasks) {
      if (task.isComplete()) {
        completedTasks.add(task);
      }
    }

    int completedLength = completedTasks.size();
    int tasksLength = tasks.size();
    double completionPercentage = (double) completedLength  * 100 / tasksLength;

    return Double.toString(completionPercentage) + "% tasks completed!";
  }

  /**
   * gets current amount of events in calendar
   *
   * @return int of events in calendar
   */
  public int getTotalEvents() {
    return this.getEvents().size();
  }

  /**
   * gets current amount of tasks in calendar
   *
   * @return int of tasks in calendar
   */
  public int getTotalTasks() {
    return this.getTasks().size();
  }
}