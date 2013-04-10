package vooga.rts.networking;

import java.io.Serializable;

/**
 * Represents a timeStamp that will be sent across the network. If no parameters
 * are given, it automatically uses the current time in the system as an initial 
 * time
 * @author Henrique Moraes
 *
 */
public class TimeStamp implements Comparable<TimeStamp>{
    public static final int TO_MILLISEC = 1000000;
    private long myInitialTime;
    private int DEFAULT_VALUE = -1;
    private long myFinalTime;
    
    /**
     * Creates a timestamp object with the current time as the initial time
     */
    public TimeStamp(){
        resetStamp();
    }
    
    /**
     * Creates a timestamp object with the given initial time
     * @param time
     */
    public TimeStamp(long time){
        myInitialTime = time;
        myFinalTime = DEFAULT_VALUE;
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
     * in milliseconds
     */
    public long getDifference(){
        if(myInitialTime > myFinalTime)
            myFinalTime = System.currentTimeMillis();
        return myFinalTime - myInitialTime;
    }
    
    /**
     * Resets this stamp setting the initial time as the current one
     */
    public void resetStamp(){
        myInitialTime = System.currentTimeMillis();
        myFinalTime = DEFAULT_VALUE;
    } 
    
    /**
     * 
     * @return time message was created or reset in milliseconds
     */
    public long getInitialTime () {
        return myInitialTime;
    }
    
    /**
     * 
     * @return time this message was stamped in milliseconds
     */
    public long getFinalTime () {
        return myFinalTime;
    }
    
    /**
     * @param time value to be converted
     * @return time in nanoseconds converted to milliseconds
     */
    private long toMilliseconds(long time){
        return time/TO_MILLISEC;
    }
    
    @Override
    public int hashCode () {
        return (int) (myInitialTime * 200 - 13);
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
        return (getInitialTime() != message.getInitialTime());
    }
    
    @Override
    public int compareTo (TimeStamp message) {
        if(message != null && message.getFinalTime() != DEFAULT_VALUE && getFinalTime() != DEFAULT_VALUE) {
            return (int) (getInitialTime() - message.getInitialTime());
        }
        return (int) (getInitialTime() - message.getInitialTime());
    }
}
