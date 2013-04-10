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
        
	private static final int DEFAULT_ATTACK_STRENGTH=5;
	private static final int DEFAULT_SPECIAL_ATTACK_STRENGTH=10;
	private static final int DEFAULT_SPEED=5; 
	private static final int DEFAULT_ATTACK_SPEED=20;
	
	private AttackObject myAttack; 
	private int myAttackPower;
	private int mySpecialAttackPower;
	private int myOriginalAttackPower;
	private int myOriginalSpecialAttackPower; 
	private int myAttackSpeed; 
    private int myOriginalSpeed;
    private Player myPlayer; 
    private Input myInput;
    private int mySpeed;
    
    /**
     * Constructs a new CharacterObject.
     * 
     * Note: Dayvid once the object loader is functional we will replace this
     * constructor to take in just an ID, then we will load parameters from XML.
     */
    public CharacterObject(Pixmap image, Location center, Dimension size, int speed, Input input) {
        super(image, center, size);
        myOriginalSpeed = speed;
        mySpeed= myOriginalSpeed; 
        myInput = input;
        myInput.addListenerTo(this);
    }        
    
    /**
     * Returns the speed of this character.
     */
    public int getSpeed() {
        return mySpeed;
    }    
    
    /**
     * Returns the player
     */
    private Player getPlayer(){
    	return myPlayer;
    }
    
    /**
     * Moves the character left.
     */
    @InputMethodTarget(name="left")
    public void moveLeft(AlertObject alObj) {
        Vector left = new Vector(Vector.DEGREES_LEFT, mySpeed);
        super.translate(left);
    }
    
    /**
     * Moves the character right.
     */
    @InputMethodTarget(name="right")
    public void moveRight(AlertObject alObj) {
        Vector right = new Vector(Vector.DEGREES_RIGHT, mySpeed);
        super.translate(right);
    }
    
    /**
     * Moves the character up.
     */
    @InputMethodTarget(name="up")
    public void moveUp(AlertObject alObj) {
        Vector up = new Vector(Vector.DEGREES_UP, mySpeed);
        super.translate(up);
    }
    
    /**
     * Moves the character down.
     */
    @InputMethodTarget(name="down")
    public void moveDown(AlertObject alObj) {
        Vector down = new Vector(Vector.DEGREES_DOWN, mySpeed);
        super.translate(down);
    }
    /**
     * Sets character speed to 0
     */
    public void freezeCharacter(){
    	mySpeed=0; 
    }
    
    /**
     * resets character speed
     */
    public void resetSpeed(){
    	mySpeed=myOriginalSpeed; 
    }
    
    /**
     * Creates an attack object
     */
    private void createAttack(){
    	myAttack=new AttackObject(null, null, null, myPlayer, myAttackPower, myAttackSpeed);
    }
    

}
