package vooga.rts.networking.logger;

import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.MemoryHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;


public class LoggerSetup {
    public static final String DEFAULT_NAME = "Logger";

    private String myFileName = DEFAULT_NAME;
    
    public void setup(int outputFormat,String fileName){
        setFileName(fileName);
        addHandler(outputFormat);
    }

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
    
    public void addHandler(int outputFormat) {
        try {
            NetworkLogger.LOGGER.addHandler(createHandler(outputFormat));
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
