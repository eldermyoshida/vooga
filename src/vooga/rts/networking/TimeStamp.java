package vooga.rts.networking;

import java.io.Serializable;

/**
 * Represents a timeStamp that will be sent across the network
 * @author Henrique Moraes
 *
 */
public class TimeStamp implements Comparable<TimeStamp>{
    private long myInitialTime;
    private int DEFAULT_VALUE = -1;
    private long myFinalTime;
    public TimeStamp(){
        resetStamp();
    }
    
    /**
     * sets the received message time for this stamp
     * @return difference in elapsed time since this stamp was created
     */
    public long stamp(){
        myFinalTime = System.nanoTime();
        return getDifference();
    }
    
    /**
     * @return difference in elapsed time since this stamp was created
     */
    public long getDifference(){
        if(myInitialTime > myFinalTime)
            myFinalTime = System.nanoTime();
        return myFinalTime - myInitialTime;
    }
    
    /**
     * Resets this stamp setting the initial time as the current one
     */
    public void resetStamp(){
        myInitialTime = System.nanoTime();
        myFinalTime = DEFAULT_VALUE;
    } 
    
    public long getTimeSent () {
        return myInitialTime;
    }
    
    public long getTimeReceived () {
        return myFinalTime;
    }
    
    @Override
    public boolean equals(Object object) {
        if(object == null) {
            return false;
        }
        if (!(object instanceof TimeStamp)) {
            return false;
        } 
        TimeStamp message = (TimeStamp) object;
        return (getTimeSent() != message.getTimeSent());
    }
    
    @Override
    public int compareTo (TimeStamp message) {
        if(message != null && message.getTimeReceived() != DEFAULT_VALUE && getTimeReceived() != DEFAULT_VALUE) {
            return (int) ((int) getTimeReceived() - message.getTimeReceived());
        }
        return (int) ((int) getTimeSent() - message.getTimeSent());
    }
}
