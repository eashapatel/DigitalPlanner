package cs3500.pa05.controller;


import cs3500.pa05.model.Calendar;
import cs3500.pa05.model.Theme;
import java.io.IOException;
import javax.naming.directory.InvalidAttributesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JournalControllerImplTest {
  private JournalControllerImpl controller;

  @BeforeEach
  public void init() {
    Calendar calender = new Calendar(Theme.GRAY, 1, 1);
    controller = new JournalControllerImpl(calender);
  }

  //  @Test
  //  public void testRun() throws IOException, InvalidAttributesException {
  //    controller.run();
  //    Mockito.verify(controller).createNewEvent();
  //    Mockito.verify(controller).createNewTask();
  //    Mockito.verify(controller).showStats();
  //    Mockito.verify(controller).customThemePopup();
  //    Mockito.verify(controller).createMax();
  //    Mockito.verify(controller).saveName();
  //    Mockito.verify(controller).openName();
  //    Mockito.verify(controller).onDeleteButton();
  //    Mockito.verify(controller).onCompleteButton();
  //  }


}