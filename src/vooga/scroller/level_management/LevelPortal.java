package vooga.scroller.level_management;

import java.awt.Dimension;
import util.Location;
import vooga.scroller.level_editor.Level;
import vooga.scroller.level_editor.exceptions.LevelEditorException;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.sprites.superclasses.StaticEntity;
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

    private static Pixmap DEFAULT_IMG = 
            new Pixmap("portal.png");
    private StartPoint myExit;
    private Level myLevel;
    private LevelManager myLevelManager;
    
    public LevelPortal (Level l, Location center, LevelManager lm) {
        this(l, center);
        setManager(lm);
    }
    
    public void setManager(LevelManager lm) {
        myLevelManager = lm;
    }
    
    public Level getLevel() {
        return myLevel;
    }


    public LevelPortal (Level l, Location center) {
        super(DEFAULT_IMG, center, 
              new Dimension(50, 50));
        myLevel = l;
    }


    @Override
    public void setNextStartPoint (StartPoint start) {
        myLevelManager.put(this, start);
        myExit = myLevelManager.get(this);
    }

    @Override
    public StartPoint getNextStartPoint () throws LevelEditorException { 
        myExit = myLevelManager.get(this);
        if( myExit == null) {
            throw new LevelEditorException(IDoor.UNDEFINED_EXIT_POINT_MESSAGE);
        }        
        return myExit;
    }

    @Override
    public void goToNextStartPoint (Player player) {      
        
        // TODO: this can be where animations or cutscreens are played?
        // This could also be done in the level manager.
               
        StartPoint s = myLevelManager.get(this);
        
        myLevelManager.setCurrentLevel(s.getLevel());
        myLevelManager.currentLevel().addPlayer(player);
        
        player.setCenter(s.getStartLocation().x, s.getStartLocation().y);       
    }


    @Override
    public LevelPortal getLevelPortal () {
        return this;
    }

}
