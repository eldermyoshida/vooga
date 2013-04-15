package vooga.scroller.level_management;

import java.awt.Dimension;
import java.awt.Graphics2D;
import vooga.scroller.level_editor.Level;
import vooga.scroller.model.IInput;
import vooga.scroller.model.SplashInputs;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.scrollingmanager.StaticScrollingManager;
import vooga.scroller.sprites.superclasses.Player;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;
import vooga.scroller.view.View;

public class SplashPage extends Level {

    private static final ScrollingManager DEFAULT_SCROLLING = new StaticScrollingManager();
    private LevelManager myLevelManager;
    
    public SplashPage (Pixmap backgroundImage, int splashID, View view, ScrollingManager sm) {
        super(splashID, sm, view);
        this.setBackground(backgroundImage.getDefaultImg());
    }

    
    /** 
     * The input is different so activation needs to be different. 
     */
    @Override
    public void activate(){
        IInput input = new SplashInputs(this, this.getView());
        setInput(input);      
    }

    @Override
    public void update(double elapsedTime, Dimension bounds, View view) {

        System.out.println(getInput());

    }


    @Override
    public void paint (Graphics2D pen) {

    }

    public void exit () {
        myLevelManager.setCurrentLevel(1);
    }


    public void addManager (LevelManager lm) {
        myLevelManager = lm; 
    }

    
}
