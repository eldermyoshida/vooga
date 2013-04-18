package vooga.scroller.level_editor;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import vooga.scroller.level_management.LevelPortal;
import vooga.scroller.util.Sprite;
import vooga.scroller.viewUtil.RadioGroup;

public class ToolsManager {

    ISpriteLibrary lib;
    Map<Integer, Sprite> spriteMap;
    Map<String, Sprite> nameMap;
    LETools viewTools;
    
    public ToolsManager(ISpriteLibrary l) {
        lib = l;
        setTools();
    }
    
    private void setTools () {
        int i=0;
        spriteMap = new HashMap<Integer, Sprite>();
        nameMap = new HashMap<String, Sprite>();
        viewTools = new LETools();

        Sprite sprite;
        for (Class<? extends Sprite> c:lib.getSpritesClasses()) {
            try {
                sprite = (Sprite) c.newInstance();
                setupTool(i, sprite);
            }
            catch (InstantiationException e) {
                e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            i++;
        }
        sprite = new StartPoint();
        setupTool(ILevelEditor.START_ID, sprite);
        sprite = new LevelPortal();
        setupTool(ILevelEditor.END_ID, sprite);
    }

    private void setupTool (int i, Sprite sprite) {
        spriteMap.put(i, sprite);
        nameMap.put(sprite.getClass().getName(), sprite);
        viewTools.addSpriteOption(sprite, i);
    }
    
    public LETools getViewTools() {
        return viewTools;
    }
    
    public Map<Integer, Sprite> getSpriteMap() {
        return spriteMap;
    }
    
    public Map<String,Sprite> getNameMap() {
        return nameMap;
    }
}
