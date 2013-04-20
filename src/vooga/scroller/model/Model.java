package vooga.scroller.model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Arrays;
import java.util.List;
import util.Location;
import util.Secretary;
import vooga.scroller.collision_manager.VisitMethodsGenerator;
import vooga.scroller.level_management.LevelManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.animation.Animation;
import vooga.scroller.sprites.animation.MovingSpriteAnimationFactory;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.sprites.test_sprites.mario.Mario;
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

    // private static final int DEFAULT_START_LEVEL_ID = 0;

    private View myView;
    private Player myPlayer;

    private LevelManager myLevelManager;
    private ScrollingManager myScrollingManager;
    private VisitMethodsGenerator methodGenerator = new VisitMethodsGenerator(null);
    private static final String PLAYER_IMAGES = "walama.gif";

    // "mario.gif"
    // "transparent_wolf.gif" -- not yet added.
    // "walama.gif"

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
        

        myScrollingManager.initModel(this);
        myScrollingManager.initView(view);

        myLevelManager = new LevelManager(myScrollingManager, myView);
        myLevelManager.getCurrentLevel().addPlayer(myPlayer);

        // myLevelManager.setCurrentLevel(DEFAULT_START_LEVEL_ID);

    }

    /**
     * User defined player initialization.
     */
    private void initPlayer () {
        // TODO: this is implemented by the developer.

        myPlayer = new Mario(
                             new Location(100, 140),
                             new Dimension(138 / 6, 276 / 6),
                             myView, myScrollingManager);

        MovingSpriteAnimationFactory msaf = new MovingSpriteAnimationFactory(PLAYER_IMAGES);
        Animation playerAnimation = msaf.generateAnimation(myPlayer);

        myPlayer.setView(playerAnimation);

    }

    /**
     * Draw all elements of the game.
     */
    public void paint (Graphics2D pen) {
        myLevelManager.getCurrentLevel().paint(pen);
    }

    /**
     * Updates all the game elements since the last update.
     * 
     * @param elapsedTime is the elapsed time since the last update.
     */
    public void update (double elapsedTime) {

        myLevelManager.getCurrentLevel().update(elapsedTime, myView.getSize(), myView);

    }

    /**
     * Gives various boundaries for the current level.
     * 
     * @return
     */
    public double getRightBoundary () {
        return myLevelManager.getCurrentLevel().getRightBoundary();
    }

    public double getLeftBoundary () {
        return myLevelManager.getCurrentLevel().getLeftBoundary();
    }

    public double getUpperBoundary () {
        return myLevelManager.getCurrentLevel().getUpperBoundary();
    }

    public double getLowerBoundary () {
        return myLevelManager.getCurrentLevel().getLowerBoundary();
    }

    public Dimension getLevelBounds () {
        return myLevelManager.getCurrentLevel().getLevelBounds();
    }

    public Image getBackground () {
        return myLevelManager.getCurrentLevel().getBackground();
    }

    public Player getPlayer () {
        return myPlayer;
    }

}
