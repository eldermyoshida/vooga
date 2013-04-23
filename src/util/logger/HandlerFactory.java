package util.logger;

import java.io.OutputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.SimpleFormatter;
import java.util.logging.SocketHandler;
import java.util.logging.StreamHandler;

public class HandlerFactory {
	public static Handler getFormatHandler (OutputStream out) {
        Handler handler = null;
        try {
            handler = new StreamHandler(out, new SimpleFormatter());
        }
        catch (Exception e) {
            NetworkLogger.LOGGER.severe(ERROR_MESSAGE);
        }
        return handler;
    }
	
	public static Handler getConsoleHandler () {
        Handler handler = null;
        try {
            handler = new ConsoleHandler();
            handler.setFormatter(new SimpleFormatter());
        }
        catch (Exception e) {
            NetworkLogger.LOGGER.severe(ERROR_MESSAGE);
        }
        return handler;
    }
	
	public static Handler getSocketHandler (String host, int port) {
        Handler handler = null;
        try {
            handler = new SocketHandler(host, port);
        }
        catch (Exception e) {
            NetworkLogger.LOGGER.severe(ERROR_MESSAGE);
        }
        return handler;
    }
	
	public static Handler getTextHandler () {
        Handler handler = null;
        try {
            handler = new FileHandler(myFileName + myExtension);
            handler.setFormatter(new SimpleFormatter());
        }
        catch (Exception e) {
            NetworkLogger.LOGGER.severe(ERROR_MESSAGE);
        }
        return handler;
    }
}
