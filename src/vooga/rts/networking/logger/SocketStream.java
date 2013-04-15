package vooga.rts.networking.logger;
import java.util.logging.Handler;


public class SocketStream implements IHandlerFormat {
    private String myHost;
    private int myPort;
    
    public SocketStream (String host, int port) {
        myHost = host;
        myPort = port;
    }

    @Override
    public Handler getFormatHandler () {
        // TODO Auto-generated method stub
        return null;
    }

}
