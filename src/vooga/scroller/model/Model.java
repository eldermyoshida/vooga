package vooga.scroller.model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import vooga.scroller.level_management.LevelManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.animation.Animation;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.sprites.test_sprites.mario.Mario;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.view.View;



/**
 * Represents a scrolling platformer.
 * *
 * 
 * @author Ross Cahoon
 * @author Jay Wang
 * @author Scott Valentine
 */

public class Model {

    private View myView;
    private Player myPlayer;

    // This is weird how it works. I think you just need to instantiate it(see constructor)
    private ModelInputs myInputs;
    private LevelManager myLevelManager;
    private ScrollingManager myScrollingManager;

    /**
     * Constructs a new Model based on the view and the scrolling manager used by the game.
     * 
     * @param view which is used to display/control game.
     * @param myScrollingManager used to control in-game scrolling.
     */
    public Model (View view, ScrollingManager sm) {
        myScrollingManager = sm;
        myView = view;
        initPlayer();
        myInputs = new ModelInputs(myPlayer, view);
        myLevelManager = new LevelManager(myScrollingManager, view);
        myLevelManager.currentLevel().addPlayer(myPlayer);

        
    }

    /**
     * User defined player initialization.
     */
    private void initPlayer() {
        // TODO: this is implemented by the developer. 
        myPlayer = new Mario(null,
                             new Location(500, 500),
                             new Dimension(30, 60),
                             myView, myScrollingManager);
        myPlayer.setView(new Animation(myPlayer));

    }

    /**
     * Draw all elements of the game.
     */
    public void paint (Graphics2D pen) {
        myLevelManager.currentLevel().paint(pen);
        
    }

    /**
     * Updates all the game elements since the last update.
     * 
     * @param elapsedTime is the elapsed time since the last update.
     */
    public void update (double elapsedTime) {
        myLevelManager.currentLevel().update(elapsedTime, myView.getSize(), myView);
    }

    /**
     * Gives various boundaries for the current level.
     * 
     * @return
     */
    public double getRightBoundary () {
        return myLevelManager.currentLevel().getRightBoundary();
    }

    public double getLeftBoundary () {
        return myLevelManager.currentLevel().getLeftBoundary();
    }

    public double getUpperBoundary () {
        return myLevelManager.currentLevel().getUpperBoundary();
    }

    public double getLowerBoundary () {
        return myLevelManager.currentLevel().getLowerBoundary();
    }

    public Dimension getLevelBounds () {
        return myLevelManager.currentLevel().getLevelBounds();
    }
    
    public Image getBackground() {
        return myLevelManager.currentLevel().getBackground();
    }
}
