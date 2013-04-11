package vooga.rts.networking.logger;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;


public class LoggerSetup {
    public static final int FORMAT_XML = 1221;
    public static final int FORMAT_TXT = 1356;
    public static final int FORMAT_CONSOLE = 1209;
    public static final String DEFAULT_NAME = "Logger";

    private String myFileName = DEFAULT_NAME;
    
    public void setup(Logger logger, int outputFormat,String fileName){
        setFileName(fileName);
        try {
            addHandler(logger,outputFormat);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addHandler(Logger logger, int outputFormat) throws IOException {
      IHandlerFormat loggerFormat = null;
      switch (outputFormat){
          case FORMAT_XML: loggerFormat = new HandlerXML(myFileName);
              break;
          case FORMAT_TXT: loggerFormat = new HandlerTxt(myFileName);
              break;
          case FORMAT_CONSOLE: loggerFormat = new HandlerConsole();
              break;
      }
      loggerFormat.setFormatHandler(logger);

    }
    
    public void setFileName(String fileName){
        myFileName = fileName;
    }
}
