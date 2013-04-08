package vooga.fighter.objects;

import vooga.fighter.util.Location;
import vooga.fighter.util.Pixmap;
import vooga.fighter.util.Vector; 


public class CharacterObject extends MoveableGameObject {    
    
    private int myDefaultSpeed;
    
    public CharacterObject(Pixmap image, Location center, int defaultSpeed) {
        super(image, center);
        myDefaultSpeed = defaultSpeed;
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
    public void moveLeft() {
        Vector left = new Vector(Vector.DEGREES_LEFT, myDefaultSpeed);
        super.translate(left);
    }
    
    /**
     * Moves the character right.
     */
    public void moveRight() {
        Vector right = new Vector(Vector.DEGREES_RIGHT, myDefaultSpeed);
        super.translate(right);
    }
    
    /**
     * Moves the character up.
     */
    public void moveUp() {
        Vector up = new Vector(Vector.DEGREES_UP, myDefaultSpeed);
        super.translate(up);
    }
    
    /**
     * Moves the character down.
     */
    public void moveDown() {
        Vector down = new Vector(Vector.DEGREES_DOWN, myDefaultSpeed);
        super.translate(down);
    }

}
