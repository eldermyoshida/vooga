package vooga.rts.networking.logger;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
* A simple Logger program.
*/
public class NetworkLogger {
  private static Logger myLogger =
          Logger.getLogger(NetworkLogger.class.getName());

  public static void main(String[] args) {
      System.out.println(myLogger.toString());
      try {
          LoggerSetup set = new LoggerSetup();
          set.addHandler(myLogger,LoggerSetup.FORMAT_XML);
          set.addHandler(myLogger,LoggerSetup.FORMAT_TXT);
          set.addHandler(myLogger,LoggerSetup.FORMAT_CONSOLE);
    }
    catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
      System.out.println(myLogger.toString());
      myLogger.fine("test 1");
      myLogger.fine("test 2");
      myLogger.info("Test info");
      myLogger.info("besta 2");
      myLogger.warning("Test Warning");
      myLogger.severe("Test Severre");
      myLogger.severe("besta 5678");
      myLogger.severe("besta 1");
  }
}
