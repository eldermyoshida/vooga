package vooga.rts.networking.logger;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Class that sets a handler to the logger and outputs a file 
 * records to the console
 * @author Henrique Moraes
 *
 */
public class HandlerConsole implements IHandlerFormat {
    @Override
    public void setFormatHandler (Logger log) {
        try {
            ConsoleHandler handler = new ConsoleHandler();
            handler.setFormatter(new SimpleFormatter());
            log.addHandler(handler);
        }
        catch (SecurityException e) {
            
            e.printStackTrace();
        }     
    }
}
