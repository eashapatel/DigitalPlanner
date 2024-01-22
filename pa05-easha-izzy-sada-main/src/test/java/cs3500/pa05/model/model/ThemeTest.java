package cs3500.pa05.model.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.Theme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests for Theme.
 */
class ThemeTest {

  Theme light;
  Theme dark;
  Theme gray;

  @BeforeEach
  public void setup() {
    light = Theme.LIGHT;
    dark = Theme.DARK;
    gray = Theme.GRAY;
  }

  @Test
  public void testToString() {
    assertEquals("LIGHT", light.toString());
    assertEquals("DARK", dark.toString());
    assertEquals("GRAY", gray.toString());
  }

}