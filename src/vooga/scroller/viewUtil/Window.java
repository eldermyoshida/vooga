
package vooga.scroller.viewUtil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import vooga.scroller.level_editor.LEController;
import vooga.scroller.viewUtil.Renderable;

/**
 * The manager for all the views of the application
 * @author Ross Cahoon, Dagbedji Fagnisse
 *
 */
@SuppressWarnings("serial")
public abstract class Window extends JFrame implements IWindow, IView {

    private static ResourceBundle ourResources;
    private static final String DEFAULT_RESOURCE_PACKAGE = "vooga.scroller.resources.";
    private static final String USER_DIR = "user.dir";
    private LEController myController;
    private JTabbedPane myTabbedPane;
    private JMenuBar myMenuBar;
    private JFileChooser myChooser;
    private Dimension mySize = ViewConstants.DEFAULT_WINDOW_SIZE;
    
    /**
     * Constructor for Window
     * @param title The title of the View
     * @param language The display language for the window
     * @param lEController The Controller responsible for this view
     */
    public Window (String title, String language, LEController lEController) {
        super(title);
        this.setResizable(false);
        setPreferredSize(mySize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myController=lEController;
        // create and arrange sub-parts of the GUI
        ourResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        //tabs
        getContentPane().setLayout(new GridBagLayout());
        setMenu();
        addComponents();
        pack();
        setVisible(true);
    }    

    protected abstract void setMenu ();

    /**
     * Way to initialize tab creation from the window
     */
    public void addTab() {
        myController.initializeWorkspace();
    }

    private void addComponents() {
        myTabbedPane = new JTabbedPane();
        setJMenuBar(myMenuBar);
        EasyGridFactory.layoutHorizontal(this, myTabbedPane);
    }

    protected void setMenu (JMenuBar menu) {
        myMenuBar = menu;
    }

    /**
     * Adds a tab to the view
     * @param tab The tab to be added
     * @param p The Renderable that it is associated with
     */
    public void addTab (WorkspaceView tab, Renderable p) {
        myTabbedPane.addTab(getLiteral("TabTitle") + " " + (tab.getID() + 1), tab);
        tab.setRenderable(p);
    }
    /**
     * Returns the JFileChooser for this View
     * @return
     */
    public JFileChooser getChooser () {
        return myChooser;
    }

    /**
     * Close the window
     */
    public void quit () {
        WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
    }
    
    /**
     * Save the active workspace - TODO
     */
    public void saveFile () {
        int response = myChooser.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file2save = myChooser.getSelectedFile();
            saveFile(file2save);
        }
        return;
    }

    private void saveFile (File file2save){
        myController.saveFile(file2save, getActiveTab());
    }

    /**
     * Load the specified file in a new tab - TODO
     * @param file2open
     */
    private void loadFile (File file2open){
        myController.loadFile(file2open);
    }

    /**
     * Called by a TabView child view that will request a string to be processed as a Command
     * @param tabView The Tabview that is requesting the string to be processed
     * @param s The string to be processed
     */
    public void process (WorkspaceView tabView, Object o) {
        myController.process(tabView, o);
    }
    
    /**
     * Called by a non TabView child view that will request a string to be processed as a Command
     * Uses the active tab
     * @param s The string to be processed
     */
    public void process (Object o) {
        process(getActiveTab(), o);
    }
    
    protected WorkspaceView getActiveTab() {
        return (WorkspaceView) myTabbedPane.getSelectedComponent();
    }

    /**
     * Gets the resource bundle
     *
     */
    public static ResourceBundle getResources() {
        return ourResources;
    }
    
    /**
     * Helper Method available to lookup values in the Resources
     * @param s - string literal to be looked up (key)
     * @return the string literal specified in the relevant properties file
     */
    public static String getLiteral(String s) {
        return Window.ourResources.getString(s);
    }
    
    /**
     * To be refactored, used to delegate logic for retrieving current pen color
     * @return
     */
    public Color getCurrentPenColor() {
        return Color.BLACK;
    }

    /**
     * Initiate the opening of a file
     */
    public void openFile () {
        int response = myChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file2open = myChooser.getSelectedFile();
            loadFile(file2open);
        }
    }

    /**
     * Initiate the change of background
     */
    public void changeBackground() {
        int response = myChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            Image img;
            try {
                img = ImageIO.read(myChooser.getSelectedFile());
                WorkspaceView temp = getActiveTab();
                if (temp != null) {
                    temp.setBackground(img);
                }
            }
            catch (java.io.IOException er) {
//                System.out.println(er.getMessage());
            }
        }
    }
    
    /**
     * Toggle the grid off or on
     */
    public void toggleGrid() {
        WorkspaceView temp = getActiveTab();
        if (temp != null) {
            temp.toggleGrid();
        }
    }
    
    
    /**
     * 
     * @return - number of tabs
     */
    public int getTabCount() {
        return myTabbedPane.getTabCount();
    }
    
    /**
     * Undo last action for active workspace
     */
    public void undo () {
        getActiveTab().undo();
    }
    
    /**
     * redo last (undone) action for active worspace
     */
    public void redo () {
        getActiveTab().redo();
    }

    public WorkspaceView initializeWorkspaceView (int id, Renderable r) {
        // TODO Auto-generated method stub
        return null;
    }
}
