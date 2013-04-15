package vooga.scroller.model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Arrays;
import java.util.List;
import util.Location;
import vooga.scroller.level_management.LevelManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.animation.Animation;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.sprites.test_sprites.mario.Mario;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Secretary;
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
    private IInput myInputs;
    private LevelManager myLevelManager;
    private ScrollingManager myScrollingManager;
    private Secretary mySecretary;
    private List<String> spriteStrings = Arrays.asList("Koopa koopa", "Coin coin",
                                                       "MarioLib.MovingPlatform movingPlatform"); 
    private static final String PART_ONE = "public void visit (";
    private static final String PART_TWO = ") {}";
    private static final String COMMA = ", ";
    private Pixmap mySplash;
    
    /**
     * Constructs a new Model based on the view and the scrolling manager used by the game.
     * 
     * @param view which is used to display/control game.
     * @param myScrollingManager used to control in-game scrolling.
     */
    public Model (View view, ScrollingManager sm) {
        myScrollingManager = sm;
        myView = view;
        myInputs = new SplashInputs(this, myView);
        mySplash = new Pixmap("MARIO SPLASH.png"); 
        
        initPlayer();
        myLevelManager = new LevelManager(myScrollingManager, myView);
        myLevelManager.currentLevel().addPlayer(myPlayer);
    }



    /**
     * User defined player initialization.
     */
    private void initPlayer() {
        // TODO: this is implemented by the developer. 
        myPlayer = new Mario(
                             new Location(100, 140),
                             new Dimension(32, 32),
                             myView, myScrollingManager);
        myPlayer.setView(new Animation(myPlayer));

    }

    /**
     * Draw all elements of the game.
     */
    public void paint (Graphics2D pen) {
        
        if(mySecretary == null) {
            mySplash.paint(pen, new Location(myView.getSize().width/2,myView.getSize().height/2), myView.getSize());
        }
        else {
            myLevelManager.currentLevel().paint(pen);
        }
        
        
    }

    /**
     * Updates all the game elements since the last update.
     * 
     * @param elapsedTime is the elapsed time since the last update.
     */
    public void update (double elapsedTime) {
        
        // WTF
        if(mySecretary == null) {
            
        }
        else {
            myLevelManager.currentLevel().update(elapsedTime, myView.getSize(), myView);

        }
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
    
    public Player getPlayer(){
        return myPlayer;
    }
    
    
    /**
     * This method is a helper I created to generate all the visit methods CollisionManager 
     * uses. It can be a real pain typing out all those visit methods. This method merely 
     * takes a list of Strings - you need a unique String for each sprite type you have - 
     * and it writes all combinations of sprite combinations to calculate all visit method 
     * combinations. 
     * 
     * The result is stored in a file called visitMethods.txt under the files package of 
     * collision_manager. 
     * @param List<Strings> spriteStrings
     * @author Jay Wang
     */
    private void generateVisitMethods (List<String> spriteStrings) {
        for (String firstSpriteString : spriteStrings) {
            for (String secondSpriteString : spriteStrings) {
                mySecretary.write(PART_ONE + firstSpriteString + COMMA + secondSpriteString + PART_TWO);
            }
        }        
    }

    public void start () {
        System.out.println("Let's play a game");
        myInputs = new PlayerInputs(this, myView);
        mySecretary = new Secretary();
        generateVisitMethods(spriteStrings);      
    }
}
