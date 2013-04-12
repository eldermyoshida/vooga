
package vooga.scroller.level_management;

import java.util.List;
import vooga.scroller.util.Location;
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

    private static final int DEFAULT_START_INDEX = 0;
    private List<Level> myLevels;
    private int myIndex;    
    
    /**
     * Creates a new level manager based on the view used by individual levels.
     * @param view to be used in constructing individual levels.
     */
    public LevelManager(ScrollingManager myScrollingManager, View view) {
        myIndex = DEFAULT_START_INDEX;
        LevelFactory lf = new LevelFactory();
        myLevels = lf.generateLevels(myScrollingManager, view);
    }
    
    /**
     * Gives the current level.
     * 
     * @return The current level
     */
    public Level currentLevel() {
        return myLevels.get(myIndex);
    }
    
    public void setCurrentLevel(int id) {
        myIndex = id;
    }
    
    /**
     * Starts game-play in the current level.
     * 
     * @param player is the player that will play the current level.
     */
    public void startLevel(Player player, Location location){
        myLevels.get(myIndex).addSprite(player);
    }
}

