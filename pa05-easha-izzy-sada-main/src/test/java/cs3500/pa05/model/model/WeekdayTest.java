package cs3500.pa05.model.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.Weekday;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests for Weekday.
 */
class WeekdayTest {

  Weekday mon;
  Weekday tues;
  Weekday wed;
  Weekday thurs;
  Weekday fri;
  Weekday sat;
  Weekday sun;

  @BeforeEach
  public void setup() {
    mon = Weekday.MONDAY;
    tues = Weekday.TUESDAY;
    wed = Weekday.WEDNESDAY;
    thurs = Weekday.THURSDAY;
    fri = Weekday.FRIDAY;
    sat = Weekday.SATURDAY;
    sun = Weekday.SUNDAY;
  }

  @Test
  public void testToString() {
    assertEquals("MONDAY", mon.toString());
    assertEquals("TUESDAY", tues.toString());
    assertEquals("WEDNESDAY", wed.toString());
    assertEquals("THURSDAY", thurs.toString());
    assertEquals("FRIDAY", fri.toString());
    assertEquals("SATURDAY", sat.toString());
    assertEquals("SUNDAY", sun.toString());
  }

  @Test
  public void testWeekdayToInt() {
    assertEquals(Weekday.MONDAY.toInt(), 1);
    assertEquals(Weekday.TUESDAY.toInt(), 2);
    assertEquals(Weekday.WEDNESDAY.toInt(), 3);
    assertEquals(Weekday.THURSDAY.toInt(), 4);
    assertEquals(Weekday.FRIDAY.toInt(), 5);
    assertEquals(Weekday.SATURDAY.toInt(), 6);
    assertEquals(Weekday.SUNDAY.toInt(), 7);
  }

}