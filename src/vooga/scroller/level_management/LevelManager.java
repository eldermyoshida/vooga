package vooga.scroller.level_management;

import java.util.Map;
import util.input.Input;
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

    private static final int DEFAULT_START_LEVEL_ID = 0;
    
    private Input myInput;
    private Map<Integer,Level> myLevels;
    private Level myCurrentLevel;
    
        
    /**
     * Creates a new level manager based on the view used by individual levels.
     * @param view to be used in constructing individual levels.
     */
    public LevelManager(ScrollingManager myScrollingManager, View view) {        
        LevelFactory lf = new LevelFactory(this);
        myLevels = lf.generateLevels(myScrollingManager, view);        
        myCurrentLevel = myLevels.get(DEFAULT_START_LEVEL_ID);         
        myInput = new Input(myCurrentLevel.getInputPath(), view);
        myCurrentLevel.addInputListeners(myInput);
    }
    
    /**
     * Gives the current level.
     * 
     * @return The current level
     */
    public Level currentLevel() {
        return myCurrentLevel;
    }
    
    /**
     * Sets the current level to the specified ID.
     * 
     * @param id of the level to become the current level.
     */
    public void setCurrentLevel(int id) {
        myCurrentLevel.removeInputListeners(myInput);
        Player p = myCurrentLevel.getPlayer();
        myCurrentLevel = myLevels.get(id);
        myCurrentLevel.addPlayer(p);
        myInput.overrideSettings(myCurrentLevel.getInputPath());
    }
}

