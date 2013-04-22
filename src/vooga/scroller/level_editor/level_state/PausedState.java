package vooga.scroller.level_editor.level_state;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import util.Location;
import util.Text;
import vooga.scroller.sprites.state.State;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.view.GameView;
/**
 * Represents the state where a level is paused. This turns off updates and paints of sprites
 * and turns off player-controlling inputs.
 * 
 * @author Scott Valentine
 *
 */
public class PausedState implements State {

    
    
    private static final String DEFAULT_PAUSED_MESSAGE = "PAUSED";
    private static final Color DEFAULT_COLOR = Color.BLACK;
    
    private Text myMessage;
    private GameView myGameView;
    
    
    public PausedState(GameView gameView){
        myMessage = new Text(DEFAULT_PAUSED_MESSAGE);
        myGameView = gameView;
    }
    
    
    @Override
    public void update (double elapsedTime, Dimension bounds) {
        // does nothing since the game is paused.
        // if you wanted, you could do something more interesting here.

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
        // paints only the paused header so the user knows that the game is paused
        Location screenCenter = new Location(myGameView.getWidth()/2, myGameView.getHeight()/2);
        myMessage.paint(pen, screenCenter, DEFAULT_COLOR);
    }

}
