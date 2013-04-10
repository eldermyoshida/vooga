
package vooga.scroller.level_editor;

import java.util.ArrayList;
import java.util.List;
import vooga.scroller.test_sprites.MarioLib;
import vooga.scroller.util.Sprite;

public class SpriteLibrary {

    List<Sprite> mySprites = new ArrayList<Sprite>();
    
    public Class<?>[] getStuff() {
        MarioLib lib = new MarioLib();
        Class<?>[] myClasses = lib.getClass().getClasses();
        return myClasses;
    }
    
}
