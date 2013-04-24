
package vooga.scroller.level_editor.view;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import vooga.scroller.level_editor.LevelEditing;
import vooga.scroller.util.mvc.vcFramework.MenuBarView;
import vooga.scroller.util.mvc.vcFramework.Window;

/**
 * A specialized menubar for a Level Editor.
 * Note that default File and Edit Menu are inherited from the superclass.
 * @author Dagbedji Fagnisse
 *
 */
public class LEMenuBar extends MenuBarView<LevelEditing> {

    /**
     * 
     */
    private static final long serialVersionUID = -2714084580594858599L;

    private LEActionLibrary myLib;
    
    
    /**
     * Attach the menu to the specified window
     * @param window - window which is accessible via this menu
     */
    public LEMenuBar (LEView window) {
        super(window);
        List<JMenu> menus = new ArrayList<JMenu>();
        menus.add(makePreferencesMenu());
        super.addCustomMenus(menus);
    }

    /**
     * This menu handles actions that apply primarily to the current domain-specific
     * Renderable. 
     * @return
     */
    protected JMenu makePreferencesMenu () {
        JMenu result = new JMenu(Window.getResources().getString("PreferencesMenu"));
        result.setMnemonic(KeyEvent.VK_P);
        result.setEnabled(false);
        return result;
    }
    


    @Override
    protected void setSpecializedWindow (Window w) {
        myLib = new LEActionLibrary((LEView)w);
        
    }

}
