package vooga.rts.networking.logger;
import java.util.logging.Handler;


public class HandlerSocket implements IHandlerFormat {
    private String myHost;
    private int myPort;
    
    public HandlerSocket (String host, int port) {
        myHost = host;
        myPort = port;
    }

    @Override
    public Handler getFormatHandler () {
        // TODO Auto-generated method stub
        return null;
    }

}
