package vooga.scroller.level_management;

import java.awt.Dimension;
import util.Location;
import vooga.scroller.level_editor.exceptions.LevelEditorException;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.util.Sprite;

public class LevelPortal extends Sprite implements IDoor {

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
        int nextLevelID = myExit.getLevelId();        
        myLevelManager.setCurrentLevel(nextLevelID);
        
        Location startPosition = myExit.getStartLocation();
        
        myLevelManager.currentLevel().addPlayer(player);
        
        player.setCenter(startPosition.x, startPosition.y);
        // TODO: use the start position to specify where in the level the player goes.
        // NOTE: we need to be able to add the player arbitrarily to the level.
        
    }

}
