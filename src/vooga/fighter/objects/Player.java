package vooga.fighter.objects;

import vooga.fighter.input.Input;
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
 * @author james
 *
 */
public class Player {

    private Health myHealth;
    private CharacterObject myCharacter;
    private Input myInput;
    
    /**
     * Constructs a new player object.
     * 
     * Note: Will be updated to use object loader.
     */
    public Player(CharacterObject character, Input input) {
        myCharacter = character;
        myInput = input;
        myHealth = new Health();
    }
    
    /**
     * We will insert methods to check rules for actions, as well as handling raw input.
     */
    
}
