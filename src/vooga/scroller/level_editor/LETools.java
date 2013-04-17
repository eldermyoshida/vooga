package vooga.scroller.level_editor;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import vooga.scroller.util.Sprite;
import vooga.scroller.viewUtil.Tools;


public class LETools extends Tools {

    private Map<Object, String> mySpriteImages;
    private Map<Object, String> myBackgroundImages;
    private Map<Object, String> myOtherImages;

    public LETools () {
        mySpriteImages = new HashMap<Object, String>();
        myOtherImages = new HashMap<Object, String>();
        myBackgroundImages = new HashMap<Object, String>();
        initOtherIcons();
    }

    public Map<Object, String> getSpriteMakingOptions () {
        return mySpriteImages;
    }

    public void addSpriteOption (Sprite s, int i) {
        mySpriteImages.put(new ImageIcon(s.getDefaultImg()
                .getScaledInstance(40, 40, Image.SCALE_SMOOTH)), i + "");
    }

    public Map<Object, String> getMiscOptions () {
        return myOtherImages;
    }
    
    public Map<Object, String> getBackgrounds() {
        return myBackgroundImages;
    }

    private void initOtherIcons () {
        myOtherImages.put(new ImageIcon((new StartPoint().getDefaultImg()
                .getScaledInstance(40, 40, Image.SCALE_SMOOTH))), -1 + "");
    }

    public void addBackgrounds (Map<Integer, Image> map) {
        for (Integer key : map.keySet()) {
            myBackgroundImages.put(map.get(key).getScaledInstance(40, 40, Image.SCALE_SMOOTH), "" + key);
        }
    }

}
