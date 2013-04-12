
package vooga.scroller.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.scroller.level_editor.Level;
import vooga.scroller.scrollingmanager.ScrollingManager;
import vooga.scroller.sprites.test_sprites.MarioLib;
import vooga.scroller.util.Location;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.PlatformerConstants;
import vooga.scroller.view.View;
/**
 * Instantiates all of the levels for gameplay.
 * 
 * @author Scott Valentine
 *
 */
public class LevelFactory {
    
    /**
     * Generates levels to be displayed by the view and played by the model.
     * 
     * @param view is the view used for level information.
     * @return a List of all levels that will be played in the game.
     */
    public List<Level> generateLevels (ScrollingManager myScrollingManager, View view) {
        Level myCurrLevel = new Level(1, myScrollingManager, view);
        
        // TODO: this will ideally read in levels from file and create instances of each level
        // This works for demos
        
        
        myCurrLevel.addSprite(new MarioLib.Coin( 
                                new Location(view.getWidth() - 400, view.getHeight() - 250)
                                ));   
        
        myCurrLevel.addSprite(new MarioLib.Coin( 
                                                new Location(view.getWidth() - 400, view.getHeight() - 350)
                                                ));   

        myCurrLevel.addSprite(new MarioLib.Koopa( 
                                 new Location(view.getWidth() - 300, view.getHeight() - 275)  
                                 ));   
        
        
        myCurrLevel.addSprite(new MarioLib.Koopa( 
                                 new Location(view.getWidth() - 200, view.getHeight() - 350)  
                                       ));   
        
        myCurrLevel.addSprite(new MarioLib.Platform( 
                                    new Location(view.getWidth() - 80, view.getHeight() - 150)
                                    ));   

        myCurrLevel.addSprite(new MarioLib.Turtle(
                                  new Location(view.getWidth() - 500, view.getHeight() - 75)
                                  ));   
        
        myCurrLevel.addSprite(new MarioLib.MovingPlatform( 
                                                    new Location(view.getWidth() - 80, view.getHeight() - 20)
                                                    )); 
        
        
        
        myCurrLevel.setSize(PlatformerConstants.DEFAULT_LEVEL_SIZE);
        List<Level> l = new ArrayList<Level>();
        l.add(myCurrLevel);
        return l;
    }

}
