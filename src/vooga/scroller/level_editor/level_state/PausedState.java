package vooga.scroller.level_editor.level_state;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import util.Location;
import util.Text;
import vooga.scroller.level_editor.LevelState;
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
public class PausedState implements LevelState {

    
    
    private static final String DEFAULT_PAUSED_MESSAGE = "PAUSED";
    private static final Color DEFAULT_COLOR = Color.BLACK;
    private static final Location DEFAULT_LOCATION = new Location(100,100);
    
    private Text myMessage;
    private Location myTextLocation;
    
    
    public PausedState(){
        myMessage = new Text(DEFAULT_PAUSED_MESSAGE);
        myTextLocation = DEFAULT_LOCATION;
    }


    @Override
    public void paint (Graphics2D pen) {
        // paints only the paused header so the user knows that the game is paused
        myMessage.paint(pen, myTextLocation, DEFAULT_COLOR);
    }


    @Override
    public void update (double elapsedTime, Dimension bounds, GameView gameView) {
        // TODO Auto-generated method stub
        myTextLocation = new Location(gameView.getWidth()/2, gameView.getHeight()/2);
        
    }

}
