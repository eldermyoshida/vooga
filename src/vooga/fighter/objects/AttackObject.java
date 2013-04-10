package vooga.fighter.objects;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import vooga.fighter.objects.utils.Counter;
import vooga.fighter.objects.utils.Effect;
import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Vector;

/**
 * Object that can inflict damage on other moveable game objects
 * 
 * @author james, alanni
 *  
 */
public class AttackObject extends MoveableGameObject{

    private Counter myCounter;
    private Player myOwner;
    private List<Effect> myEffects;
    private int myAttackPower;  
    private int myVelocity; 
    private int myDirection; 
    
    
    /**
     * Constructs an AttackObject with the given Player owner.
     */
    public AttackObject(Pixmap image, Location center, Dimension size, Player owner, int power, int attackSpeed) {
    	super(image, center, size);
        myOwner = owner;
        myEffects = new ArrayList<Effect>();
        //add effects to myEffects list
        myCounter = new Counter();
        myAttackPower=power; 
        myVelocity=attackSpeed; 
        //myCounter.setCounter(count);
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
     * Gets the player who created the attack
     */
    public Player getOwner(){
    	return myOwner; 
    }
    
    /**
     * Inflicts damage upon a target player.
     */
    public int inflictDamage(Player o){
    	return o.changeHealth(-myAttackPower);
    }
    
    /**
     * Applies all effects to the target of the attack.
     */
    public void applyEffects(){
    	for (Effect e: myEffects){
    		e.applyEffect();
    	}
    }

}
