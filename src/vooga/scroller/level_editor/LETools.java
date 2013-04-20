package vooga.scroller.level_editor;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import vooga.scroller.example.sprites.MarioLib.Platform;
import vooga.scroller.level_management.IDoor;
import vooga.scroller.level_management.LevelPortal;
import vooga.scroller.sprites.interfaces.ICoin;
import vooga.scroller.sprites.interfaces.IEnemy;
import vooga.scroller.util.Sprite;
import vooga.scroller.viewUtil.Tools;


public class LETools extends Tools {

    private Map<Object, String> mySpriteImages;
    private Map<Object, String> myBackgroundImages;
    private Map<Object, String> myOtherImages;

    private List<HashMap<Object, String>> myOptions;

    public LETools () {
        myOptions = new ArrayList<HashMap<Object, String>>();
        Map<Object, String> platforms = new HashMap<Object, String>();
        Map<Object, String> ennemis = new HashMap<Object, String>();
        Map<Object, String> collectibles = new HashMap<Object, String>();
        Map<Object, String> specialpoints = new HashMap<Object, String>();
        myOptions.add((HashMap<Object, String>) platforms);
        myOptions.add((HashMap<Object, String>) ennemis);
        myOptions.add((HashMap<Object, String>) collectibles);
        myOptions.add((HashMap<Object, String>) specialpoints);
        mySpriteImages = new HashMap<Object, String>();
        myOtherImages = new HashMap<Object, String>();
        myBackgroundImages = new HashMap<Object, String>();
        initOtherIcons();
    }

    public Map<Object, String> getSpriteMakingOptions () {
        return mySpriteImages;
    }

    public void addSpriteOption (Sprite s, int i) {
        if (s instanceof Platform) {
            // TODO - generalize sorting
            myOptions.get(0).put(new ImageIcon(s.getDefaultImg()
                    .getScaledInstance(40, 40, Image.SCALE_SMOOTH)),
                                 i + "");
        }
        if (s instanceof IEnemy) {
            // TODO - generalize sorting
            myOptions.get(1).put(new ImageIcon(s.getDefaultImg()
                    .getScaledInstance(40, 40, Image.SCALE_SMOOTH)),
                                 i + "");
        }
        if (s instanceof ICoin) {
            // TODO - generalize sorting
            myOptions.get(2).put(new ImageIcon(s.getDefaultImg()
                    .getScaledInstance(40, 40, Image.SCALE_SMOOTH)),
                                 i + "");
        }
        if (s instanceof StartPoint || s instanceof IDoor) {
            // TODO - generalize sorting
            myOptions.get(3).put(new ImageIcon(s.getDefaultImg()
                    .getScaledInstance(40, 40, Image.SCALE_SMOOTH)),
                                 i + "");
        }
        // TODO -remove
        mySpriteImages.put(new ImageIcon(s.getDefaultImg().getScaledInstance(40, 40,
                                                                             Image.SCALE_SMOOTH)),
                           i + "");
    }

    public Map<Object, String> getOtherOptions () {
        return myOtherImages;
    }

    public Map<Object, String> getBackgrounds () {
        return myBackgroundImages;
    }

    // TODO - Decide if other icons should be instance vars too.
    private void initOtherIcons () {
        myOtherImages.put(new ImageIcon((new StartPoint().getDefaultImg()
                .getScaledInstance(40, 40, Image.SCALE_SMOOTH))),
                          ILevelEditor.START_ID + "");
        myOtherImages.put(new ImageIcon((new LevelPortal().getDefaultImg()
                .getScaledInstance(40, 40, Image.SCALE_SMOOTH))),
                          ILevelEditor.END_ID + "");
    }

    public List<? extends Map<Object, String>> getOptions () {
        return myOptions;
    }

    public void addBackgrounds (Map<Integer, Image> map) {
        for (Integer key : map.keySet()) {
            myBackgroundImages
                    .put(new ImageIcon(map.get(key).getScaledInstance(100, 100, Image.SCALE_SMOOTH)),
                         "" + key);
        }
    }

}
