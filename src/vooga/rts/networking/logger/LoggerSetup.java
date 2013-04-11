package vooga.rts.networking.logger;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;


public class LoggerSetup {
    public static final String DEFAULT_NAME = "Logger";

    private String myFileName = DEFAULT_NAME;
    
    public void setup(int outputFormat,String fileName){
        setFileName(fileName);
        try {
            addHandler(outputFormat);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Adds a handler to the logger according to specifications
     * @param outputFormat type of handler
     * @throws IOException
     */
    public void addHandler(int outputFormat) throws IOException {
      IHandlerFormat loggerFormat = null;
      switch (outputFormat){
          case NetworkLogger.FORMAT_XML: loggerFormat = new HandlerXML(myFileName);
              break;
          case NetworkLogger.FORMAT_TXT: loggerFormat = new HandlerTxt(myFileName);
              break;
          case NetworkLogger.FORMAT_CONSOLE: loggerFormat = new HandlerConsole();
              break;
      }
      loggerFormat.setFormatHandler(NetworkLogger.LOGGER);

    }
    
    /**
     * 
     * @param fileName name of the file to write to in case a file handler is used
     */
    public void setFileName(String fileName){
        myFileName = fileName;
    }
}
