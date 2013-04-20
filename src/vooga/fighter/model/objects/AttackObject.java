package vooga.fighter.model.objects;

import java.util.ArrayList;
import java.util.List;

import util.Location;
import vooga.fighter.model.ModelConstants;
import vooga.fighter.model.utils.Counter;
import vooga.fighter.model.utils.Effect;
import vooga.fighter.model.utils.UpdatableLocation;

/**
 * Object that can inflict damage on other moveable game objects
 * 
 * @author James Wei, alanni, David Le
 *  
 */
public class AttackObject extends GameObject{

    private Counter myCounter;
    private GameObject myOwner;
    private List<Effect> myEffects;
    
    /**
     * Constructs an AttackObject with the given owner.
     * 
     * Will update to use ObjectLoader.
     */
    public AttackObject() {
    	super();
        myEffects = new ArrayList<Effect>();
        myCounter = new Counter();
    }
    
    public AttackObject (AttackObject other, UpdatableLocation center){
    	super();
    	addProperty(ModelConstants.ATTACK_PROPERTY_SPEED, other.getProperty(ModelConstants.ATTACK_PROPERTY_SPEED));
    	addProperty(ModelConstants.ATTACK_PROPERTY_DIRECTION, other.getProperty(ModelConstants.ATTACK_PROPERTY_DIRECTION));
    	addProperty(ModelConstants.ATTACK_PROPERTY_POWER, other.getProperty(ModelConstants.ATTACK_PROPERTY_POWER));
        this.myEffects = other.myEffects;
        this.myOwner = other.myOwner;
        this.myCounter = new Counter(other.myCounter);   
    	setLocation(center);
    }
    
    /**
     * Move the attack object to the position of its owner.
     */
    public void moveToOwner() {
        UpdatableLocation copyLocation = myOwner.getLocation();
        UpdatableLocation myLocation = getLocation();
        Location newLocation = new Location(copyLocation.getLocation());
        myLocation.setLocation(newLocation);
    }
    
    /**
     * Updates the attack object.
     */
    public void update(){
    	super.update();
    	myCounter.decrementCounter();
    }
    /**
     * Adds an effect to myEffects
     */
    public void addEffect(Effect toAdd){
    	myEffects.add(toAdd);
    }
    
    /**
     * Returns the list of effects carried by this object.
     */
    public List<Effect> getEffects(){
    	return myEffects;
    }
    
    /**
     * Gets the character who created the attack
     */
    public GameObject getOwner(){
    	return myOwner; 
    }
    
    /**
     * Inflicts damage upon a target player.
     */
    public int inflictDamage(CharacterObject target){
        int damage = getProperty(ModelConstants.ATTACK_PROPERTY_POWER);
    	return target.changeHealth(-damage);
    }
    
    /**
     * Designates a character as a target of this attack's effects.
     */
    public void addTargetForEffects(CharacterObject target){
        for (Effect effect : myEffects) {
            Effect copyOfEffect = effect.getCloneOfEffect();
            target.addActiveEffect(copyOfEffect);
        }
    }    
    
    
    /**
     * Sets the counter to the current amount 
     */
    public void setCounter(int amount){
    	myCounter.setCounter(amount); 
    }
    
    /**
     * Returns true if this attack object has expired.
     */
    public boolean shouldBeRemoved() {
        return !myCounter.hasCountRemaining();
    }
    
    /**
     * Dispatches a colliding object to allow for proper collision handling. 
     */
    public void dispatchCollision(GameObject other) {
        other.handleCollision(this);
    }
    
    /**
     * Collision with another CharacterObject.
     */
    public void handleCollision(CharacterObject other) {
        System.out.println("AttackObject handleCollision : Attack collided with character");
    }
    
    /**
     * Collision with an AttackObject.
     */
    public void handleCollision(AttackObject other) {
        System.out.println("AttackObject handleCollision : Attack collided with attack");
    }
    
    /**
     * Collision with an EnvironmentObject.
     */
    public void handleCollision(EnvironmentObject other) {
        System.out.println("AttackObject handleCollision : Attack collided with environment");
    }

}
