package vooga.rts.networking.logger;


import java.io.OutputStream;
import java.util.logging.Formatter;
import java.util.logging.Handler;
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
* In case it is needed to record the entries and exits in methods, the level
* of the logger has to be changes to FINER through the method setLevel of this 
* class
* 
* @author Henrique Moraes
*/
public class NetworkLogger {
  public static final Logger LOGGER =
          Logger.getLogger(NetworkLogger.class.getName());
  public static final int FORMAT_XML = 1221;
  public static final int FORMAT_TXT = 1356;
  public static final int FORMAT_CONSOLE = 1209;
  public static final int FORMAT_STREAM = 1200;
  
  private static NetworkLogger instance = null;
  private LoggerSetup mySetup;
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
      myDefaultFormatter = new SimpleFormatter();
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
   * 
   * Adds a handler that sends log records across a given stream
   * @param Output stream in case using a stream handler
   */
  public void addStreamHandler(OutputStream out) {
      mySetup.addStreamHandler(out);
  }
  
  /**
   * Sets the level of the logger and all its handlers
   * @param level 
   */
  public void setLevel(Level level){
      LOGGER.setLevel(level);
      for (Handler h : LOGGER.getHandlers()){
          h.setLevel(level);
      }
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
