package vooga.scroller.sprites.superclasses;

import java.awt.Dimension;
import java.awt.Graphics2D;
import util.Location;
import util.ValueText;
import util.Vector;
import vooga.scroller.level_management.IInputListener;
import vooga.scroller.sprites.state.StateManager;
import vooga.scroller.statistics.PlayerScore;
import vooga.scroller.statistics.Statistic;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.util.Sprite;
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
public abstract class Player extends Sprite implements IInputListener{

    // Graphics2D pen;
    private GameView myView;
    private Location myPaintCenter;
    private Dimension mySize;
    // private Pixmap myImage;
    private StateManager myStateManager;
    private ScrollingManager myScrollingManager;
    private Statistic myStatistic;
    private ForceBundle forceBundle;


    private Location myOriginalLocation;

    // Used for testing purposes only
    protected static final int MOVE_SPEED = 10;
    public static final Vector LEFT_VELOCITY = new Vector(LEFT_DIRECTION, MOVE_SPEED);
    public static final Vector RIGHT_VELOCITY = new Vector(RIGHT_DIRECTION, MOVE_SPEED);
    public static final Vector UP_VELOCITY = new Vector(UP_DIRECTION, 300);
    public static final Vector DOWN_VELOCITY = new Vector(DOWN_DIRECTION, MOVE_SPEED);

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
        mySize = size;
        // myImage = image;
        myStateManager = new StateManager(this);
        myScrollingManager = sm;
        myStatistic = new PlayerScore();
        myOriginalLocation = center;
        forceBundle = new ForceBundle(this);
    }

    @Override
    public void update (double elapsedTime, Dimension bounds) {
        myStateManager.update(elapsedTime, bounds);
        super.update(elapsedTime, bounds);
        forceBundle.apply();
        myPaintCenter = myScrollingManager.playerPaintLocation(this);
    }
    
    public abstract void handleDeath();

    @Override
    public void paint (Graphics2D pen) {
        super.getView().paint(pen, myPaintCenter, mySize);
        displayStatistic(pen);
    }

    public void changeState (int stateID) {
        myStateManager.changeState(stateID);
    }

    public Location getPaintLocation () {
        return myPaintCenter;
    }

    public Statistic getStatistic () {
        return myStatistic;
    }

    public void displayStatistic (Graphics2D pen) {
        ValueText vt = new ValueText(myStatistic.getName(), myStatistic.getAggregateValue());
        vt.paint(pen, PlayerScore.DEFAULT_SCORE_LOCATION, PlayerScore.DEFAULT_SCORE_COLOR);
    }
    
    public Location getOriginalLocation() {
        return myOriginalLocation;
    }
    
    public Dimension getSize() {
        return mySize;
    }

    public void incrementScore (int increment) {
        myStatistic.addValue(increment);
    }
    
    
}
