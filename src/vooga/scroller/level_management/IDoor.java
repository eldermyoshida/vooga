package vooga.scroller.level_management;

import util.Location;
import vooga.scroller.level_editor.Level;
import vooga.scroller.level_editor.exceptions.LevelEditorException;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.IGameComponent;

/**
 * Interface that acts as a door between certain defined locations within levels.
 * 
 * @author Scott Valentine
 *
 */
public interface IDoor {

    //TODO: find way to handle all error strings
    public static final String UNDEFINED_EXIT_POINT_MESSAGE = "Flag's exit point is undefined";


    public void setNextLevel (IGameComponent level);


    public IGameComponent getNextLevel();
    
    public void setManager(LevelManager lm);
        
    /**
     * Takes the player to the next start point. 
     */
    public void goToNextLevel(Player player);
    
}
