package vooga.rts.networking.logger;


import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

/**
* A class that handles a logger. It makes use of the singleton pattern
* to guarantee the use of a single logger in the program
* This class does not propagate LogRecords to parent Loggers, so if the 
* user wants the log printed on the console, he should manually call addHandler
* with FORMAT_CONSOLE as input
* This class also contains a string builder that records any LogRecord with
* a simpleFormatter so the user can refer to it later or send it through streams
* 
* @author Henrique Moraes
*/
public class NetworkLogger {
  public static final Logger LOGGER =
          Logger.getLogger(NetworkLogger.class.getName());
  public static final int FORMAT_XML = 1221;
  public static final int FORMAT_TXT = 1356;
  public static final int FORMAT_CONSOLE = 1209;
  
  private static NetworkLogger instance = null;
  private LoggerSetup mySetup;
  private StringBuilder myStringBuilder;
  private Formatter myDefaultFormatter;
  
  /**
   * 
   * @return instance of this Network Logger
   */
  public static NetworkLogger getInstance() {
      if (instance == null) {
          return new NetworkLogger();
      }
      return instance;
  }
  
  /**
   * Private constructor of this singleton
   */
  private NetworkLogger(){
      mySetup = new LoggerSetup();
      LOGGER.setUseParentHandlers(false);
      myStringBuilder = new StringBuilder();
      myDefaultFormatter = new SimpleFormatter();
      LOGGER.setLevel(Level.INFO);
  }
  
  /**
   * Adds a handler to the logger depending on static constants
   * @param handlerType the type of handler to be added
   */
  public void addHandler(int handlerType){
      mySetup.addHandler(handlerType);
  }
  
  /**
   * Adds a memory handler to the logger depending on static constants and 
   * constraints.
   * @param handlerType the type of handler to have records pushed to
   * @param size Number of maximum records this handler will maintain
   * @param push as soon as a message of the given level is issued
   */
  public void addMemoryHandler(int handlerType, int size, Level pushLevel){
      mySetup.addMemoryHandler(handlerType, size, pushLevel);
  }
  
  /**
   * Logs a message into the logger with its current level
   * @param message
   */
  public void logMessage(String message){
      LOGGER.log(LOGGER.getLevel(),message);
  }
  
  /**
   * 
   * @param level Constant representing the level of the message
   * @param message String containing the message to be logged
   */
  public void logMessage(Level level, String message) {
      LOGGER.log(level,message);
  }
  
}
