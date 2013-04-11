package vooga.rts.networking.logger;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;


public class HandlerTxt implements IHandlerFormat {
    private static final String TXT_EXT = ".txt";
    private String myFileName;
    
    public HandlerTxt(String fileName){
        myFileName = fileName;
    }
    
    public HandlerTxt(){
        myFileName = LoggerSetup.DEFAULT_NAME;
    }

    @Override
    public void setFormatHandler (Logger log) {
        try {
            FileHandler handler = new FileHandler(myFileName+TXT_EXT);
            handler.setFormatter(new SimpleFormatter());
            log.addHandler(handler);
        }
        catch (SecurityException e) {
            
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }     
    }
}
