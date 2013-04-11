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
  public static final Logger LOGGER =
          Logger.getLogger(NetworkLogger.class.getName());
  public static final int FORMAT_XML = 1221;
  public static final int FORMAT_TXT = 1356;
  public static final int FORMAT_CONSOLE = 1209;
  
  private static NetworkLogger instance = null;
  private LoggerSetup mySetup;
  
  public static NetworkLogger getInstance() {
      if (instance == null) {
          return new NetworkLogger();
      }
      return instance;
  }
  
  private NetworkLogger(){
      mySetup = new LoggerSetup();
  }

  public void test(){
      System.out.println(LOGGER.toString());
      LOGGER.fine("test 1");
      LOGGER.fine("test 2");
      LOGGER.info("Test info");
      LOGGER.info("besta 2");
      LOGGER.warning("Test Warning");
      LOGGER.severe("Test Severre");
      LOGGER.severe("besta 5678");
      LOGGER.severe("besta 1");
  }
  
  public addHandler(int handlerType){
      mySetup.addHandler(handlerType);
  }
  
  public void logMessage(String message){
      LOGGER.info(message);
  }
}
