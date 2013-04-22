package vooga.scroller.level_management;

import java.awt.Dimension;
import util.Location;
import vooga.scroller.level_editor.Level;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.sprites.superclasses.StaticEntity;
import vooga.scroller.util.IGameComponent;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;
import vooga.scroller.sprites.interfaces.ILevelPortal;;

/**
 * Acts as a portal between different levels and differnent positions. This can be used to change
 * player position inside of a level or take the player to a whole different level.
 * 
 * @author Scott Valentine
 *
 */
public class LevelPortal extends Sprite implements ILevelPortal, IDoor {

    private static final Dimension DEFAULT_SIZE = new Dimension(50, 50);
    private static final Location DEFAULT_LOCATION = new Location (0,0);
    private static Pixmap DEFAULT_IMG = new Pixmap("portal.png");
    private IGameComponent myNextLevel;
    private LevelManager myLevelManager;
    
    public LevelPortal () {
        this(DEFAULT_LOCATION);
    }
    
    public LevelPortal (Location center) {
        super(DEFAULT_IMG, center, DEFAULT_SIZE, new Integer(1), new Integer(0));
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
