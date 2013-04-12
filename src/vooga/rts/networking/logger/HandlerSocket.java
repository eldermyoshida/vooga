package vooga.rts.networking.logger;


import java.util.logging.Handler;
import java.util.logging.SocketHandler;


/**
 * Class that sets a handler to the logger and outputs a records to a given
 * socket
 * 
 * @author Henrique Moraes
 * 
 */
public class HandlerSocket implements IHandlerFormat {
    private static final String ERROR_MESSAGE =
            "Error in creating socket format handler";
    private String myHost;
    private int myPort;

    /**
     * Constructor
     * 
     * @param host name of the host
     * @param port number of the port to create socket
     */
    public HandlerSocket (String host, int port) {
        myHost = host;
        myPort = port;
    }

    @Override
    public Handler getFormatHandler () {
        Handler handler = null;
        try {
            handler = new SocketHandler(myHost, myPort);
        }
        catch (Exception e) {
            NetworkLogger.LOGGER.severe(ERROR_MESSAGE);
        }
        return handler;
    }

}
