package util.logger;


import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.MemoryHandler;


/**
 * Helper that sets handlers for the logger
 * 
 * @author Henrique Moraes
 * 
 */
public class LoggerManager {
    public static final String DEFAULT_NAME = "Logger";
    private static final String ERROR_MESSAGE =
            "Error in adding handler to logger";
    private static final String ERROR_ARGUMENT_MESSAGE =
            "Not necessary arguments to create this handler";
    private static final String LOG_EXT = ".txt";

    private String myFileName = DEFAULT_NAME;

    /**
     * Creates a handler to the logger according to specifications
     * 
     * @param outputFormat type of handler
     * @param args arguments used for Stream and Socket handlers
     * @throws IOException
     */
    private Handler createHandler (int outputFormat, Object ... args) throws IOException {
        IVoogaHandler loggerFormat = null;
        try {
            switch (outputFormat) {
                case NetworkLogger.FORMAT_XML:
                    loggerFormat = new HandlerXML(myFileName);
                    break;
                case NetworkLogger.FORMAT_TXT:
                    loggerFormat = new HandlerTxt(myFileName);
                    break;
                case NetworkLogger.FORMAT_CONSOLE:
                    loggerFormat = new HandlerConsole();
                    break;
                case NetworkLogger.FORMAT_STREAM:
                    loggerFormat =
                            new HandlerStream((OutputStream) args[0]);
                    break;
                case NetworkLogger.FORMAT_SOCKET:
                    loggerFormat = new HandlerSocket((String) args[0], (Integer) args[1]);
                    break;
                case NetworkLogger.FORMAT_LOG_FILE:
                    loggerFormat = new HandlerTxt(myFileName, LOG_EXT);
                    break;
            }
        }
        catch (IllegalArgumentException e) {
            NetworkLogger.LOGGER.severe(ERROR_ARGUMENT_MESSAGE);
        }
        return loggerFormat.getFormatHandler();

    }

    /**
     * 
     * @param outputFormat format in which the handler will be created
     *        uses one of the constants from NetworkLogger
     */
    public void addHandler (int outputFormat, Object ... args) {
        try {
            NetworkLogger.LOGGER.addHandler(createHandler(outputFormat, args));
        }
        catch (Exception e) {
            NetworkLogger.LOGGER.severe(ERROR_MESSAGE);
        }
    }

    /**
     * 
     * Adds a handler that sends log records across a given stream
     * 
     * @param Output stream in case using a stream handler
     */
    public void addStreamHandler (OutputStream out) {
        addHandler(NetworkLogger.FORMAT_STREAM, out);
    }

    /**
     * 
     * Adds a handler that sends log records through a given socket
     * 
     * @param host string with the name of the host of this connection
     * @param port number of the port to be used
     */
    public void addSocketHandler (String host, int port) {
        addHandler(NetworkLogger.FORMAT_SOCKET, host, port);
    }

    /**
     * Adds a memory handler to the logger depending on static constants and
     * constraints. A memory handler pushes all log records after a message of
     * the specified threshold level is logged
     * This API was designed to be able to combine any other handler to the
     * memoryHandler
     * WARNING the type of handler added will have the same level as the
     * current level of the logger. Once it is set, its level cannot be changed
     * 
     * @param outputFormat the type of handler to have records pushed to
     * @param size Number of maximum records this handler will maintain
     * @param pushLevel push log in memory as soon as a message of the
     *        given level is issued
     * @param args arguments needed to create certain handlers such as
     *        stream and socket handlers. Optional
     */
    public void addMemoryHandler (int outputFormat, int size, Level pushLevel, Object ... args) {
        try {
            Handler hand = createHandler(outputFormat, args);
            hand.setLevel(NetworkLogger.LOGGER.getLevel());
            NetworkLogger.LOGGER.
                    addHandler(new MemoryHandler(hand, size, pushLevel));
        }
        catch (Exception e) {
            NetworkLogger.LOGGER.severe(ERROR_MESSAGE);
        }
    }

    /**
     * 
     * @param fileName name of the file to write to in case a file handler is used
     */
    public void setFileName (String fileName) {
        myFileName = fileName;
    }
}
