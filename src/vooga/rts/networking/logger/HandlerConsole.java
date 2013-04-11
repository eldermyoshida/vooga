package vooga.rts.networking.logger;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


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
