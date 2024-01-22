package cs3500.pa05.controller;

import static cs3500.pa05.model.Category.addCat;
import static cs3500.pa05.model.Category.getCatFromString;

import cs3500.pa05.model.Category;
import cs3500.pa05.model.Time;
import cs3500.pa05.model.Weekday;
import java.io.IOException;
import javax.naming.directory.InvalidAttributesException;

/**
 * represents utility methods for the controller
 */
public class ControllerUtils {

  /**
   * Selects the category based on user input
   *
   * @param category the category the user selects.
   * @return the Category represented as an enumeration
   */
  public static Category selectCategory(String category) {
    Category eventCategory = null;

    if (category.equals("cleaning")) {
      eventCategory = Category.CLEANING;
    } else if (category.equals("homework")) {
      eventCategory = Category.HOMEWORK;
    } else if (category.equals("personal")) {
      eventCategory = Category.PERSONAL;
    } else if (category.equals("work")) {
      eventCategory = Category.WORK;
    } else {
      addCat(category);
      eventCategory = getCatFromString(category);
    }
    return eventCategory;
  }

  /**
   * Formats and verifes the Time passed as input
   *
   * @param time String representing time from user
   * @return the Time instance representing the time string
   * @throws InvalidAttributesException if time is invalid
   */
  public static Time formatTime(String time) throws InvalidAttributesException {
    Time eventTime = null;

    try {
      int colon = time.indexOf(":");
      int hour = Integer.parseInt(time.substring(0, colon));
      int min = Integer.parseInt(time.substring(colon + 1, time.length()));

      if (hour >= 0 && hour <= 23 && min >= 0 && min <= 59) {
        eventTime = new Time(hour, min);
      } else {
        throw new InvalidAttributesException("Invalid time");
      }
    } catch (InvalidAttributesException e) {
      throw new InvalidAttributesException("Could not parse");
    }
    return eventTime;
  }

  /**
   * Checks and verifies weekday input
   *
   * @param dayOfWeek the user input regarding weekday
   * @return Weekday enum corresponding to user input
   */
  public static Weekday checkWeekday(String dayOfWeek) {
    Weekday weekday = null;
    try {
      if (dayOfWeek.equalsIgnoreCase("sunday")) {
        weekday = Weekday.SUNDAY;
      } else if (dayOfWeek.equalsIgnoreCase("monday")) {
        weekday = Weekday.MONDAY;
      } else if (dayOfWeek.equalsIgnoreCase("tuesday")) {
        weekday = Weekday.TUESDAY;
      } else if (dayOfWeek.equalsIgnoreCase("wednesday")) {
        weekday = Weekday.WEDNESDAY;
      } else if (dayOfWeek.equalsIgnoreCase("thursday")) {
        weekday = Weekday.THURSDAY;
      } else if (dayOfWeek.equalsIgnoreCase("friday")) {
        weekday = Weekday.FRIDAY;
      } else if (dayOfWeek.equalsIgnoreCase("saturday")) {
        weekday = Weekday.SATURDAY;
      } else {
        throw new InvalidAttributesException("This is not a day of the week.");
      }
    } catch (InvalidAttributesException e) {
      throw new RuntimeException("Could not parse: " + e.getMessage());
    }
    return weekday;
  }


}
