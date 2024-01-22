package cs3500.pa05.model.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Category;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Theme;
import cs3500.pa05.model.Time;
import cs3500.pa05.model.Weekday;
import java.io.IOException;
import java.util.ArrayList;
import javax.naming.directory.InvalidAttributesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalendarTest {

  private Calendar calender;
  private Time time;
  private Event event;
  private Task task;

  @BeforeEach
  public void init() throws InvalidAttributesException {
    calender = new Calendar(Theme.DARK, 1, 1);
    time = new Time(11, 30);
    event = new Event("zoom", "interview with Joe", time, 1,
        Weekday.TUESDAY, Category.WORK);
    task = new Task("Write Tests", "gegt code to 90% test coverage",
        Weekday.THURSDAY, Category.HOMEWORK);

  }

  @Test
  public void testAddTask() throws IOException {
    calender.addTask(task);
    ArrayList<Task> testTasks = calender.getTasks();
    assertTrue(testTasks.contains(task));
  }

  @Test
  public void testAddEvent() throws IOException {
    calender.addEvent(event);
    ArrayList<Event> testEvents = calender.getEvents();
    assertTrue(testEvents.contains(event));
  }

  @Test
  public void testSetEvents() {
    ArrayList<Event> events = new ArrayList<>();
    events.add(event);
    calender.setEvents(events);
    assertTrue(calender.getTotalEvents() == events.size());
  }

  @Test
  public void testSetTasks() {
    ArrayList<Task> tasks = new ArrayList<>();
    tasks.add(task);
    calender.setTasks(tasks);
    assertTrue(calender.getTotalTasks() == tasks.size());
  }

  @Test
  public void testSetTheme() {
    calender.setTheme(Theme.DARK);
    assertTrue(calender.getTheme().equals(Theme.DARK));
  }

  @Test
  public void testSetMaxTasks() {
    calender.setMaxTasks(2);
    assertTrue(calender.getMaxTasks() == 2);
  }

  @Test
  public void testSetMaxEvents() {
    calender.setMaxEvents(2);
    assertTrue(calender.getMaxEvents() == 2);
  }

  @Test
  public void testPercentTasksCompleted() {
    String expected = calender.percentTasksCompleted();
    assertEquals(expected, "NaN% tasks completed!");
  }


}