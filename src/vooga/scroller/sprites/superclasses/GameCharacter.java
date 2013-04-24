package vooga.scroller.sprites.superclasses;

import java.awt.Dimension;
import util.Location;
import util.Vector;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.util.Sprite;

/**
 * TODO: rewrite this.
 * This is the superclass for all sprites a game designer creates 
 * that interact in the game as living things. Critical in this class is the abstract getMovement() method 
 * that this superclass forces its subclasses to implement. This class also 
 * contains a bunch of helper methods pertaining to Velocity / Movement that 
 * many NonStaticEntities may find useful.  
 * <br>
 * <br>
 * Every NonStaticEntity has a default speed that is defaulted to (0, 45). However,
 * this will most definitely be by the NonStaticEntity. 
 * 
 * @author Jay Wang
 *
 */
public abstract class GameCharacter extends Sprite {

    /**
     * Default speed of a game character.
     */
    public static Vector DEFAULT_SPEED = new Vector(0, 45);
    
    private int myHealth;
    private int myDamage;
    private Locatable myTarget;
    
    /**
     * Builds a new GameCharacter that interacts with other game characters in the game.
     * 
     * @param image is the view of the character.
     * @param center is the initial location of the character.
     * @param size is the dimensions of the character.
     * @param health is the initial health of the character.
     * @param damage is the initial damage of the character.
     */
    public GameCharacter (ISpriteView image, Location center, Dimension size, int health, int damage) {
        super(image, center, size);
        myHealth = health;
        myDamage = damage;
    }

    public void update (double elapsedTime, Dimension bounds) {
        super.update(elapsedTime, bounds);
        if(myHealth <= 0){
            handleDeath();
        }
    }
    
    /**
     * This sprite takes damage from its health.
     * 
     * @param damage is the value that this looses from its health.
     */
    public void takeHit(int damage) {
        myHealth -= damage;
    }

    /**
     * Gives the value that an attack of this character will give.
     * 
     * @return The value of the sprite's hit.
     */
    public int getHit () {
        return myDamage;
    }
    
    /**
     * Gives this characters current health.
     * 
     * @return An integer represeting this character's current health.
     */
    public int getHealth() {
        return myHealth;
    }
    
    /**
     * Sets the health of this character.
     * 
     * @param health value for this character.
     */
    public void setHealth(int health) {
        myHealth = health;
    }
    
    /**
     * Gives a target sprite for this to target.
     * @param targetSprite is the sprite that this will target.
     */
    public void addTarget(Locatable targetSprite) {
        myTarget = targetSprite;
    }
    
    /**
     * This defines where this sprite is targeting, if it is at all targeting.
     * @return
     */
    public Locatable getLocatable() {
        return myTarget;
    }
    
    /**
     * Defines how to handle the death of this character.
     */
    public abstract void handleDeath();
    
}
