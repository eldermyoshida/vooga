package vooga.scroller.level_management;

/**
 * Interface that acts as a door between certain defined locations within levels.
 * 
 * @author Scott Valentine
 *
 */
public interface IDoor {

    /**
     * Sets the start position that this door will point to.
     * 
     * @param start is the StartPoint sprite where the player will start playing.
     */
    public void setNextStartPoint(StartPoint start);
    
    /**
     * Gives the current StartPoint that this IDoor points to.
     * 
     * @return The StartPoint to which this will take the player.
     */
    public StartPoint getNextStartPoint();
        
    /**
     * Takes the player to the next start point. 
     */
    public void goToNextStartPoint();
    
}
