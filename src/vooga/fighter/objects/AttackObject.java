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
    private CharacterObject myOwner;
    private List<Effect> myEffects;
    private int myAttackPower;      
    
    /**
     * Constructs an AttackObject with the given owner.
     * 
     * Will update to use ObjectLoader.
     */
    public AttackObject(Pixmap image, Location center, Dimension size, CharacterObject owner, int power, int attackSpeed) {
    	super(image, center, size);
        myOwner = owner;
        myEffects = new ArrayList<Effect>();
        //add effects to myEffects list
        myCounter = new Counter();
        myAttackPower = power; 
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
     * Gets the character who created the attack
     */
    public CharacterObject getOwner(){
    	return myOwner; 
    }
    
    /**
     * Inflicts damage upon a target player.
     */
    public int inflictDamage(CharacterObject target){
    	return target.changeHealth(-myAttackPower);
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

}
