
package vooga.scroller.level_editor;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import vooga.scroller.sprites.superclasses.NonStaticEntity;
import vooga.scroller.sprites.superclasses.StaticEntity;
import vooga.scroller.sprites.test_sprites.MarioLib;
import vooga.scroller.util.Editable;
import vooga.scroller.util.Location;
import vooga.scroller.util.Sprite;
import vooga.scroller.viewUtil.IWindow;
import vooga.scroller.viewUtil.Renderable;
import vooga.scroller.viewUtil.WorkspaceView;

/**
 * The controller is responsible for interfacing between an IView and an IModel.
 * Among other things, it is responsible for 
 * <LI> Instantiating a generic model and a view
 * <LI> Keeping track of multiple high-level domain-specific objects (eg. Room, Level...)
 * <LI> Send Renderable versions to the adequate IView workspace
 * <LI> Send Editable versions to the Model
 * <LI> Ensuring that all high-level domain instances are kept in sync.
 * @author SLogo team 3, Dagbedji F.
 *
 */

public class LEController {

    private IWindow myView;
    private ILevelEditor myModel;
    private Map<Editable, WorkspaceView> myWorkspace2Tab;
    private Map<WorkspaceView, Editable> myTab2Workspace;
    private static final int DEFAULT_SPRITE_GRID_SIZE = 10;
    private Map<Integer, Sprite> m;
    
    /**
     * Constructor
     */
    public LEController(MarioLib lib) {
        m = new HashMap<Integer, Sprite>();
        m = (new ToolsMaker(lib)).getTools();
       //TODO
        for(int k:m.keySet()) {
            System.out.println(m.get(k).getClass());
        }
        String language = getLanguage();
        myModel = new LevelEditor(language,lib);
        myView = new LEView(language, this, lib);
        myWorkspace2Tab = new HashMap<Editable, WorkspaceView>();
        myTab2Workspace = new HashMap<WorkspaceView, Editable>();
    }

    private String getLanguage () {
        String[] languages = {"English", "French"};
        int n = JOptionPane.showOptionDialog(null,
                            "Choose a language", "Language Selection",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, languages, languages[0]);
        String language = languages[n];
        return language;
    }
    
    /**
     * Initialize the GUI.
     */

    public void start() {
        //Welcome message
//        myView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        myView.pack();
//        myView.setVisible(true);
    }
   

    /**
     * Load a file in a specific tab - TODO
     * @param f - File to be loaded.
     * @param t - Tab where file is to be loaded.
     */
    public void loadFile (WorkspaceView t, File f) {

    }

    /**
     * return the Room Object corresponding to the input TabView
     * @param t
     * @return
     */
    private Editable getModelForWorkspace (WorkspaceView v) {
        return myTab2Workspace.get(v);
    }

    private WorkspaceView getViewForWorkspace (Editable m) {
        return myWorkspace2Tab.get(m);
    }


    /**
     * calls model to process the input string command
     * @param t - 
     * @param cmd - command to process
     * @return ret - return int from command process
     */
    public void processCommand (WorkspaceView t, String cmd) {
        Editable m = getModelForWorkspace(t);
        myModel.processCommand(m, cmd);
        t.setRenderable((Renderable) m);
    }

    
    /**
     * Add a new workspace with id based on already existing workspaces.
     */
    public void initializeWorkspace() {
        int id = myWorkspace2Tab.size();
        initializeWorkspace(id);
    }

    /**
     * Initialize a room with the ID provided
     * also initialize a corresponding Tab in the view.
     * @param id
     */
    private void initializeWorkspace (int id) {
        Editable m = new LEGrid(DEFAULT_SPRITE_GRID_SIZE,DEFAULT_SPRITE_GRID_SIZE);;
        WorkspaceView associatedWorkspaceView = myView.initializeWorkspaceView(id);
        myWorkspace2Tab.put(m, associatedWorkspaceView);
        myTab2Workspace.put(associatedWorkspaceView, m);
        myView.showWorkspace(associatedWorkspaceView, (Renderable) m);
    }

}
