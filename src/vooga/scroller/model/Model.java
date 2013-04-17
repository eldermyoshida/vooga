package vooga.scroller.model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Arrays;
import java.util.List;
import util.Location;
import util.Secretary;
import vooga.scroller.level_management.LevelManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.animation.Animation;
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

    //private static final String SPLASH_CONTROLS = "vooga/scroller/resources/controls/SplashMapping";
    
    
    private static final int DEFAULT_START_LEVEL_ID = 0;

    
    private View myView;
    private Player myPlayer;

    private LevelManager myLevelManager;
    private ScrollingManager myScrollingManager;
    private Secretary mySecretary;
    private List<String> spriteStrings = Arrays.asList("Mario mario", "Koopa koopa", "Coin coin",
                                                       "MarioLib.MovingPlatform movingPlatform"); 
    private static final String PART_ONE = "public void visit (";
    private static final String PART_TWO = ") {}";
    private static final String COMMA = ", ";
    
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
        
        myScrollingManager.initGame(this);
        myScrollingManager.initView(view);
        
        myLevelManager = new LevelManager(myScrollingManager, myView);
        myLevelManager.currentLevel().addPlayer(myPlayer);


//        myLevelManager.setCurrentLevel(DEFAULT_START_LEVEL_ID);
        
        mySecretary = new Secretary();
        generateVisitMethods(spriteStrings);  
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
        for (int i = 0; i < spriteStrings.size(); i++) {
            for (int j = i+1; j < spriteStrings.size(); j++) {
                
                mySecretary.write(PART_ONE + spriteStrings.get(i) + COMMA + spriteStrings.get(j) + PART_TWO);
            }
        }        
    }
}
