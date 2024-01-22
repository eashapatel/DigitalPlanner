package cs3500.pa05.view;

import cs3500.pa05.controller.JournalController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * represents the view of the program
 */
public class  WeekViewImpl implements WeekView {

  public FXMLLoader loader;

  /**
   * constructor for program view
   *
   * @param controller we want to set the view up with
   */
  public WeekViewImpl(JournalController controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("week.fxml"));
    // initialization and location setting omitted for brevity
    this.loader.setController(controller);
  }

  /**
   * loads the view into a scene to be shown as a GUI
   *
   * @return a scene of the inputted GUI
   */
  @Override
  public Scene load() {
    try {
      return this.loader.load();
    } catch (IOException e) {
      throw new IllegalStateException("Unable to load GUI");
    }
  }

}
