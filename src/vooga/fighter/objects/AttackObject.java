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
 * @author james
 *  
 */
public class AttackObject {

    private Counter myCounter;
    private Player myOwner;
    private List<Effect> myEffects;
    
    /**
     * Constructs an AttackObject with the given Player owner.
     */
    public AttackObject(Player owner) {
        myOwner = owner;
        myEffects = new ArrayList<Effect>();
        //add effects to myEffects list
        myCounter = new Counter();
        //myCounter.setCounter(count);
    }
    
}
