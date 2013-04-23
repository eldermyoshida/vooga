package vooga.scroller.level_management.splash_page;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import util.Location;
import util.input.Input;
import util.input.InputClassTarget;
import util.input.InputMethodTarget;
import vooga.scroller.level_editor.Level;
import vooga.scroller.level_editor.exceptions.LevelEditorException;
import vooga.scroller.level_management.IDoor;
import vooga.scroller.level_management.IInputListener;
import vooga.scroller.level_management.LevelManager;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.IGameComponent;
import vooga.scroller.util.ISpriteView;
import vooga.scroller.util.Pixmap;
import vooga.scroller.view.GameView;

@InputClassTarget
public class SplashPage implements IInputListener, IGameComponent{

    // TODO: this string is the part of every Splash page and thus needs to be removed
    public static final String CONTROLS_FILE_PATH = "vooga/scroller/marioGame/controls/SplashMapping";

    // TODO: this class needs to be extendible and more general so developers can defined
    // their own controls for the splash page.
    
    private IDoor myDoor;
    private ISpriteView myBackground;
    private int myID;
    private GameView myGameView;
    private LevelManager myLevelManager;
    private Player myPlayer;
    
    public SplashPage (ISpriteView backgroundImage, int splashID, GameView gameView, ScrollingManager sm) {
        myBackground = backgroundImage;
        myID = splashID;
        myGameView = gameView;
    }

    /**
     * Sets the next level to go to given ID.
     * 
     * @param id of the next level to go.
     */
    public void addDoor(IDoor door) {
        myDoor = door;
    }
    
    
    @Override
    public void update(double elapsedTime, Dimension bounds, GameView gameView) {
        // Just leave the background image.
    }


    @Override
    public void paint (Graphics2D pen) {
        myBackground.paint(pen, new Location((double)myGameView.getWidth()/2, 
                                             (double)myGameView.getHeight()/2), 
                                             myGameView.getSize());
    }

    @InputMethodTarget(name = "exit")
    public void exit() {
        System.exit(-1);
    }
    
    @InputMethodTarget(name = "start")
    public void nextLevel() {
        System.out.println("hit");
        myDoor.goToNextLevel(getPlayer());
    }
    
    @Override
    public void addInputListeners (Input myInput) {
        myInput.replaceMappingResourcePath(getInputFilePath());
        myInput.addListenerTo(this);        
    }
    
    @Override
    public void removeInputListeners (Input myInput) {
        myInput.removeListener(this);       
    }

    public String getInputFilePath () {
        return CONTROLS_FILE_PATH;
    }
    
    public IDoor getDoor() {
        return myDoor;
    }

    @Override
    public Player getPlayer () {
        return myPlayer;
    }

    @Override
    public void addPlayer (Player p) {
        myPlayer = p;
    }

    public void addManager (LevelManager levelManager) {
        myLevelManager = levelManager;
    }

    @Override
    public double getRightBoundary () {
        //return 0;
        return (double)myGameView.getWidth();
    }

    @Override
    public Dimension getLevelBounds () {
        return myGameView.getSize();
    }

    @Override
    public double getLeftBoundary () {
        return 0;
    }

    @Override
    public double getUpperBoundary () {
        return 0;
    }

    @Override
    public double getLowerBoundary () {       
        return (double)myGameView.getHeight();

    }

    @Override
    public Image getBackground () {
        return myBackground.getImage();
    }
}
