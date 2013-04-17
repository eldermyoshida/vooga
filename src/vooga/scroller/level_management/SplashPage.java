package vooga.scroller.level_management;

import java.awt.Dimension;
import java.awt.Graphics2D;
import util.input.Input;
import util.input.InputClassTarget;
import util.input.InputMethodTarget;
import vooga.scroller.level_editor.Level;
import vooga.scroller.level_editor.exceptions.LevelEditorException;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.Pixmap;
import vooga.scroller.view.View;

@InputClassTarget
public class SplashPage extends Level implements IInputListener{

    //private static final ScrollingManager DEFAULT_SCROLLING = new StaticScrollingManager();
    
    public static final String CONTROLS_FILE_PATH = "vooga/scroller/resources/controls/SplashMapping";

    
    
    private LevelManager myLevelManager;
    private int myNextLevelID;
    
    public SplashPage (Pixmap backgroundImage, int splashID, View view, ScrollingManager sm) {
        super(splashID, sm, view);
        this.setBackground(backgroundImage.getDefaultImg());
        myNextLevelID = 1;
    }

    /**
     * Sets the next level to go to given ID.
     * 
     * @param id of the next level to go.
     */
    public void setNextLevelID(int id) {
        myNextLevelID = id;
    }
    
    
    @Override
    public void update(double elapsedTime, Dimension bounds, View view) {
        // Just leave the background image.
    }


    @Override
    public void paint (Graphics2D pen) {
        // nothing to paint here (we could always add buttons)
    }

    public void addManager (LevelManager lm) {
        myLevelManager = lm; 
    }

    @InputMethodTarget(name = "exit")
    public void exit() {
        System.exit(-1);
    }
    
    @InputMethodTarget(name = "space")
    public void nextLevel() {
        Player p = myLevelManager.currentLevel().getPlayer();
        myLevelManager.setCurrentLevel(
                      myLevelManager.get(this.getDoor()).getLevel());
        myLevelManager.currentLevel().addPlayer(p);
        System.out.println("here");
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
}
