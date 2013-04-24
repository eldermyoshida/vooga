package vooga.scroller.sprites.superclasses;

import java.awt.Dimension;
import java.awt.Graphics2D;
import util.Location;
import util.Vector;
import vooga.scroller.level_management.IInputListener;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.util.physics.ForceBundle;
import vooga.scroller.view.GameView;


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
 * @author Jay Wang, Ross Cahoon, Scott Valentine
 * 
 */
public abstract class Player extends GameCharacter implements IInputListener, Locatable {

    private GameView myView;
    private Location myPaintCenter;
    private ScrollingManager myScrollingManager;
    private ForceBundle forceBundle;

    public Player (ISpriteView image,
                   Location center,
                   Dimension size,
                   GameView gameView,
                   ScrollingManager sm, 
                   int health, 
                   int damage) {
        super(image, center, size, health, damage);
        myView = gameView;
        myPaintCenter = new Location(myView.getWidth() / 2, myView.getHeight() / 2);
        myScrollingManager = sm;
        forceBundle = new ForceBundle(this);
    }

    @Override
    public void update (double elapsedTime, Dimension bounds) {
        super.update(elapsedTime, bounds);
        forceBundle.apply();
        myPaintCenter = myScrollingManager.playerPaintLocation(this);       
    }

    @Override
    public void paint (Graphics2D pen) {
        super.getView().paint(pen, myPaintCenter, super.getSize());
    }

    /**
     * Gives the location at which this sprite will be painted.
     * 
     * @return
     */
    public Location getPaintLocation () {
        return myPaintCenter;
    }
}
