package vooga.scroller.level_editor.controllerSuite;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import vooga.scroller.extra_resources.sprite_interfaces.ICollectible;
import vooga.scroller.extra_resources.sprite_interfaces.IEnemy;
import vooga.scroller.extra_resources.sprite_interfaces.IPlatform;
import vooga.scroller.level_editor.LevelEditing;
import vooga.scroller.level_editor.StartPoint;
import vooga.scroller.level_editor.commands.CommandConstants;
import vooga.scroller.level_editor.view.LEView;
import vooga.scroller.sprites.Sprite;
import vooga.scroller.sprites.interfaces.IDoor;
import vooga.scroller.util.IBackgroundView;
import vooga.scroller.util.Renderer;
import vooga.scroller.util.mvc.IView;
import vooga.scroller.util.mvc.vcFramework.Tools;
import vooga.scroller.util.mvc.vcFramework.Window;


/**
 * Toolbox specific to a level Editor.
 * This object contains all the necessary information to generate GUI items
 * specific to a LevelEditor
 * 
 * @author Dagbedji Fagnisse
 * 
 */
public class LETools extends Tools<LevelEditing> {

    private static final int DEFAULT_SIZE = 40;
    private static final int PLATFORMS = 0;
    private static final int ENEMIES = 1;
    private static final int COLLECTIBLES = 2;
    private static final int SPECIALPOINTS = 3;
    private static final int OTHERS = 4;
    private static final String BACKGROUND_CMD =  CommandConstants.CHANGE_BACKGROUND;
    private List<Map<Image, String>> mySpritesOptions;
//    private Map<Image, String> myBackgroundImages;
    private Map<String, Map<Image, String>> myOtherOptions;

    /**
     * Initialize state of this LETools.
     */
    public LETools () {
        mySpritesOptions = new ArrayList<Map<Image, String>>();
        Map<Image, String> platforms = new HashMap<Image, String>();
        Map<Image, String> enemies = new HashMap<Image, String>();
        Map<Image, String> collectibles = new HashMap<Image, String>();
        Map<Image, String> specialpoints = new HashMap<Image, String>();
        Map<Image, String> others = new HashMap<Image, String>();
        mySpritesOptions.add(PLATFORMS, platforms);
        mySpritesOptions.add(ENEMIES, enemies);
        mySpritesOptions.add(COLLECTIBLES, collectibles);
        mySpritesOptions.add(SPECIALPOINTS, specialpoints);
        mySpritesOptions.add(OTHERS, others);
        Map<Image, String> backgrounds = new HashMap<Image,String>();
        myOtherOptions = new HashMap<String, Map<Image, String>>();
        myOtherOptions.put(BACKGROUND_CMD, backgrounds);
    }
    
    private Image getImg (Sprite s) {
        return s.getDefaultImg();
    }


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
            mySpritesOptions.get(PLATFORMS).put(getImg(s), spriteID + "");
        }
        else if (s instanceof IEnemy) {
            mySpritesOptions.get(ENEMIES).put(getImg(s), spriteID + "");
        }
        else if (s instanceof ICollectible) {
            mySpritesOptions.get(COLLECTIBLES).put(getImg(s), spriteID + "");
        }
        else if (s instanceof StartPoint || s instanceof IDoor) {
            mySpritesOptions.get(SPECIALPOINTS).put(getImg(s), spriteID + "");
        }
        else {
            mySpritesOptions.get(OTHERS).put(getImg(s), spriteID + "");
        }
    }

    /**
     * 
     * @return
     */
    public List<Map<Image, String>> getAllSprites () {
        return mySpritesOptions;
    }


    public Map<Image, String> getBackgrounds () {
        return myOtherOptions.get(BACKGROUND_CMD);
    }


    public void addBackgrounds (Map<Integer, IBackgroundView> backgrounds) {
        for (Integer key : backgrounds.keySet()) {
            myOtherOptions.get(BACKGROUND_CMD).put(
                           backgrounds.get(key).getImage(), "" + key);
        }
    }

//
//    @Override
//    public TabbedToolsView initializeRenderer (IView parent) {
//        return new TabbedToolsView(this, parent);
//    }

    @Override
    public List<Map<Image, String>> getEditableDependents () {
        return getAllSprites();
    }

    @Override
    public Map<String, Map<Image, String>> getEditableIndependents () {
        return myOtherOptions;
    }

    @Override
    public String getEditableDependentsTitle () {
        return "Sprites";
    }

    @Override
    public String getEditableIndependentsTitle () {
        return "Other";
    }

    @Override
    public Renderer<LevelEditing> initializeRenderer (IView<?> parent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void paint (Graphics2D pen) {
        // TODO Auto-generated method stub
        
    }


}
