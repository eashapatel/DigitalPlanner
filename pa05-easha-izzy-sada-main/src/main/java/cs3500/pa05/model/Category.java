package cs3500.pa05.model;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * This class represents a category of an event.
 */
public enum Category {

  HOMEWORK,
  PERSONAL,
  CLEANING,
  WORK;


  /**
   * adds an enumeration to the Category enum
   *
   * @param enumName name of enumeration
   */
  public static void addCat(String enumName) {
    // Create a new array with an increased length
    Category[] newEnums = Arrays.copyOf(values(), values().length + 1);

    // Add the new enum at the end
    newEnums[newEnums.length - 1] = Category.valueOf(enumName);

    // Update the values of the enum with the new array
    setEnumValues(newEnums);
  }

  /**
   * sets enum values
   *
   * @param newEnums a list of new Category enums
   */
  private static void setEnumValues(Category[] newEnums) {
    try {
      // Get the $VALUES field of the enum class
      Field valuesField = Category.class.getDeclaredField("$VALUES");

      // Make the field accessible
      valuesField.setAccessible(true);

      // Set the new values for the enum
      valuesField.set(null, newEnums);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  /**
   * returns a Category based on string
   *
   * @param enumName string value of a Category
   * @return Category representing string
   */
  public static Category getCatFromString(String enumName) {
    for (Category value : values()) {
      if (value.name().equals(enumName)) {
        return value;
      }
    }
    throw new IllegalArgumentException("No enum constant with name: " + enumName);
  }

}
