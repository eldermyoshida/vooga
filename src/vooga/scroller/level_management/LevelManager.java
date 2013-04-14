
package vooga.scroller.level_management;

import java.util.Map;
import util.Location;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.view.View;
import vooga.scroller.level_editor.Level;

/**
 * Manages the flow and order of levels in gameplay.
 * 
 * @author Scott Valentine
 *
 */
public class LevelManager {

    private Map<Integer,Level> myLevels;
    private int myLevelID;    
    
    /**
     * Creates a new level manager based on the view used by individual levels.
     * @param view to be used in constructing individual levels.
     */
    public LevelManager(ScrollingManager myScrollingManager, View view) {
        
        LevelFactory lf = new LevelFactory(this);
        myLevels = lf.generateLevels(myScrollingManager, view);
        
        // UGLY but works
        myLevelID = myLevels.keySet().iterator().next();
    }
    
    /**
     * Gives the current level.
     * 
     * @return The current level
     */
    public Level currentLevel() {
        return myLevels.get(myLevelID);
    }
    
    public void setCurrentLevel(int id) {
        myLevelID = id;
    }
    
    /**
     * Starts game-play in the current level.
     * 
     * @param player is the player that will play the current level.
     */
    public void startLevel(Player player, Location location){
        myLevels.get(myLevelID).addSprite(player);
    }
}

