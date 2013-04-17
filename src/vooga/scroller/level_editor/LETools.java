package vooga.scroller.level_editor;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;
import vooga.scroller.viewUtil.Tools;


public class LETools extends Tools {

    Map<Object, String> spriteIcons;
    Map<Object, String> otherIcons;

    public LETools () {
        spriteIcons = new HashMap<Object, String>();
        otherIcons = new HashMap<Object, String>();
        initOtherIcons();
    }

    public Map<Object, String> getSpriteMakingOptions () {
        return spriteIcons;
    }

    public void addSpriteOption (Sprite s, int i) {
        spriteIcons.put(new ImageIcon(s.getDefaultImg().getScaledInstance(40, 40,
                                                                          Image.SCALE_SMOOTH)),
                        i + "");
    }

    public Map<Object, String> getOtherOptions () {
        return otherIcons;
    }

    private void initOtherIcons () {
        otherIcons.put(new ImageIcon((new StartPoint().getDefaultImg()
                               .getScaledInstance(40, 40, Image.SCALE_SMOOTH))), -1 + "");
    }

    public void addBackgrounds (Map<Integer, Icon> backgrounds) {
        for (Integer key : backgrounds.keySet()) {
            otherIcons.put(backgrounds.get(key), "" + key);
        }
    }

}
