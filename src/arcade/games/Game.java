package arcade.games;
import java.awt.Component;


/**
 * All genre writers should extend this class to write their games, so that
 * it can be played in the Arcade.
 * 
 * @author ArcadeTeam
 */
public abstract class Game{
    
    private ArcadeInteraction myArcade;
    
    /**
     * Constructs a game with the arcade interface and the user game data
     * 
     * @param arcade ArcadeInteraction
     */
    public Game(ArcadeInteraction arcade) {
        myArcade = arcade;
    }    
    
    
    /**
     * This method will be called by the arcade if the user has never played
     * the game before, and this data will be associated with the user currently
     * playing.  
     * @return the specific subclass of UserGameData for each game.
     */
    public abstract UserGameData generateNewProfile();
    
    /**
     * Set up a view component that the Game will be displayed on and return 
     * it to the arcade.  This view component should probably be very similar 
     * to a Canvas in previous projects, but will be left to the Game writers 
     * to create so they can customize it as they wish.
     * 
     * 
     * @return your game's view
     */
    public abstract Component createView();
    
    /**
     * starts the game (should probably start displaying the splash screen or
     * title screen).
     *
     */
    public abstract void run ();
    
    /**
     * The ArcadeInteraction is the access the game has  
     * to arcade elements (e.g. user name, user's saved game data)
     *
     */
    protected ArcadeInteraction getArcade() {
        return myArcade;
    }

}
