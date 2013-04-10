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
    private static final int DEFAULT_VALUE = -1;
    private int myTimeSent;
    private int myTimeReceivedByServer = DEFAULT_VALUE;

    @Override
    public boolean equals(Object object) {
        if(object == null) {
            return false;
        }
        if (!(object instanceof Message)) {
            return false;
        } 
        return false;
//        Message message = (Message) object;
//        return (getTimeSent() != message.getTimeSent());
    }
    
    @Override
    public int hashCode () {
        return myTimeSent * 200 - 13;
    }
    
}
