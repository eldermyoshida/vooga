package vooga.rts.networking.logger;
import java.io.OutputStream;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

/**
 * Class that sets a handler to the logger and outputs file records to an 
 * output Stream
 * @author Henrique Moraes
 *
 */
public class HandlerStream implements IHandlerFormat {
    private static final String ERROR_MESSAGE =
            "Error in creating stream format handler";
    private OutputStream myOutputStream;
    
    /**
     * Constructor
     * @param out outputstream to send log messages
     */
    public HandlerStream(OutputStream out){
        if(out == null)
            out = System.out;
        myOutputStream = System.out;
    }
    
    /**
     * Constructor
     * Automatically creates an output stream with System.out
     */
    public HandlerStream(){
        myOutputStream = System.out;
    }
    
    @Override
    public Handler getFormatHandler () {
        Handler handler = null;
        try {
            handler = new StreamHandler(myOutputStream, new SimpleFormatter());
        }
        catch (Exception e){
            NetworkLogger.LOGGER.severe(ERROR_MESSAGE);
        }
        return handler;
    }

}
