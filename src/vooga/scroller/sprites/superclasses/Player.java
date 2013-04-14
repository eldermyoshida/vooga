
package vooga.scroller.sprites.superclasses;

import java.awt.Dimension;
import java.awt.Graphics2D;
import util.Location;
import util.Vector;
import vooga.scroller.sprites.state.StateManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.util.Gravity;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.util.Sprite;
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
 * @author Jay Wang, Ross Cahoon
 *
 */
public class Player extends Sprite {

//    Graphics2D pen;
    private View myView;
    private Location myPaintCenter;
    private Dimension mySize;
    //private Pixmap myImage;
    private StateManager myStateManager;
    private ScrollingManager myScrollingManager;
    
    
    // Used for testing purposes only
    protected static final int MOVE_SPEED = 10;    
    public static final Vector LEFT_VELOCITY = new Vector(LEFT_DIRECTION, MOVE_SPEED);
    public static final Vector RIGHT_VELOCITY = new Vector(RIGHT_DIRECTION, MOVE_SPEED);
    public static final Vector UP_VELOCITY = new Vector(UP_DIRECTION, MOVE_SPEED);
    public static final Vector DOWN_VELOCITY = new Vector(DOWN_DIRECTION, MOVE_SPEED);

    public Player (ISpriteView image, Location center, Dimension size, View view, ScrollingManager sm) {
        super(image, center, size);
        myView = view;
        myPaintCenter = new Location(myView.getWidth() / 2, myView.getHeight() / 2);
        mySize = size;
        //myImage = image;
        myStateManager = new StateManager(this);
        myScrollingManager = sm;
    }

    @Override
    public void update(double elapsedTime, Dimension bounds) {
    myStateManager.update(elapsedTime, bounds);
    super.update(elapsedTime, bounds);

    myPaintCenter = myScrollingManager.playerPaintLocation(this);
    Gravity gravity = new Gravity(this);
    gravity.applyGravity();


    }
   
    @Override
    public void paint (Graphics2D pen) {
        super.getView().paint(pen, myPaintCenter, mySize);
    }
    
    public void changeState(int stateID) {
        myStateManager.changeState(stateID);
    }
    
    public Location getPaintLocation() {
        return myPaintCenter;
    }

   

}
