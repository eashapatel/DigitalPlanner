package cs3500.pa05;

import static javafx.application.Application.launch;

import cs3500.pa05.controller.JournalController;
import cs3500.pa05.controller.JournalControllerImpl;
import cs3500.pa05.model.Calendar;
import cs3500.pa05.view.WeekView;
import cs3500.pa05.view.WeekViewImpl;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.stage.Stage;

/**
 * driver of the program
 */
public class Driver extends Application {

  /**
   * starts up the GUI program based on implementation of code
   *
   * @param primaryStage the primary stage for this application, onto which
   *                     the application scene can be set.
   *                     Applications may create other stages, if needed, but they will not be
   *                     primary stages.
   */
  @Override
  public void start(Stage primaryStage) {


    HostServices hostServices = getHostServices();
    JournalController controller = new JournalControllerImpl(new Calendar());
    WeekView weekView = new WeekViewImpl(controller);

    try {
      primaryStage.setScene(weekView.load());
      primaryStage.setTitle("Bullet Journal");


      primaryStage.show();
      System.out.println("Based through show()");
      // not passing through show();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }

    controller.run();

  }

  /**
   * program entry point
   *
   * @param args configuration inputs
   */
  public static void main(String[] args) {
    launch(args);
  }
}