package vooga.fighter.objects;

import java.awt.Dimension;
import vooga.fighter.input.AlertObject;
import vooga.fighter.input.Input;
import vooga.fighter.input.InputClassTarget;
import vooga.fighter.input.InputMethodTarget;
import vooga.fighter.objects.utils.Health;
import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Vector; 


/**
 * Represents a character in the game.
 * 
 * @author alanni, james
 *
 */
@InputClassTarget
public class CharacterObject extends MoveableGameObject {    
        
    private int myDefaultSpeed;
    private Input myInput;
    
    /**
     * Constructs a new CharacterObject.
     * 
     * Note: Dayvid once the object loader is functional we will replace this
     * constructor to take in just an ID, then we will load parameters from XML.
     */
    public CharacterObject(Pixmap image, Location center, Dimension size, int defaultSpeed, Input input, Health health) {
        super(image, center, size, health);
        myDefaultSpeed = defaultSpeed;
        myInput = input;
        myInput.addListenerTo(this);
    }        
    
    /**
     * Returns the default speed of this character.
     */
    public int getDefaultSpeed() {
        return myDefaultSpeed;
    }    
    
    /**
     * Moves the character left.
     */
    @InputMethodTarget(name="left")
    public void moveLeft(AlertObject alObj) {
        Vector left = new Vector(Vector.DEGREES_LEFT, myDefaultSpeed);
        super.translate(left);
    }
    
    /**
     * Moves the character right.
     */
    @InputMethodTarget(name="right")
    public void moveRight(AlertObject alObj) {
        Vector right = new Vector(Vector.DEGREES_RIGHT, myDefaultSpeed);
        super.translate(right);
    }
    
    /**
     * Moves the character up.
     */
    @InputMethodTarget(name="up")
    public void moveUp(AlertObject alObj) {
        Vector up = new Vector(Vector.DEGREES_UP, myDefaultSpeed);
        super.translate(up);
    }
    
    /**
     * Moves the character down.
     */
    @InputMethodTarget(name="down")
    public void moveDown(AlertObject alObj) {
        Vector down = new Vector(Vector.DEGREES_DOWN, myDefaultSpeed);
        super.translate(down);
    }

}
