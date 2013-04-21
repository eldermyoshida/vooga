package vooga.scroller.level_editor.controllerSuite;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import vooga.scroller.level_editor.StartPoint;
import vooga.scroller.level_editor.view.LEActionLibrary;
import vooga.scroller.level_editor.view.LEToolsView;
import vooga.scroller.level_editor.view.LEView;
import vooga.scroller.level_management.IDoor;
import vooga.scroller.sprites.interfaces.ICoin;
import vooga.scroller.sprites.interfaces.IEnemy;
import vooga.scroller.sprites.interfaces.IPlatform;
import vooga.scroller.util.Renderable;
import vooga.scroller.util.Sprite;
import vooga.scroller.util.mvc.IView;
import vooga.scroller.util.mvc.vcFramework.Tools;


/**
 * Toolbox specific to a level Editor.
 * This object contains all the necessary information to generate GUI items
 * specific to a LevelEditor
 * 
 * @author Dagbedji Fagnisse
 * 
 */
public class LETools extends Tools implements Renderable<LEToolsView> {

    private static final int DEFAULT_SIZE = 40;
    private static final int PLATFORMS = 0;
    private static final int ENEMIES = 1;
    private static final int COLLECTIBLES = 2;
    private static final int SPECIALPOINTS = 3;
    private static final int OTHERS = 4;
    private LEActionLibrary myActionLibrary;
    private List<HashMap<Object, String>> mySpritesOptions;

    private Map<Object, String> myBackgroundImages;
    private Map<Object, String> myOtherImages;

    /**
     * Initialize state of this LETools.
     */
    public LETools (LEView v) {
        myActionLibrary = new LEActionLibrary(v);
        mySpritesOptions = new ArrayList<HashMap<Object, String>>();
        Map<Object, String> platforms = new HashMap<Object, String>();
        Map<Object, String> enemies = new HashMap<Object, String>();
        Map<Object, String> collectibles = new HashMap<Object, String>();
        Map<Object, String> specialpoints = new HashMap<Object, String>();
        Map<Object, String> others = new HashMap<Object, String>();
        mySpritesOptions.add(PLATFORMS, (HashMap<Object, String>) platforms);
        mySpritesOptions.add(ENEMIES, (HashMap<Object, String>) enemies);
        mySpritesOptions.add(COLLECTIBLES, (HashMap<Object, String>) collectibles);
        mySpritesOptions.add(SPECIALPOINTS, (HashMap<Object, String>) specialpoints);
        mySpritesOptions.add(OTHERS, (HashMap<Object, String>) others);
        myBackgroundImages = new HashMap<Object,String>();
    }

    //
    // public Map<Object, String> getSpriteMakingOptions() {
    // return spriteIcons;
    // }

    private ImageIcon getIcon (Sprite s) {
        return new ImageIcon(s.getDefaultImg().getScaledInstance(
                                                                 DEFAULT_SIZE, DEFAULT_SIZE,
                                                                 Image.SCALE_SMOOTH));
    }

    /**
     * Add a Sprite option, and organize the sprites based off their behavior.
     * This particular implementation is (manually) coupled with the interfaces
     * available in the interfaces package.
     * 
     * @param s - sample sprite
     * @param spriteID - id for communication with the model
     */
    public void addSpriteOption (Sprite s, int spriteID) {
        if (s instanceof IPlatform) {
            mySpritesOptions.get(PLATFORMS).put(getIcon(s), spriteID + "");
        }
        else if (s instanceof IEnemy) {
            mySpritesOptions.get(ENEMIES).put(getIcon(s), spriteID + "");
        }
        else if (s instanceof ICoin) {
            mySpritesOptions.get(COLLECTIBLES).put(getIcon(s), spriteID + "");
        }
        else if (s instanceof StartPoint || s instanceof IDoor) {
            mySpritesOptions.get(SPECIALPOINTS).put(getIcon(s), spriteID + "");
        }
        else {
            mySpritesOptions.get(OTHERS).put(getIcon(s), spriteID + "");
        }
    }

    // public Map<Object, String> getOtherOptions() {
    // return myOtherIcons;
    // }

    /**
     * 
     * @return
     */
    public List<? extends Map<Object, String>> getAllSprites () {
        return mySpritesOptions;
    }

    public Map<Object, String> getOtherOptions () {
        return myOtherImages;
    }

    public Map<Object, String> getBackgrounds () {
        return myBackgroundImages;
    }

    @Override
    public void paint (Graphics2D pen) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object getState () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LEToolsView initializeRenderer (IView parent) {
        return new LEToolsView(this, parent);
    }

    @Override
    public Object getActionLibrary () {
        return myActionLibrary;
    }

    public void addBackgrounds (Map<Integer, Image> backgrounds) {
        for (Integer key : backgrounds.keySet()) {
            myBackgroundImages.put(backgrounds.get(key), "" + key);
        }
    }

    // public void addBackgrounds (Map<Integer, Image> map) {
    // for (Integer key : map.keySet()) {
    // myBackgroundImages
    // .put(new ImageIcon(map.get(key).getScaledInstance(100, 100, Image.SCALE_SMOOTH)),
    // "" + key);
    // }
    // }

}
