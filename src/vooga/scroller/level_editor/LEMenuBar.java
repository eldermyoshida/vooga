
package vooga.scroller.level_editor;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import vooga.scroller.viewUtil.MenuBarView;
import vooga.scroller.viewUtil.Window;

public class LEMenuBar extends MenuBarView {

    /**
     * 
     */
    private static final long serialVersionUID = -2714084580594858599L;

    private List<JMenu> myMenus;
    
    public LEMenuBar (Window window) {
        super(window);
    }

    @Override
    protected JMenu makePreferencesMenu () {
        // TODO Auto-generated method stub
        JMenu result = new JMenu(Window.getResources().getString("PreferencesMenu"));
        result.setMnemonic(KeyEvent.VK_P);
        result.setEnabled(false);
        return result;
    }

    @Override
    protected JMenu makeHelpMenu () {
        // TODO Auto-generated method stub
        JMenu result = new JMenu(Window.getResources().getString("HelpMenu"));
        result.setMnemonic(KeyEvent.VK_H);
        result.setEnabled(true);
        return result;
    }

    @Override
    protected void addCustomMenus () {
        myMenus = new ArrayList<JMenu>();
        addCustomMenu(makePreferencesMenu());
        addCustomMenu(makeHelpMenu());
    }

    private void addCustomMenu (JMenu cm) {
        myMenus.add(cm);
        this.add(cm);
        
    }

    @Override
    protected List<JMenu> getWorkspaceMenus () {
        // TODO Auto-generated method stub
        return myMenus;
    }

}
