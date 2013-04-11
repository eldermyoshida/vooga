package vooga.rts.networking.logger;

import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.MemoryHandler;

/**
 * Helper that sets handlers for the logger
 * @author Henrique Moraes
 *
 */
public class LoggerSetup {
    public static final String DEFAULT_NAME = "Logger";

    private String myFileName = DEFAULT_NAME;

    /**
     * Creates a handler to the logger according to specifications
     * @param outputFormat type of handler
     * @throws IOException
     */
    private Handler createHandler(int outputFormat) throws IOException {
      IHandlerFormat loggerFormat = null;
      switch (outputFormat){
          case NetworkLogger.FORMAT_XML: loggerFormat = new HandlerXML(myFileName);
              break;
          case NetworkLogger.FORMAT_TXT: loggerFormat = new HandlerTxt(myFileName);
              break;
          case NetworkLogger.FORMAT_CONSOLE: loggerFormat = new HandlerConsole();
              break;
      }
      return loggerFormat.getFormatHandler();

    }
    
    /**
     * 
     * @param outputFormat format in which the handler will be created
     * uses one of the constants from NetworkLogger
     */
    public void addHandler(int outputFormat) {
        try {
            NetworkLogger.LOGGER.addHandler(createHandler(outputFormat));
        }
        catch (Exception e){
            NetworkLogger.LOGGER.severe("Error in adding handler to logger");
        }
    }
    
    /**
     * Adds a memory handler to the logger depending on static constants and 
     * constraints.
     * @param outputFormat the type of handler to have records pushed to
     * @param size Number of maximum records this handler will maintain
     * @param pushLevel push log in memory as soon as a message of the 
     * given level is issued
     */
    public void addMemoryHandler(int outputFormat, int size, Level pushLevel){
        try {
            NetworkLogger.LOGGER.addHandler(new MemoryHandler(createHandler(outputFormat),size,pushLevel));
        }
        catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * @param fileName name of the file to write to in case a file handler is used
     */
    public void setFileName(String fileName){
        myFileName = fileName;
    }
}
