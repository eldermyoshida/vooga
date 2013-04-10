package vooga.rts.networking.server;

import java.io.Serializable;


/**
 * This class contains all the information that is required to pass among
 * server and clients
 * 
 * @author Henrique Moraes
 * @author David Winegar
 * 
 */
public class Message implements Serializable, Comparable<Message> {

    private static final long serialVersionUID = 3906028159511905867L;
    private static final int DEFAULT_VALUE = -1;
    private int myTimeSent;
    private int myTimeReceivedByServer = DEFAULT_VALUE;

    /**
     * Default message constructor, sets the time sent by client. Not hardcoded so that games may
     * use a Timer, System, or other basis for time.
     * 
     * @param timeSent time message sent (created) by client.
     */
    public Message (int timeSent) {
        myTimeSent = timeSent;
    }

    /**
     * Sets time received by server. Not hardcoded so that games may use a Timer, System, or other
     * basis for time.
     * 
     * @param timeReceived received by server
     */
    public void setTimeReceived (int timeReceived) {
        myTimeReceivedByServer = timeReceived;
    }

    /**
     * Gets time sent by client. Not hardcoded so that games may use a Timer, System, or other basis
     * for time.
     * 
     * @return time sent by client
     */
    public int getTimeSent () {
        return myTimeSent;
    }

    /**
     * Gets time received by server. Not hardcoded so that games may use a Timer, System, or other
     * basis for time.
     * 
     * @return time received by server
     */
    public int getTimeReceived () {
        return myTimeReceivedByServer;
    }

    @Override
    public boolean equals (Object object) {
        if (object == null || !(object instanceof Message)) { 
            return false; 
        }
        Message message = (Message) object;
        return getTimeSent() != message.getTimeSent();
    }

    @Override
    public int hashCode () {
        return myTimeSent * 200 - 13;
    }

    @Override
    public int compareTo (Message message) {
        if (message != null && message.getTimeReceived() != DEFAULT_VALUE &&
            getTimeReceived() != DEFAULT_VALUE) { 
            return message.getTimeReceived() - getTimeReceived(); 
        }
        return message.getTimeSent() - getTimeSent();
    }

}
