package vooga.scroller.level_management.splash_page;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
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

    
    public static final String CONTROLS_FILE_PATH = "vooga/scroller/resources/controls/SplashMapping";

    
    
    private IDoor myDoor;
    private ISpriteView myBackground;
    private int myID;
    
    public SplashPage (ISpriteView backgroundImage, int splashID, GameView gameView, ScrollingManager sm) {
        myBackground = backgroundImage;
        myID = splashID;
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
        // nothing to paint here (we could always add buttons)
    }

    @InputMethodTarget(name = "exit")
    public void exit() {
        System.exit(-1);
    }
    
    @InputMethodTarget(name = "space")
    public void nextLevel() {
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

    @Override
    public String getInputFilePath () {
        return CONTROLS_FILE_PATH;
    }
    
    public IDoor getDoor() {
        return myDoor;
    }

    @Override
    public Player getPlayer () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addPlayer (Player p) {
        // TODO Auto-generated method stub
    }

    public void addManager (LevelManager myLevelManager) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public double getRightBoundary () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Dimension getLevelBounds () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getLeftBoundary () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getUpperBoundary () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getLowerBoundary () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Image getBackground () {
        // TODO Auto-generated method stub
        return null;
    }
}
