package cs3500.pa05.model.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.Time;
import javax.naming.directory.InvalidAttributesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeTest {

  Time t1;
  Time t2;
  Time t3;

  @BeforeEach
  public void init() throws InvalidAttributesException {
    t1 = new Time(11, 45);
  }

  @Test
  public void testHourError() throws InvalidAttributesException {
    try {
      t2 = new Time(24, 05);
    } catch (InvalidAttributesException e) {
      assertTrue("invalid time (hour) input".equals(e.getMessage()));
    }
  }

  @Test
  public void testMinError() throws InvalidAttributesException {
    try {
      t3 = new Time(14, 60);
    } catch (InvalidAttributesException e) {
      assertTrue("invalid time (minute) input".equals(e.getMessage()));
    }
  }

  @Test
  public void testGetHour() {
    assertEquals(11, t1.getHour());
  }

  @Test
  public void testGetMins() {
    assertEquals(45, t1.getMin());
  }

  @Test
  public void testTimeToString() {
    assertEquals("11:45", t1.toString());
  }
}