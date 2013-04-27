
package vooga.scroller.util.mvc.vcFramework;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.Timer;
import vooga.scroller.level_editor.view.LEActionLibrary;


/**
 * This class is responsible for setting up the menu bar for a specific window.
 * @author Ross Cahoon, Dagbedji Fagnisse
 *
 */
@SuppressWarnings("serial")
public abstract class MenuBarView<D extends IDomainDescriptor> extends JMenuBar {
    private static final int DEFAULT_DELAY = 100;
    private Window<?, D, ?, ?> myWindow;
    D myDomain;
    private WindowActionLibrary myActionLibrary;
    private JMenu myFileMenu;
    private JMenu myEditMenu;
    private Timer myTimer;
    private List<JMenu> myCustomMenus;
    
    /**
     * Constructor for MenuBarView
     * @param window the parent view that component is inside of
     */
    
    public MenuBarView(Window<?, D, ?, ?> window) {
        myWindow = window;
        myDomain = window.getDomain();
        myActionLibrary = new WindowActionLibrary(myWindow);
        myCustomMenus = new ArrayList<JMenu>();
        setSpecializedWindow(myWindow);
        addCoreMenus();
        addDomainMenus();
        ActionListener prefListener =  new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                if (myWindow.getTabCount() > 0) {
                    enableWorkspaceDependentsMenus();
                }
            }
        };
        myTimer = new Timer(DEFAULT_DELAY, prefListener);
        myTimer.start();
        
    }

    private void addDomainMenus () {
        List<JMenu> menus = myDomain.getDomainSpecificMenus();
        addCustomMenus(menus);
    }

    /**
     * Any 
     */
    protected void addCoreMenus () {
            this.add(makeFileMenu());
            this.add(makeEditMenu());
    }
    
    protected abstract void setSpecializedWindow(Window<?, D, ?, ?> w);

    protected void addCustomMenus (List <JMenu> menus) {
        for(JMenu m: menus) {
            addCustomMenu(m);
        }
    }
    
    public void addCustomMenu (JMenu cm) {
        myCustomMenus.add(cm);
        this.add(cm);
    }

    /**
     * This menu is a generalized menu that handles all File actions.
     * @return - File Menu
     */
    private JMenu makeFileMenu() {
        JMenu result = new JMenu(Window.getResources().getString("FileMenu"));
        result.setMnemonic(KeyEvent.VK_F);
        result.add(myActionLibrary.new NewTabAction());
        result.add(myActionLibrary.new OpenFileAction());
        result.add(myActionLibrary.new SaveFileAction());
        result.add(new JSeparator());
        result.add(myActionLibrary.new QuitAction());
        myFileMenu = result;
        return myFileMenu;
    }
    
    /**
     * This menu mostly handles actions that apply to the whole active workspace.
     * @return
     */
    private JMenu makeEditMenu() {
        JMenu result = new JMenu(Window.getResources().getString("EditMenu"));
        result.setMnemonic(KeyEvent.VK_E);
        result.add(myActionLibrary.new UndoAction());
        result.add(myActionLibrary.new RedoAction());
        result.setEnabled(false);
        myEditMenu = result;
        return myEditMenu;
    }
    
    
    /**
     * Make the preferences menu active
     */
    private void enableWorkspaceDependentsMenus() {
        for (JMenu c: getCustomMenus()) {
            c.setEnabled(true);
        }
        myEditMenu.setEnabled(true);
    }

    protected List<JMenu> getCustomMenus () {
        return myCustomMenus;
    }

    
}
