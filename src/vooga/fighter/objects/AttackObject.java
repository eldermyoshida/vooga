package vooga.fighter.objects;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import vooga.fighter.objects.utils.Counter;
import vooga.fighter.objects.utils.Effect;
import vooga.fighter.objects.utils.UpdatableLocation;
import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Vector;

/**
 * Object that can inflict damage on other moveable game objects
 * 
 * @author james, alanni
 *  
 */
public class AttackObject extends GameObject{

    private Counter myCounter;
    private GameObject myOwner;
    private List<Effect> myEffects;
    private int myPower;   
    private int mySpeed;
    private int myDirection;   
    
    /**
     * Constructs an AttackObject with the given owner.
     * 
     * Will update to use ObjectLoader.
     */
    public AttackObject(long instanceId, int objectId) {
    	super();
        myEffects = new ArrayList<Effect>();
        myCounter = new Counter();
    }
    
    public AttackObject (AttackObject attack, UpdatableLocation center){
    	super();
        try {
            attack.clone();
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    	setLocation(center);
    }
    
    /**
     * Updates the attack object
     */
    public void update(){
    	super.update();
    }
    /**
     * Adds an effect to myEffects
     */
    public void addEffect(Effect toAdd){
    	myEffects.add(toAdd);
    }
    
    /**
     * 
     * @return list of effects
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
    	return target.changeHealth(-myPower);
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
     * Sets the amount of time left in attack to zero
     */
    public void endCounter(){
    	myCounter.setCounter(0); 
    }
    @Override
    public void applyCollideEffect(GameObject o){
    	if (this.compare(o)>=0){
	    	if (o instanceof CharacterObject){
	    		inflictDamage((CharacterObject) o);
	    		addTargetForEffects((CharacterObject) o);
	    	}
	    	else if (o instanceof AttackObject){
	    		
	    			((AttackObject) o).endCounter();
	    		
	    	}
    	}
    }

}
