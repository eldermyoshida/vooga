package vooga.scroller.level_management;

import java.awt.Dimension;
import util.Location;
import vooga.scroller.sprites.interfaces.IDoor;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.IGameComponent;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;;

/**
 * Acts as a portal between different levels and differnent positions. This can be used to change
 * player position inside of a level or take the player to a whole different level.
 * 
 * @author Scott Valentine
 *
 */
public class ExamplePortal extends Sprite implements IDoor {

    private static final String DEFAULT_FILENAME = "portal.png";
    private static final String DEFAULT_PATH = "/vooga/scroller/images/";
    private static final Dimension DEFAULT_SIZE = new Dimension(50, 50);
    private static final Location DEFAULT_LOCATION = new Location (0,0);
    private static Pixmap DEFAULT_IMG = new Pixmap(DEFAULT_PATH,DEFAULT_FILENAME);
    private IGameComponent myNextLevel;
    private LevelManager myLevelManager;
    
    public ExamplePortal () {
        this(DEFAULT_LOCATION);
    }
    
    public ExamplePortal (Location center) {
        super(DEFAULT_IMG, center, DEFAULT_SIZE);
    }


    @Override
    public void goToNextLevel (Player player) {      
        // TODO: this can be where animations or cutscreens are played?
        // This could also be done in the level manager.
        
        myLevelManager.setCurrentLevel(myNextLevel);
        myLevelManager.getCurrentLevel().addPlayer(player);     
    }

    @Override
    public void setNextLevel (IGameComponent level) {
        myNextLevel = level;
    }

    @Override
    public IGameComponent getNextLevel () {
        return myNextLevel;
    }

    @Override
    public void setManager (LevelManager lm) {
        myLevelManager = lm;
    }


}
