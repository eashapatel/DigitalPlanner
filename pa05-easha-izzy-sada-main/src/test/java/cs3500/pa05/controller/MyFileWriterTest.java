package cs3500.pa05.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Theme;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyFileWriterTest {

  private Calendar calendar;
  private String fileName;
  private MyFileWriter fileWriter;

  @BeforeEach
  public void setup() {
    calendar = new Calendar(Theme.DARK, 4, 3);
    fileName = "calender1.bujo";
  }

  @Test
  public void testWriteBujoFile() {
    try {
      MyFileWriter writer = new MyFileWriter(fileName);
      writer.writeBujoFile(calendar);

      File file = new File(fileName);

      assertTrue(file.exists());

      String fileContent = new String(Files.readAllBytes(file.toPath()));

      String expectedContent = "\"totalTasks\":0,\"totalEvents\":0,\"events\":[],\"tasks\":[],"
          + "\"theme\":\"DARK\",\"maxTasks\":4,\"maxEvents\":3}";

    } catch (IOException e) {
      System.out.println("Could not read file: " + e.getMessage());
    }
  }

}