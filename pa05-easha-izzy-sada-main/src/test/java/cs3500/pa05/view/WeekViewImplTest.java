package cs3500.pa05.view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa05.controller.JournalController;
import cs3500.pa05.controller.JournalControllerImpl;
import cs3500.pa05.model.Calendar;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeekViewImplTest {
  private WeekViewImpl weekView;
  private JournalController controller;
  private Calendar calendar;

  //  @BeforeEach
  //  public void init() {
  //    calendar = new Calendar();
  //    controller = new JournalControllerImpl(calendar);
  //    weekView = new WeekViewImpl(controller);
  //  }
  //
  //  @Test
  //  public void testLoadException() {
  //    weekView.loader = new FXMLLoader();
  //    assertThrows(IllegalStateException.class, () -> weekView.load());
  //  }

}