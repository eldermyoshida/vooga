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
    private TimeStamp myTimeStamp;

    /**
     * Constructor for this class
     * Creates a timestamp for this message with the given time 
     * as the initial time
     */
    public Message (int timeSent) {
        myTimeStamp = new TimeStamp(timeSent);
    }
    
    /**
     * Constructor for this class
     * Creates a timestamp for this message with the current system time 
     * as the initial time
     */
    public Message () {
        myTimeStamp = new TimeStamp();
    }
    
    /**
     * 
     * @return this message's timestamp
     */
    public TimeStamp getTimeStamp(){
        return myTimeStamp;
    }

    /**
     * Call this method to reset the initial time to the current one and 
     * the final time to the default
     */
    public void resetTime () {
        myTimeStamp.resetStamp();
    }
    
    /**
     * Call this method to mark the time received (final time)
     */
    public void stampTime(){
        myTimeStamp.stamp();
    }

    /**
     * 
     * @return time message was created or reset in milliseconds
     */
    public long getInitialTime () {
        return myTimeStamp.getInitialTime();
    }

    /**
     * 
     * @return time this message was stamped in milliseconds
     */
    public long getFinalTime () {
        return myTimeStamp.getFinalTime();
    }

    @Override
    public boolean equals (Object object) {
        if(object == null) {
            return false;
        }
        if (!(object instanceof Message)) {
            return false;
        }
        Message m = (Message) object;
        return myTimeStamp.equals(m.getTimeStamp());
    }

    @Override
    public int hashCode () {
        return myTimeStamp.hashCode();
    }

    /**
     * Compares based on timestamps
     */
    @Override
    public int compareTo (Message message) {
        return myTimeStamp.compareTo(message.getTimeStamp());
    }

}
