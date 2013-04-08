package vooga.rts.networking;
import java.io.Serializable;

/**
 * This class contains all the information that is required to pass among
 * server and clients
 * @author Henrique Moraes
 * @author David Winegar
 *
 */
public class Message implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3906028159511905867L;
    private int myTimeSent;
    private int myTimeReceivedByServer;
    
    public Message (int timeSent) {
        myTimeSent = timeSent;
    }
    
    public void setTimeReceived (int timeReceived) {
        myTimeReceivedByServer = timeReceived;
    }
    
    public int getTimeSent () {
        return myTimeSent;
    }
    
    public int getTimeReceived () {
        return myTimeReceivedByServer;
    }
    
}
