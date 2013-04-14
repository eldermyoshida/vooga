package vooga.scroller.level_editor;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import vooga.scroller.util.Sprite;
import vooga.scroller.viewUtil.RadioGroup;

public class ToolsManager {

    ISpriteLibrary lib;
    Map<Integer, Sprite> spriteMap;
    LETools viewTools;
    
    public ToolsManager(ISpriteLibrary l) {
        lib = l;
        setTools();
    }
    
    private void setTools () {
        int i=0;
        spriteMap = new HashMap<Integer, Sprite>();
        viewTools = new LETools();
        for (Class<? extends Sprite> c:lib.getSpritesClasses()) {
            Sprite sprite;
            try {
                sprite = (Sprite) c.newInstance();
                spriteMap.put(i, sprite);
                viewTools.addSpriteOption(sprite, i);
            }
            catch (InstantiationException e) {
                e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
    
    public LETools getViewTools() {
        return viewTools;
    }
    
    public Map<Integer, Sprite> getSpriteMap() {
        return spriteMap;
    }
}