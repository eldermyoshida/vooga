package vooga.scroller.level_editor.level_state;

import java.awt.Dimension;
import java.awt.Graphics2D;
import vooga.scroller.level_management.SpriteManager;
import vooga.scroller.sprites.state.State;
import vooga.scroller.view.GameView;

/**
 * Default State for a level.
 * 
 * @author Scott Valentine
 *
 */
public class DefaultState implements State {

    private SpriteManager mySpriteManager;
    private GameView myGameView;
    
    public DefaultState(SpriteManager spriteManager, GameView gameView){
        mySpriteManager = spriteManager;
        myGameView = gameView;
    }
    
    @Override
    public void update (double elapsedTime, Dimension bounds) {
        mySpriteManager.updateSprites(elapsedTime, bounds, myGameView);
    }

    @Override
    public void activate () {
        // TODO Auto-generated method stub

    }

    @Override
    public void deactivate () {
        // TODO Auto-generated method stub

    }

    @Override
    public void paint (Graphics2D pen) {
        mySpriteManager.paint(pen);
    }

}
