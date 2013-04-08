package level_editor;

import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import viewUtil.MenuBarView;
import viewUtil.Window;

public class LEMenuBar extends MenuBarView {

    /**
     * 
     */
    private static final long serialVersionUID = -2714084580594858599L;

    public LEMenuBar (Window window) {
        super(window);
    }

    @Override
    protected JMenu makePreferencesMenu () {
        // TODO Auto-generated method stub
        JMenu result = new JMenu(Window.getResources().getString("PreferencesMenu"));
        result.setMnemonic(KeyEvent.VK_P);
        return result;
    }

    @Override
    protected JMenu makeHelpMenu () {
        // TODO Auto-generated method stub
        JMenu result = new JMenu(Window.getResources().getString("HelpMenu"));
        result.setMnemonic(KeyEvent.VK_H);
        return result;
    }

}
