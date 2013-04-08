package model;

import java.util.List;
import scrollingmanager.ScrollingManager;
import sprite_superclasses.Player;
import view.View;
import level_editor.Level;

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
    
    /**
     * Starts game-play in the current level.
     * 
     * @param player is the player that will play the current level.
     */
    public void startLevel(Player player){
        myLevels.get(myIndex).addSprite(player);
    }
}
