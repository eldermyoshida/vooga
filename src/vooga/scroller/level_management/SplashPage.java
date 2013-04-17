package vooga.scroller.level_management;

import java.awt.Dimension;
import java.awt.Graphics2D;
import util.input.Input;
import util.input.InputClassTarget;
import util.input.InputMethodTarget;
import vooga.scroller.level_editor.Level;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.scrollingmanager.StaticScrollingManager;
import vooga.scroller.util.Pixmap;
import vooga.scroller.view.View;

@InputClassTarget
public class SplashPage extends Level {

    //private static final ScrollingManager DEFAULT_SCROLLING = new StaticScrollingManager();
    
    private static final String CONTROLS_FILE_PATH = "vooga/scroller/resources/controls/SplashMapping";

    
    
    private LevelManager myLevelManager;
    private int myNextLevelID;
    
    public SplashPage (Pixmap backgroundImage, int splashID, View view, ScrollingManager sm) {
        super(splashID, sm, view);
        this.setBackground(backgroundImage.getDefaultImg());
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
        myLevelManager.setCurrentLevel(myNextLevelID);
    }
    
    @Override
    public void addInputListeners (Input myInput) {
        myInput.addListenerTo(this);        
    }
    
    @Override
    public void removeInputListeners (Input myInput) {
        myInput.removeListener(this);       
    }
}
