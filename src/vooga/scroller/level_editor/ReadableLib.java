package vooga.scroller.level_editor;

import java.awt.Image;
import vooga.scroller.util.Sprite;

public interface ReadableLib {

    public Sprite getSprite(int key);
    
    public Image getBackground(int key);
}
