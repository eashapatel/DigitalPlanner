package cs3500.pa05.controller;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.model.Calendar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * Responsible for file-writing to a .bujo file.
 */
public class MyFileWriter {

  private String fileName;
  private BufferedWriter writer;
  private InputStream reader;
  private ObjectMapper mapper;


  /**
   * Constructor for MyFileWriter
   *
   * @param fileName contains the name the user would like the file written to.
   */
  public MyFileWriter(String fileName) {
    try {
      this.fileName = fileName;
      this.writer = new BufferedWriter(new FileWriter(fileName));
      this.reader = FileWriter.class.getResourceAsStream(fileName);
      this.mapper = new ObjectMapper();
    } catch (IOException e) {
      System.out.println("An error occurred during file creation.");
    }
  }

  /**
   * Writes the .bujo file, given some calendar.
   *
   * @param calendar the calendar to be detailed in the file.
   */
  public void writeBujoFile(Calendar calendar) {
    try {

      String json = mapper.writeValueAsString(calendar);
      writer.write(json);

      writer.flush();
      writer.close();

    } catch (IOException e) {
      System.out.println("An error occurred while writing file: " + e.getMessage());
    }
  }

  /**
   * reader method for bujo file
   *
   * @return Calender object
   */
  public Calendar readBujoFile() {
    StringBuilder jsonBuilder = new StringBuilder();
    if (reader != null) {
      try (BufferedReader bf = new BufferedReader(new InputStreamReader(reader))) {
        String line;
        while ((line = bf.readLine()) != null) {
          jsonBuilder.append(line);
        }
        String json = jsonBuilder.toString();
        return mapper.readValue(json, Calendar.class);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }
}
