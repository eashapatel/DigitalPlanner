package cs3500.pa05.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa05.model.Category;
import cs3500.pa05.model.Time;
import cs3500.pa05.model.Weekday;
import javax.naming.directory.InvalidAttributesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerUtilsTest {

  private ControllerUtils controllerUtils;
  private Time time;

  @BeforeEach
  public void init() throws InvalidAttributesException {
    controllerUtils = new ControllerUtils();
    time = new Time(9, 30);
  }

  @Test
  public void testSelectCatageory() {
    assertEquals(Category.CLEANING, controllerUtils.selectCategory("cleaning"));
    assertEquals(Category.HOMEWORK, controllerUtils.selectCategory("homework"));
    assertEquals(Category.PERSONAL, controllerUtils.selectCategory("personal"));
    assertEquals(Category.WORK, controllerUtils.selectCategory("work"));
  }

  @Test
  public void testFormatTime() throws InvalidAttributesException {
    Time formatTime =  controllerUtils.formatTime("9:30");
    assertEquals(9, formatTime.getHour());
    assertEquals(30, formatTime.getMin());


  }

  @Test
  public void testFormatTimeException() {
    assertThrows(InvalidAttributesException.class, () -> controllerUtils.formatTime("12:60"));
  }

  @Test
  public void testChooseWeekday() {
    assertEquals(Weekday.SUNDAY, controllerUtils.checkWeekday("sunday"));
    assertEquals(Weekday.MONDAY, controllerUtils.checkWeekday("monday"));
    assertEquals(Weekday.TUESDAY, controllerUtils.checkWeekday("tuesday"));
    assertEquals(Weekday.WEDNESDAY, controllerUtils.checkWeekday("wednesday"));
    assertEquals(Weekday.THURSDAY, controllerUtils.checkWeekday("thursday"));
    assertEquals(Weekday.FRIDAY, controllerUtils.checkWeekday("friday"));
    assertEquals(Weekday.SATURDAY, controllerUtils.checkWeekday("saturday"));
  }

  @Test
  public void testChooseWeekdayException() {
    assertThrows(RuntimeException.class, () ->
        controllerUtils.checkWeekday("oneday"));
  }

}