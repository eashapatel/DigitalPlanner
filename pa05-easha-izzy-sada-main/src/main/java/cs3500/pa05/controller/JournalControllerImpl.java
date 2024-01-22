package cs3500.pa05.controller;

import static cs3500.pa05.controller.ControllerUtils.checkWeekday;
import static cs3500.pa05.controller.ControllerUtils.formatTime;
import static cs3500.pa05.controller.ControllerUtils.selectCategory;

import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Category;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Theme;
import cs3500.pa05.model.Time;
import cs3500.pa05.model.Weekday;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.naming.directory.InvalidAttributesException;


/**
 * represents the program's controller
 */
public class JournalControllerImpl implements JournalController {

  private Calendar calendar;
  @FXML
  private Button eventButton;
  @FXML
  private Button taskButton;
  @FXML
  private Button lightButton;
  @FXML
  private Button grayButton;
  @FXML
  private Button darkButton;
  @FXML
  private AnchorPane themeBackground;
  @FXML
  private Label header;
  @FXML
  private TextField eventName;
  @FXML
  private TextField eventDescription;
  @FXML
  private TextField eventDay;
  @FXML
  private TextField eventTime;
  @FXML
  private TextField eventDuration;
  @FXML
  private TextField eventCategory;
  @FXML
  private Button eventEnter;
  @FXML
  private TextField taskName;
  @FXML
  private TextField taskDescription;
  @FXML
  private TextField taskDay;
  @FXML
  private TextField taskCategory;
  @FXML
  private Button taskEnter;
  @FXML
  private Button enterEvent;
  @FXML
  GridPane week;
  @FXML
  private TextField backColor;
  @FXML
  private TextField headerFont;
  @FXML
  private TextField headerColor;

  @FXML
  private TextArea hyperLinkEntry;

  private FXMLLoader loader1;
  @FXML
  private Text processedLinkText;

  @FXML
  private Button processLinkButton;

  private HostServices hostServices;

  @FXML
  private Button themeFinish;
  @FXML
  private Label totalEvents;
  @FXML
  private Label totalTasks;
  @FXML
  private Label percTasks;
  @FXML
  private Button launchStats;
  @FXML
  private TextField userMaxTasks;
  @FXML
  private TextField userMaxEvents;
  @FXML
  private Button maxApply;

  @FXML
  private Button processQuoteButton;

  @FXML
  private TextArea quoteText;

  @FXML
  private Text noteQuote;


  @FXML
  private Button customButton;

  @FXML
  private Button doneStats;

  @FXML
  private Button maxButton;
  @FXML
  private Text invalidEvent;
  @FXML
  private Text invalidTask;
  @FXML
  private Button saveButton;
  @FXML
  private TextField saveName;
  @FXML
  private Button saveEnter;

  @FXML
  private Button openEnter;

  @FXML
  private TextField openName;

  @FXML
  private Button openButton;

  @FXML
  private TextField type;
  @FXML
  private TextField typeName;
  @FXML
  private Button deleteButton;
  @FXML
  private Button deleteEnterInfo;
  @FXML
  private Text mondayAm;
  @FXML
  private Text mondayPm;
  @FXML
  private Text tuesdayAm;
  @FXML
  private Text tuesdayPm;
  @FXML
  private Text wednesdayAm;
  @FXML
  private Text wednesdayPm;
  @FXML
  private Text thursdayAm;
  @FXML
  private Text thursdayPm;
  @FXML
  private Text fridayAm;
  @FXML
  private Text fridayPm;
  @FXML
  private Text saturdayAm;
  @FXML
  private Text saturdayPm;
  @FXML
  private Text sundayAm;
  @FXML
  private Text sundayPm;
  @FXML
  private Button taskCompleteEnter;
  @FXML
  private TextField taskCompleteName;
  @FXML
  private Button completeTaskButton;



  /**
   * constructor for controller
   *
   * @param calendar a calender representing data
   */
  public JournalControllerImpl(Calendar calendar) {
    this.calendar = calendar;
    this.eventButton = new Button();
    this.taskButton = new Button();
    this.lightButton = new Button();
    this.grayButton = new Button();
    this.darkButton = new Button();
    this.eventName = new TextField();
    this.eventDescription = new TextField();
    this.eventDay = new TextField();
    this.eventTime = new TextField();
    this.eventDuration = new TextField();
    this.eventCategory = new TextField();
    this.eventEnter = new Button();
    this.taskName = new TextField();
    this.taskDescription = new TextField();
    this.taskDay = new TextField();
    this.taskCategory = new TextField();
    this.taskEnter = new Button();
    this.enterEvent = new Button();
    this.header = new Label();
    this.week = new GridPane();
    this.backColor = new TextField();
    this.headerFont = new TextField();
    this.headerColor = new TextField();
    loader1 = new FXMLLoader();
    loader1.setController(this);
    loader1.setLocation(getClass().getResource("maxEventsAndTasks.fxml"));

    this.hyperLinkEntry = new TextArea();
    this.processedLinkText = new Text();
    this.processLinkButton = new Button();

    this.themeFinish = new Button();
    this.totalEvents = new Label();
    this.totalTasks = new Label();
    this.percTasks = new Label();
    this.launchStats = new Button();
    this.userMaxTasks = new TextField();
    this.userMaxEvents = new TextField();
    this.maxApply = new Button();

    this.processQuoteButton = new Button();
    this.quoteText = new TextArea();
    this.noteQuote = new Text();
    this.customButton = new Button();
    this.doneStats = new Button();
    this.maxButton = new Button();
    this.invalidEvent = new Text();
    this.invalidTask = new Text();
    this.saveButton = new Button();
    this.saveName = new TextField();
    this.saveEnter = new Button();
    this.openButton = new Button();
    this.type = new TextField();
    this.typeName = new TextField();
    this.deleteButton = new Button();
    this.deleteEnterInfo = new Button();
    this.mondayAm = new Text();
    this.mondayPm = new Text();
    this.tuesdayAm = new Text();
    this.tuesdayPm = new Text();
    this.wednesdayAm = new Text();
    this.wednesdayPm = new Text();
    this.thursdayAm = new Text();
    this.thursdayPm = new Text();
    this.fridayAm = new Text();
    this.fridayPm = new Text();
    this.saturdayAm = new Text();
    this.saturdayPm = new Text();
    this.sundayAm = new Text();
    this.sundayPm = new Text();
    this.taskCompleteEnter = new Button();
    this.taskCompleteName = new TextField();
    this.completeTaskButton = new Button();
  }

  /**
   * turns information into text to be shown
   *
   * @param weekday int
   * @param time int
   * @return text of event or task information
   */
  private Text getText(int weekday, int time) {
    if (time == 1) {
      if (weekday == 1) {
        return mondayAm;
      } else if (weekday == 2) {
        return tuesdayAm;
      } else if (weekday == 3) {
        return wednesdayAm;
      } else if (weekday == 4) {
        return thursdayAm;
      } else if (weekday == 5) {
        return fridayAm;
      } else if (weekday == 6) {
        return saturdayAm;
      } else {
        return sundayAm;
      }
    } else {
      if (weekday == 1) {
        return mondayPm;
      } else if (weekday == 2) {
        return tuesdayPm;
      } else if (weekday == 3) {
        return wednesdayPm;
      } else if (weekday == 4) {
        return thursdayPm;
      } else if (weekday == 5) {
        return fridayPm;
      } else if (weekday == 6) {
        return saturdayPm;
      } else {
        return sundayPm;
      }
    }
  }


  /**
   * runs event handlers for buttons on the GUI
   */
  @FXML
  public void run() {
    lightButton.setOnAction(event -> this.setBackground(Theme.LIGHT));
    grayButton.setOnAction(event -> this.setBackground(Theme.GRAY));
    darkButton.setOnAction(event -> this.setBackground(Theme.DARK));
    processLinkButton.setOnAction(event -> {
      String link = hyperLinkEntry.getText();
      //String processedLink = processLink(link);
      processedLinkText.setText(processLink(link));
    });
    eventButton.setOnAction(event -> {
      try {
        this.createNewEvent();
      } catch (IOException | InvalidAttributesException e) {
        throw new RuntimeException(e);
      }
    });

    taskButton.setOnAction(event -> {
      try {
        createNewTask();
      } catch (IOException | InvalidAttributesException e) {
        throw new RuntimeException(e);
      }
    });
    processQuoteButton.setOnAction(event -> {
      String quote = quoteText.getText();
      //String processedLink = processLink(link);
      noteQuote.setText("\"" + quote + "\"");
    });
    launchStats.setOnAction(event -> {
      try {
        showStats();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
    customButton.setOnAction(event -> {
      try {
        customThemePopup();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
    maxButton.setOnAction(event -> {
      try {
        createMax();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
    saveButton.setOnAction(event -> {
      try {
        saveName();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
    openButton.setOnAction(event -> {
      try {
        openName();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
    deleteButton.setOnAction(event -> {
      try {
        onDeleteButton();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
    completeTaskButton.setOnAction(event -> {
      try {
        onCompleteButton();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });
  }

  /**
   * event handler for what happens when complete button is clicked
   *
   * @throws IOException if cannot load
   */
  public void onCompleteButton() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getClassLoader().getResource("completeTask.fxml"));
    loader.setController(this);
    Stage root = loader.load();

    root.initModality(Modality.APPLICATION_MODAL);
    root.setTitle("Complete Task");
    root.show();

    taskCompleteEnter.setOnAction(event -> {
      collectTaskComplete();
      root.close();
    });
  }

  private void collectTaskComplete() {
    String name = taskCompleteName.getText();
    Task t = null;
    for (Task task : calendar.getTasks()) {
      if (task.getName().equalsIgnoreCase(name)) {
        t = task;
        t.markComplete();
      }
    }

    Text text = getText(t.getWeekday().toInt(), 1);
    text.setText(t.toString());
  }

  /**
   * loads a popup and displays up-to-date calculated stats on weekly tasks and events
   *
   * @throws IOException if cannot load
   */
  public void showStats() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getClassLoader().getResource("weekStats.fxml"));
    loader.setController(this);
    Stage root = loader.load();

    root.initModality(Modality.APPLICATION_MODAL);
    root.setTitle("Week Stats");
    root.show();

    // updates the stats, still need to figure out how to make the popup close
    totalEvents.setText(Integer.toString(calendar.getTotalEvents()) + " events");
    totalTasks.setText(Integer.toString(calendar.getTotalTasks()) + " tasks");
    percTasks.setText(calendar.percentTasksCompleted());

    doneStats.setOnAction(event -> root.close());
  }

  /**
   * creates popup and processes/sets user data on apply button
   *
   * @throws IOException when popup fails to load
   */
  public void createMax() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getClassLoader().getResource("maxEventsAndTasks.fxml"));
    loader.setController(this);
    Stage root = loader.load();

    root.initModality(Modality.APPLICATION_MODAL);
    root.setTitle("Set Max");
    root.show();

    // when the apply button is pressed, the calender is updated with max values
    // still need to implement popup closing
    maxApply.setOnAction(event -> {
      collectCalenderMax();
      root.close();
    });
  }

  /**
   * collects user input on max events/tasks and updates calendar with this information
   */
  private void collectCalenderMax() {
    int maxTasks = Integer.parseInt(userMaxTasks.getText());
    calendar.setMaxTasks(maxTasks);
    System.out.println(maxTasks);

    int maxEvents = Integer.parseInt(userMaxEvents.getText());
    calendar.setMaxEvents(maxEvents);
    System.out.println(maxEvents);
  }


  /**
   * generates custom theme popup, and collects/sets input/theme on enter button
   *
   * @throws IOException if popup cannot be loaded
   */
  public void customThemePopup() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getClassLoader().getResource("customTheme.fxml"));
    loader.setController(this);
    Stage root = loader.load();

    root.initModality(Modality.APPLICATION_MODAL);
    root.setTitle("Create Custom Theme");
    root.show();

    themeFinish.setOnAction(event -> {
      collectThemeData();
      root.close();
    });
  }

  /**
   * collects user input for a custom theme, and sets custom theme in GUI
   */
  private void collectThemeData() {
    String color = backColor.getText();
    String colorId;
    if (color.equalsIgnoreCase("red")) {
      colorId = "-fx-background-color: #FFCCCC;";
    } else if (color.equalsIgnoreCase("orange")) {
      colorId = "-fx-background-color: #FFD8B7;";
    } else if (color.equalsIgnoreCase("pink")) {
      colorId = "-fx-background-color: #FFC0CB;";
    } else if (color.equalsIgnoreCase("yellow")) {
      colorId = "-fx-background-color: #FFFFCC;";
    } else if (color.equalsIgnoreCase("green")) {
      colorId = "-fx-background-color: #C1FFC1;";
    } else if (color.equalsIgnoreCase("blue")) {
      colorId = "-fx-background-color: #ADD8E6;";
    } else {
      colorId = "-fx-background-color: #E6E6FA;";
    }

    String font = headerFont.getText();
    Font fontId;
    if (font.equalsIgnoreCase("arial")) {
      fontId = Font.font("Arial", 18);
    } else if (font.equalsIgnoreCase("times new roman")) {
      fontId = Font.font("Times New Roman", 18);
    } else {
      fontId = Font.font("Verdana", 18);
    }

    String headCol = headerColor.getText();
    String textColor;
    if (headCol.equalsIgnoreCase("red")) {
      textColor = "-fx-background-color: #8B0000;";
    } else if (headCol.equalsIgnoreCase("black")) {
      textColor = "-fx-background-color: #000000;";
    } else if (headCol.equalsIgnoreCase("blue")) {
      textColor = "-fx-background-color: #00008B;";
    } else {
      textColor = "-fx-background-color: #800080;";
    }
    themeBackground.setStyle(colorId);
    header.setFont(fontId);
    header.setStyle(textColor);

  }

  /**
   * sets the visuals of the GUI based on a given theme
   *
   * @param theme of the GUI
   */
  private void setBackground(Theme theme) {
    if (theme.toString().equalsIgnoreCase("dark")) {
      themeBackground.setStyle("-fx-background-color: #808080;");
      header.setFont(Font.font("Arial", 18));
    } else if (theme.toString().equalsIgnoreCase("gray")) {
      themeBackground.setStyle("-fx-background-color: #D3D3D3;");
      header.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
    } else {
      themeBackground.setStyle("-fx-background-color: #FFFFFF;");
      header.setFont(Font.font("Verdana", FontPosture.ITALIC, 14));
    }
  }

  /**
   * Creates a new Event and adds it to the Calendar
   *
   * @throws InvalidAttributesException if time is invalid
   */
  public void createNewEvent() throws IOException, InvalidAttributesException {
    FXMLLoader loader2 = new FXMLLoader();
    loader2.setLocation(getClass().getClassLoader().getResource("createEvent.fxml"));
    loader2.setController(this);
    Stage root = loader2.load();

    root.initModality(Modality.APPLICATION_MODAL);
    root.setTitle("New Event");
    root.show();
    if (!(calendar.getEvents().size() <= calendar.getMaxEvents())) {
      invalidEvent.setText("You cannot add more events!\n Maximum events reached!");
    }

    enterEvent.setOnAction(event -> {
      root.close();
      try {
        collectEventData();
      } catch (InvalidAttributesException e) {
        throw new RuntimeException(e);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });

  }

  /**
   * collects user input for new event, adds event to calendar, and prints it to GUI
   *
   * @throws InvalidAttributesException when user enters incorrect input
   * @throws IOException when input cannot be accessed/processed
   */
  private void collectEventData() throws InvalidAttributesException, IOException {
    String name = eventName.getText();
    String description = eventDescription.getText();
    System.out.println(description);
    Weekday weekday = checkWeekday(eventDay.getText());
    Time time = formatTime(eventTime.getText());
    int duration = Integer.parseInt(eventDuration.getText());
    Category category = selectCategory(eventCategory.getText());
    Event event = new Event(name, description, time, duration, weekday, category);

    calendar.addEvent(event);

    Text text = getText(weekday.toInt(), time.toInt());
    text.setText(event.toString());
  }

  /**
   * Creates a new Task and adds it to the calendar
   */
  public void createNewTask() throws IOException, InvalidAttributesException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getClassLoader().getResource("taskPopup.fxml"));
    loader.setController(this);
    Stage root = loader.load();

    root.initModality(Modality.APPLICATION_MODAL);
    root.setTitle("New Task");
    root.show();

    if (!(calendar.getTasks().size() <= calendar.getMaxTasks())) {
      invalidTask.setText("You cannot add more events!\n Maximum tasks reached!");
    }

    taskEnter.setOnAction(event -> {
      root.close();
      try {
        collectTaskData();
      } catch (InvalidAttributesException e) {
        throw new RuntimeException(e);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });

  }

  /**
   * gets user input for task information, creates task, and prints it to the GUI
   *
   * @throws InvalidAttributesException if user enters incorrect input
   * @throws IOException if user input cannot be accessed
   */
  private void collectTaskData() throws InvalidAttributesException, IOException {
    String name = taskName.getText();
    String description = taskDescription.getText();
    Weekday weekday = checkWeekday(taskDay.getText());
    Category category = selectCategory(taskCategory.getText());

    Task task = new Task(name, description, weekday, category);

    calendar.addTask(task);


    Text text = getText(weekday.toInt(), 1);
    text.setText(task.toString());
  }

  /**
   * adds correct annotations to a string link
   *
   * @param link string representing a link
   * @return a processed string of input
   */
  private String processLink(String link) {
    // Check if the link is valid HTTP/HTTPS
    if (isValidHttpLink(link)) {
      // Add hyperlink tags to make the link clickable
      return "<a href='" + link + "'>" + link + "</a>";
    } else {
      // Return the original link if it's not valid
      return link;
    }
  }

  /**
   * checks to see if given string is a valid Http link
   *
   * @param link the string representing a link
   * @return true if string is valid http link, else false
   */
  private boolean isValidHttpLink(String link) {
    // Use your existing validation logic for HTTP/HTTPS links
    // Return true if the link is valid, false otherwise
    // For example, you can use regular expressions or URL validation libraries
    // to check if the link matches the expected format of a valid HTTP/HTTPS link
    // Return true if the link is valid, false otherwise
    return link.matches("^https?://.*$");
  }

  /**
   * loads the popup for saving the week view and prompts a name for the file to be seen at
   *
   * @throws IOException when popup cannot load, or data cannot be accessed
   */
  public void saveName() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getClassLoader().getResource("save.fxml"));
    loader.setController(this);
    Stage root = loader.load();

    root.initModality(Modality.APPLICATION_MODAL);
    root.setTitle("Save");
    root.show();

    saveEnter.setOnAction(event -> {
      saveCalender();
      root.close();
    });

  }

  /**
   * loads open.fxml
   *
   * @throws IOException if cannot be loaded
   */
  public void openName() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getClassLoader().getResource("open.fxml"));
    loader.setController(this);
    Stage root = loader.load();

    root.initModality(Modality.APPLICATION_MODAL);
    root.setTitle("Open");
    root.show();

    openEnter.setOnAction(event -> {
      String fileName = openName.getText();
      openCalender(fileName);
      root.close();
    });
  }

  /**
   * opens calender
   *
   * @param filePath String file path to calendar
   */
  private void openCalender(String filePath) {
    MyFileWriter myFileWriter = new MyFileWriter(filePath);

    Calendar newCalendar = myFileWriter.readBujoFile();
    this.calendar = newCalendar;
  }


  /**
   * saves calender data as a .bujo file
   */
  private void saveCalender() {
    String fileName = saveName.getText();
    MyFileWriter myFileWriter = new MyFileWriter(fileName);

    myFileWriter.writeBujoFile(calendar);
  }

  /**
   * event handler for delete button
   *
   * @throws IOException if cannot be loaded
   */
  public void onDeleteButton() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getClassLoader().getResource("delete.fxml"));
    loader.setController(this);
    Stage root = loader.load();

    root.initModality(Modality.APPLICATION_MODAL);
    root.setTitle("Delete Event/Task");
    root.show();

    deleteEnterInfo.setOnAction(event -> {
      removeItem();
      root.close();
    });
  }

  /**
   * removes task from list
   */
  private void removeItem() {
    String eventOrTask = type.getText();
    String name = typeName.getText();
    if (eventOrTask.equalsIgnoreCase("task")) {
      List<Task> tasks = calendar.getTasks();
      List<Task> copyTaskList = new ArrayList<>();
      for (Task t : tasks) {
        Task task = t;
        copyTaskList.add(task);
      }
      int index = 0;
      for (Task t : copyTaskList) {
        if (t.getName().equals(name)) {
          tasks.remove(index);
          int weekday = t.getWeekday().toInt();
          Text text = getText(weekday, 1);
          week.getChildren().remove(text);
        }
        index++;
      }
    } else {
      List<Event> events = calendar.getEvents();
      List<Event> eventCopyList = new ArrayList<>();
      for (Event e : events) {
        Event event = e;
        eventCopyList.add(event);
      }
      int index = 0;
      for (Event e : eventCopyList) {
        if (e.getName().equals(name)) {
          events.remove(index);
          int weekday = e.getWeekday().toInt();
          int time = e.getTime().toInt();
          Text text = getText(weekday, time);
          week.getChildren().remove(text);
        }
        index++;
      }
    }
  }

}
