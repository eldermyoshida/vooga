package vooga.rts.networking.logger;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;


public class HandlerXML implements IHandlerFormat {
    private static final String XML_EXT = ".xml";
    private String myFileName;
    
    public HandlerXML(String fileName){
        myFileName = fileName;
    }
    
    public HandlerXML(){
        myFileName = LoggerSetup.DEFAULT_NAME;
    }

    @Override
    public void setFormatHandler (Logger log) {
        try {
            FileHandler handler = new FileHandler(myFileName+XML_EXT);
            handler.setFormatter(new XMLFormatter());
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
