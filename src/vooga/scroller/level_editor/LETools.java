package vooga.scroller.level_editor;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;
import vooga.scroller.viewUtil.Tools;

public class LETools extends Tools {
    
    Map<Object, String> icons;
    
    
    public LETools() {
        icons = new HashMap<Object, String>();
    }

    public Map<Object, String> getSpriteMakingOptions() {
        return icons;
    }
    
    public void addSpriteOption(Sprite s) {
        icons.put(new ImageIcon(s.getView().getImg().getScaledInstance(40, 40, Image.SCALE_SMOOTH )), 
                  s.getClass().getCanonicalName());
    }
}
