package vooga.fighter.objects;

import java.util.List;
import vooga.fighter.input.Input;
import vooga.fighter.objects.utils.Counter;
import vooga.fighter.objects.utils.Effect;
import vooga.fighter.objects.utils.Health;

/**
 * Represents a character being controlled by a player, whether that be a human
 * on the keyboard, a human over a network, an AI system, or something else.
 * 
 * This differs from CharacterObject in that CharacterObject holds the parameters
 * of different characters and the rules they operate by, whereas a Player object
 * corresponds to a character being controlled in the game. Things such as input
 * listeners and game state variables corresponding to the level in progress go here.
 * 
 * @author james, alanni
 *
 */
public class Player {

    private Health myHealth;
    private Input myInput;
    private List<Effect> myEffects;    
    
    /**
     * Constructs a new player object.
     * 
     * Note: Will be updated to use object loader.
     */
    public Player(Input input) {
        myInput = input;
        myHealth = new Health();
    }
    
    /**
     * Returns the health of the player.
     */
    public Health getHealth(){
        return myHealth;
    }
    
    /**
     * Changes the player's health by a given amount. Positive input raises it, and
     * negative input decreases it. Returns health remaining.
     */
    public int changeHealth(int amount) {
        return myHealth.changeHealth(amount);
    }    
    
    public void update() {

    }
        
    /**
     * We will insert methods to check rules for actions, as well as handling raw input.
     */
    
}
