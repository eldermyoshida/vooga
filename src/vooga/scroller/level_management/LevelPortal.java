package vooga.scroller.level_management;

import java.awt.Dimension;
import util.Location;
import vooga.scroller.level_editor.exceptions.LevelEditorException;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.sprites.superclasses.StaticEntity;
import vooga.scroller.util.ISpriteView;
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

    private StartPoint myExit;
    private LevelManager myLevelManager;
    
    
    public LevelPortal (ISpriteView image, Location center, Dimension size, StartPoint exit, LevelManager lm) {
        super(image, center, size);
        myLevelManager = lm;
        myExit = exit;
    }


    @Override
    public void setNextStartPoint (StartPoint start) {
        myExit = start; 
    }

    @Override
    public StartPoint getNextStartPoint () throws LevelEditorException {        
        if( myExit == null) {
            throw new LevelEditorException(IDoor.UNDEFINED_EXIT_POINT_MESSAGE);
        }        
        return myExit;
    }

    @Override
    public void goToNextStartPoint (Player player) {      
        
        // TODO: this can be where animations or cutscreens are played?
        // This could also be done in the level manager.
        
        int nextLevelID = myExit.getLevelId();        
        myLevelManager.setCurrentLevel(nextLevelID);
        
        Location startPosition = myExit.getStartLocation();
        
        myLevelManager.currentLevel().addPlayer(player);
        
        player.setCenter(startPosition.x, startPosition.y);       
    }


    @Override
    public LevelPortal getLevelPortal () {
        return this;
    }

}
