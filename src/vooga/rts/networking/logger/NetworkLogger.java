package vooga.rts.networking.logger;


import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
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
  }
  
  public static void main(String args[]){
      NetworkLogger n = NetworkLogger.getInstance();
      n.addMemoryHandler(NetworkLogger.FORMAT_TXT, 50, Level.WARNING);  
      n.test();
  }

  public void test(){
      for (int i = 0; i<100; i++){
          LOGGER.info("record "+i);
      }
      LOGGER.warning("WARNING");
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
   * Logs a message into the logger
   * @param message
   */
  public void logMessage(String message){
      LOGGER.info(message);
      myStringBuilder.append(myDefaultFormatter.
                             format(new LogRecord(LOGGER.getLevel(),message)));
  }
  
}
