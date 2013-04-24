
package vooga.scroller.level_editor.view;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import vooga.scroller.util.mvc.vcFramework.MenuBarView;
import vooga.scroller.util.mvc.vcFramework.Window;

/**
 * A specialized menubar for a Level Editor.
 * Note that default File and Edit Menu are inherited from the superclass.
 * @author Dagbedji Fagnisse
 *
 */
public class LEMenuBar extends MenuBarView {

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
        menus.add(makeHelpMenu());
        menus.add(makeSimulateMenu());
        super.addCustomMenus(menus);
    }

    @Override
    protected JMenu makePreferencesMenu () {
        // TODO - Add LEPreferences
        JMenu result = new JMenu(Window.getResources().getString("PreferencesMenu"));
        result.setMnemonic(KeyEvent.VK_P);
        result.setEnabled(false);
        return result;
    }

    @Override
    protected JMenu makeHelpMenu () {
        // TODO - Add LEHelp
        JMenu result = new JMenu(Window.getResources().getString("HelpMenu"));
        result.setMnemonic(KeyEvent.VK_H);
        result.setEnabled(true);
        return result;
    }
    
    private JMenu makeSimulateMenu () {
        JMenu result = new JMenu(Window.getResources().getString("SimulateMenu"));
        result.setMnemonic(KeyEvent.VK_F2);
        result.add(myLib.new SimulateAction());
        result.setEnabled(false);
        return result;
    }


    @Override
    protected void setSpecializedWindow (Window w) {
        // TODO Auto-generated method stub
        myLib = new LEActionLibrary((LEView)w);
        
    }

}
