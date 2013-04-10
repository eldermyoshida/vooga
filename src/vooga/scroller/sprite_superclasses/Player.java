
package vooga.scroller.sprite_superclasses;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.List;
import vooga.scroller.design_patterns.State;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;
import vooga.scroller.util.Vector;
import vooga.scroller.view.View;


/**
 * Two Design Patterns being used here: Visitor and State. 
 * 
 * Visitor pattern is used to handle collisions. Essentially, whenever
 * a collision is detected, we will call the visit method of myCollisionHandler
 * and pass in the object Player has just collided with. 
 * 
 * State pattern is used to handle the state the Player is in. currenState
 * starts out at a default state. All updating and painting is done on 
 * a state level. This is evinced through the Player's update and paint 
 * methods. 
 * 
 * 
 * @author Jay Wang
 *
 */
public class Player extends Sprite {

//    Graphics2D pen;
    List<State> myStates;
    State currentState; 
    View myView;
    private Location myOriginalCenter;
    private Dimension mySize;
    private Pixmap myImage;
    
    // Used for testing purposes only
    protected static final int MOVE_LEFT = KeyEvent.VK_A;
    protected static final int MOVE_RIGHT = KeyEvent.VK_D;
    protected static final int MOVE_UP = KeyEvent.VK_W;
    protected static final int MOVE_DOWN = KeyEvent.VK_S;
    protected static final int MOVE_SPEED = 10;    
    public static final Vector LEFT_VELOCITY = new Vector(LEFT_DIRECTION, MOVE_SPEED);
    public static final Vector RIGHT_VELOCITY = new Vector(RIGHT_DIRECTION, MOVE_SPEED);
    public static final Vector UP_VELOCITY = new Vector(UP_DIRECTION, MOVE_SPEED);
    public static final Vector DOWN_VELOCITY = new Vector(DOWN_DIRECTION, MOVE_SPEED);

    public Player (Pixmap image, Location center, Dimension size, View view) {
        super(image, center, size);
        myView = view;
        myOriginalCenter = center;
        mySize = size;
        myImage = image;
    }

    public void update(double elapsedTime, Dimension bounds) {

    }
   
    @Override
    public void paint (Graphics2D pen) {
        myImage.paint(pen, myOriginalCenter, mySize);
    }
    
    public void changeState(State newState) {
        currentState = newState;
    }
    
    public Location getOriginalCenter() {
        return myOriginalCenter;
    }

}
