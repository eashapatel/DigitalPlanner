package cs3500.pa05.model.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.Category;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Weekday;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests for Tasks
 */
class TaskTest {

  Task task1;

  Task task2;

  @BeforeEach
  public void setup() {
    task1 = new Task("Dishes", "Wash all dishes in the sink",
        Weekday.THURSDAY, Category.CLEANING);
    task2 = new Task("Paper", "Write economics paper on supply and demand",
        Weekday.SUNDAY, Category.HOMEWORK);
  }

  @Test
  public void testGetName() {
    assertEquals("Dishes", task1.getName());
    assertEquals("Paper", task2.getName());
  }

  @Test
  public void testGetDescription() {
    assertEquals("Wash all dishes in the sink", task1.getDescription());
    assertEquals("Write economics paper on supply and demand", task2.getDescription());
  }

  @Test
  public void testGetWeekday() {
    assertEquals(Weekday.THURSDAY, task1.getWeekday());
    assertEquals(Weekday.SUNDAY, task2.getWeekday());
  }

  @Test
  public void testGetCategory() {
    assertEquals(Category.CLEANING, (task1.getCategory()));
    assertEquals(Category.HOMEWORK, (task2.getCategory()));
  }

  @Test
  public void testIsComplete() {
    assertEquals(false, task1.isComplete());
    assertEquals(false, task2.isComplete());
    task1.markComplete();
    assertEquals(true, task1.isComplete());
  }

  @Test
  public void testMarkComplete() {
    task1.markComplete();
    assertTrue(task1.isComplete());
  }

}