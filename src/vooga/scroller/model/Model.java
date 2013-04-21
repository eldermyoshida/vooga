package vooga.scroller.model;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import util.Location;
import util.Secretary;
import vooga.scroller.level_editor.Level;
import vooga.scroller.level_management.LevelManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.animation.Animation;
import vooga.scroller.sprites.animation.MovingSpriteAnimationFactory;
import vooga.scroller.sprites.interfaces.IPlayer;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.sprites.test_sprites.mario.Mario;
import vooga.scroller.view.GameView;


/**
 * Represents a scrolling platformer.
 * *
 * 
 * @author Ross Cahoon
 * @author Jay Wang
 * @author Scott Valentine
 */

public class Model {
      
    //private static final int DEFAULT_START_LEVEL_ID = 0;

    
    private GameView myView;
    private Player myPlayer;

    private LevelManager myLevelManager;
    private ScrollingManager myScrollingManager;
    private Secretary mySecretary;
    private List<String> spriteStrings = Arrays.asList("Mario mario", "Koopa koopa", "Coin coin",
                                                       "MarioLib.MovingPlatform movingPlatform"); 
    //If I could use reflection to look through the interfaces package and then generate the VisitMethods.java file, that would be BOMB! 
    
    private static final String PART_ONE = "public void visit (";
    private static final String PART_TWO = ") {}";
    private static final String COMMA = ", ";
    private static final String DIRECTORY_LOCATION = "src/vooga/scroller/collision_manager/files/";
    private static final String FILE_NAME = "visitMethods.txt";


    private static final String PLAYER_IMAGES = "walama.gif";
    // "mario.gif"
    //"transparent_wolf.gif" -- not yet added.
    //"walama.gif"
    
    /**
     * Constructs a new Model based on the view and the scrolling manager used by the game.
     * 
     * @param gameView which is used to display/control game.
     * @param myScrollingManager used to control in-game scrolling.
     * @throws IOException 
     */

    public Model (GameView gameView, ScrollingManager sm, Level ...levels) {
        myView = gameView;
        setScrollingManager(sm);
        myPlayer = initPlayer();
        myLevelManager = initializeLevelManager(levels);
        myLevelManager.getCurrentLevel().addPlayer(myPlayer);
//        mySecretary = new Secretary();
//        generateVisitMethods(spriteStrings);  
    }
    
    
    private LevelManager initializeLevelManager (Level[] levels) {
        return new LevelManager(myScrollingManager, myView, levels);
    }


    //TODO - refactor
    public Model (GameView gameView, ScrollingManager sm, String... levelFileNames) {
        myView = gameView;
        setScrollingManager(sm);
        myPlayer = initPlayer();
        myLevelManager = initializeLevelManager(levelFileNames);
        myLevelManager.getCurrentLevel().addPlayer(myPlayer);
        
//        mySecretary = new Secretary();
//        generateVisitMethods(spriteStrings);  
    }
    
    private LevelManager initializeLevelManager (String[] levelFileNames) {
        return new LevelManager(myScrollingManager, myView, levelFileNames);
    }


    private void setScrollingManager(ScrollingManager sm) {
        myScrollingManager = sm;
        myScrollingManager.initModel(this);
        myScrollingManager.initView(myView);
//        mySecretary = new Secretary(DIRECTORY_LOCATION, FILE_NAME);
//        generateVisitMethods(spriteStrings);  
    }



    /**
     * User defined player initialization.
     */
    private Player initPlayer() {
        // TODO: this is implemented by the developer. 
        
        Player player = new Mario(
                             new Location(100, 140),
                             new Dimension(138/6, 276/6),
                             myView, myScrollingManager);
        
        MovingSpriteAnimationFactory msaf = new MovingSpriteAnimationFactory(PLAYER_IMAGES);
        Animation playerAnimation = msaf.generateAnimation(player);
        
        player.setView(playerAnimation);

        return player;
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
    
    public Image getBackground() {
        return myLevelManager.getCurrentLevel().getBackground();
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
     * @throws IOException 
     */
    private void generateVisitMethods (List<String> spriteStrings) throws IOException {
        for (int i = 0; i < spriteStrings.size(); i++) {
            for (int j = i+1; j < spriteStrings.size(); j++) {
                
                mySecretary.write(PART_ONE + spriteStrings.get(i) + COMMA + spriteStrings.get(j) + PART_TWO);
            }
        }        
    }
}
