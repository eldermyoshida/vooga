package vooga.fighter.objects;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import vooga.fighter.input.AlertObject;
import vooga.fighter.input.Input;
import vooga.fighter.input.InputClassTarget;
import vooga.fighter.input.InputMethodTarget;
import vooga.fighter.objects.utils.Health;
import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Vector;


/**
 * Represents a character in the game. Only character data is stored and used here.
 * Data regarding a specific play-through such as current health are not stored here.
 * 
 * @author alanni, james
 * 
 */
public class CharacterObject extends MoveableGameObject {

    private Map<String,Integer> myProperties;    
    private Map<String,AttackObject> myAttacks;

    /**
     * Constructs a new CharacterObject.
     * 
     * Note: Dayvid once the object loader is functional we will replace this
     * constructor to take in just an ID, then we will load parameters from XML.
     */
    public CharacterObject (Pixmap image, Location center, Dimension size, int speed, Input input) {
        super(image, center, size);
        myProperties = new HashMap<String,Integer>();
        myAttacks = new HashMap<String,AttackObject>();
    }

    /**
     * Returns a property for this character. Returns -1 if property name not found.
     */
    public int getProperty(String key) {
        if (myProperties.containsKey(key)) {
            return myProperties.get(key);
        } else {
            return -1;
        }
    }

    /**
     * Creates and returns an attack object based on a given identifier.
     * 
     * Note: For now just using String to represent attack types, but this is obviously
     * subject to change.
     */
    private AttackObject createAttack(String key) {
        //TODO: implement this
        return null;
    }

}
