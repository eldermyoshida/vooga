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
    private CharacterObject myOwner;
    private List<Effect> myEffects;
    private int myPower;   
    private int mySpeed;
    private int myDirection; 
    private ObjectLoader myLoader;
    private UpdatableLocation myUpdatableLocation;  
    private long myInstanceId;
    private Pixmap myImage;
    private Location myCenter;
    private Dimension mySize;

    
    /**
     * Constructs an AttackObject with the given owner.
     * 
     * Will update to use ObjectLoader.
     */
    public AttackObject(long instanceId, int objectId, UpdatableLocation center) {
    	super();
        myEffects = new ArrayList<Effect>();
        myCounter = new Counter();
        myUpdatableLocation=center; 
    }
    
    public AttackObject (AttackObject attack, UpdatableLocation center){
    	super(attack.getInstanceId());
    	try {
			attack.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
    	myUpdatableLocation=center;
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
    public CharacterObject getOwner(){
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

}
