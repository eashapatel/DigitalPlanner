package cs3500.pa05.model.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.Category;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Time;
import cs3500.pa05.model.Weekday;
import javax.naming.directory.InvalidAttributesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Event class.
 */
class EventTest {

  Time time1;
  Event event1;
  Time time2;
  Event event2;

  @BeforeEach
  public void setup() throws InvalidAttributesException {
    time1 = new Time(8, 30);
    event1 = new Event("Meeting", "Meet with group members for economics project",
        time1, 60, Weekday.MONDAY, Category.HOMEWORK);

    time2 = new Time(9, 30);;
    event2 = new Event("Spin class", "Go to spin class at the gym",
        time2, 90, Weekday.THURSDAY, Category.PERSONAL);
  }

  @Test
  public void testGetName() {
    assertEquals("Meeting", event1.getName());
    assertEquals("Spin class", event2.getName());
  }

  @Test
  public void testGetDescription() {
    assertEquals("Meet with group members for economics project", event1.getDescription());
    assertEquals("Go to spin class at the gym", event2.getDescription());
  }

  @Test
  public void testGetTime() {
    assertEquals(time1, event1.getTime());
    assertEquals(time2, event2.getTime());
  }

  @Test
  public void testGetDuration() {
    assertEquals(60, event1.getDuration());
    assertEquals(90, event2.getDuration());
  }

  @Test
  public void testGetWeekday() {
    assertEquals(Weekday.MONDAY, event1.getWeekday());
    assertEquals(Weekday.THURSDAY, event2.getWeekday());
  }

  @Test
  public void testGetCategory() {
    assertEquals(Category.HOMEWORK, event1.getCategory());
    assertEquals(Category.PERSONAL, event2.getCategory());
  }

  @Test
  public void testEventToString() {
    String expected = "Meeting: \nMeet with group members for economics project\n8:30, 60 minutes";
    assertEquals(expected, event1.toString());
  }
}