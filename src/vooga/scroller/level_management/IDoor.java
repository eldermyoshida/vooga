package vooga.scroller.level_management;

import vooga.scroller.level_editor.exceptions.LevelEditorException;
import vooga.scroller.sprites.superclasses.Player;

/**
 * Interface that acts as a door between certain defined locations within levels.
 * 
 * @author Scott Valentine
 *
 */
public interface IDoor {

    //TODO: find way to handle all error strings
    public static final String UNDEFINED_EXIT_POINT_MESSAGE = "Flag's exit point is undefined";

    /**
     * Sets the start position that this door will point to.
     * 
     * @param start is the StartPoint sprite where the player will start playing.
     */
    public void setNextStartPoint(StartPoint start) ;
    
    /**
     * Gives the current StartPoint that this IDoor points to.
     * 
     * @return The StartPoint to which this will take the player.
     */
    public StartPoint getNextStartPoint() throws LevelEditorException;
        
    /**
     * Takes the player to the next start point. 
     */
    public void goToNextStartPoint(Player player);
    
}
