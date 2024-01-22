package cs3500.pa05.model.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {

  @Test
  public void testAddCategory() {
    assertEquals("HOMEWORK", Category.HOMEWORK.toString());
    assertEquals("PERSONAL", Category.PERSONAL.toString());
    assertEquals("WORK", Category.WORK.toString());
    assertEquals("CLEANING", Category.CLEANING.toString());
  }

}