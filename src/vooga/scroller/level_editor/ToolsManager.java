package vooga.scroller.level_editor;

import java.util.HashMap;
import java.util.Map;
import vooga.scroller.level_management.LevelPortal;
import vooga.scroller.util.Sprite;


public class ToolsManager {

    private ISpriteLibrary mySpriteLib;
    private IBackgroundLibrary myBackgroundLib;
    private Map<Integer, Sprite> mySpriteMap;
    private LETools myViewTools;

    public ToolsManager (ISpriteLibrary l) {
        this(l, new BackgroundLib(new String[0]));
    }

    public ToolsManager (ISpriteLibrary l, IBackgroundLibrary bgLib) {
        myBackgroundLib = bgLib;
        mySpriteLib = l;
        setTools();
    }

    private void setTools () {

        int i = 0;
        mySpriteMap = new HashMap<Integer, Sprite>();
        myViewTools = new LETools();
        myViewTools.addBackgrounds(myBackgroundLib.getBackgrounds());
        Sprite sprite;
        for (Class<? extends Sprite> c : mySpriteLib.getSpritesClasses()) {
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
        mySpriteMap.put(i, sprite);
        myViewTools.addSpriteOption(sprite, i);
    }

    public LETools getViewTools () {
        return myViewTools;
    }

    public Map<Integer, Sprite> getSpriteMap () {
        return mySpriteMap;
    }
}
