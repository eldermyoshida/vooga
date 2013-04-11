package vooga.rts.networking.logger;


import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Class that sets a handler to the logger and outputs a file 
 * records to the console
 * @author Henrique Moraes
 *
 */
public class HandlerConsole implements IHandlerFormat {
    private static final String ERROR_MESSAGE = 
            "Error in creating Console based handler";
    
    @Override
    public Handler getFormatHandler () {
        Handler handler = null;
        try {
            handler = new ConsoleHandler();
            handler.setFormatter(new SimpleFormatter());
        }
        catch (Exception e){
            NetworkLogger.LOGGER.severe(ERROR_MESSAGE);
        } 
        return handler;
    }
}
