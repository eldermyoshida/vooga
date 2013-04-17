package vooga.fighter.model.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vooga.fighter.model.loaders.CharacterLoader;
import vooga.fighter.model.utils.Effect;
import vooga.fighter.model.utils.Health;
import vooga.fighter.model.utils.UpdatableLocation;
import util.Vector;


/**
 * Represents a character in the game, as well as the character's current state
 * in the given session.
 * 
 * @author alanni, james, David Le
 * 
 */
public class CharacterObject extends GameObject {

    private Map<String, AttackObject> myAttacks;
    private List<Effect> myActiveEffects;
    private Health myHealth;
    private int myLives;
    private UpdatableLocation myOriginalLocation; 
    private static final String DEFAULT_STATE="stand";

    /**
     * Constructs a new CharacterObject.
     */
    public CharacterObject(int objectId, UpdatableLocation center) {
        super();
        myAttacks = new HashMap<String, AttackObject>();
        myActiveEffects = new ArrayList<Effect>();
        myOriginalLocation=center; 
        setLoader(new CharacterLoader(objectId, this));
        spawnCharacter(); 
        setImageData();
    }

    /**
     * Updates the character for one game loop cycle. Applies movement from acceleration
     * forces acting on the character.
     */

    public void update() {
        super.update();
        if (getCurrentState().hasCompleted()) {
            setCurrentState("stand");
        }
        for (Effect effect : myActiveEffects) {
            effect.update();
        }
        if (!hasHealthRemaining()){
        	loseLife();
        	spawnCharacter(); 
        }
        if (!hasLivesRemaining()){
        	//to do remove character
        }
        
    }

    /**
     * Adds an effect to this character's list of active effects.
     */
    public void addActiveEffect(Effect effect) {
        effect.setOwner(this);
        myActiveEffects.add(effect);
    }

    /**
     * Removes an effect from this character's list of active effects.
     */
    public void removeActiveEffect(Effect effect) {
        myActiveEffects.remove(effect);
    }

    /**
     * Returns list of currently active effects on this character.
     */
    public List<Effect> getActiveEffects() {
        return myActiveEffects;
    }

    /**
     * Adds an AttackObject to the list of attacks available for this character.
     * Note that this attack will not be added to the list of game objects in a
     * level, thus it will not update and should be used solely for generating
     * other attack objects as needed. Overwrites any existing attack.
     */
    public void addAttack(String key, AttackObject object) {
        myAttacks.put(key, object);
    }

    /**
     * Creates and returns an attack object based on a given identifier. Returns null
     * if the specified attack does not exist.
     * 
     * Note: For now just using String to represent attack types, but this is obviously
     * subject to change.
     */
    public AttackObject createAttack(String key) {
        if (myAttacks.containsKey(key)) {
            return myAttacks.get(key);
        }
        else {
            return null;
        }
    }

    /**
     * Returns the health of the character.
     */
    public Health getHealth() {
        return myHealth;
    }

    /**
     * Returns whether or not the character has remaining health.
     */
    public boolean hasHealthRemaining() {
        return myHealth.hasHealthRemaining();
    }

    /**
     * Sets the health of the character
     */
    public void setHealth(int amount) {
        myHealth.setHealth(amount);
    }

    /**
     * Changes the player's health by a given amount. Positive input raises it, and
     * negative input decreases it. Returns health remaining.
     */
    public int changeHealth(int amount) {
        return myHealth.changeHealth(amount);
    }

    /**
     * Creates a new AttackObject by cloning the object identified by the given key
     * in the attacks map.
     */
    public void attack(String attack) {
        setCurrentState("weakPunch");
        if (myAttacks.containsKey(attack)) {
            new AttackObject(myAttacks.get(attack), getLocation());
        }
    }

    /**
     * Moves in given direction at speed of character
     */
    public void move(int direction) {
        setCurrentState("moveRight");
        getLocation().translate(new Vector(direction, getProperty("speed")));
    }

    /**
     * Will add jump method
     */
    public void jump() {        

    }
    
    /**
     * Increases the life count of the character by 1
     */
    public void addLife(){
    	myLives++;
    }
    
    /**
     * Decreases the number of lives of the character by 1
     */
    public void loseLife(){
    	myLives--; 
    }
    
    /**
     * Checks to see if character has more than one life left
     */
    public boolean hasLivesRemaining(){
    	return myLives>=0; 
    }
    
    /**
     * Sets character to original location
     */
    public void resetLocation(){
    	setLocation(myOriginalLocation);
    }
    
    /**
     * Sets the health to original amount
     */
    public void resetHealth(){
    	myHealth=new Health(); 
    }
    
    /**
     * Sets the state to original state 
     */
    public void resetState(){
        setCurrentState(DEFAULT_STATE); 
    }
    
    /**
     * Sets all of the properties to original settings
     */
    public void spawnCharacter(){
    	resetLocation();
    	resetHealth();
    	resetState(); 
    }
    
    public boolean shouldBeRemoved() {
        return false;
    }

}
