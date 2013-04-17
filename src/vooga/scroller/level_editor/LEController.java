
package vooga.scroller.level_editor;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import vooga.scroller.sprites.test_sprites.MarioLib;
import vooga.scroller.util.Editable;
import vooga.scroller.viewUtil.IWindow;
import vooga.scroller.viewUtil.Renderable;
import vooga.scroller.viewUtil.WorkspaceView;

/**
 * The controller is responsible for interfacing between an IView and an IModel.
 * Among other things, it is responsible for 
 * <LI> Instantiating a generic model and a view </LI>
 * <LI> Keeping track of multiple high-level domain-specific objects (eg. Room, Level...)</LI>
 * <LI> Send Renderable versions to the adequate IView workspace</LI>
 * <LI> Send Editable versions to the Model</LI>
 * <LI> Ensuring that all high-level domain instances are kept in sync.
 * @author SLogo team 3, Dagbedji F.
 *
 */

public class LEController {

    private IWindow myView;
    private ILevelEditor myModel;
    private Map<Editable, WorkspaceView> myWorkspace2Tab;
    private Map<WorkspaceView, Editable> myTab2Workspace;
    private static final int DEFAULT_SPRITE_GRID_SIZE = 30;
    private ToolsManager myToolsManager;
    private LevelWriter myLevelWriter;
    private LevelParser myLevelParser;
    
    /**
     * Constructor
     */
    public LEController(ISpriteLibrary lib) {
        myToolsManager = new ToolsManager(lib);
        String language = getLanguage();
        myModel = new LevelEditor(language,lib);
        myModel.setSpriteMap(myToolsManager.getSpriteMap());
        myView = new LEView(language, this, lib);
        myView.setDefaultWorkspaceTools(myToolsManager.getViewTools());
        myWorkspace2Tab = new HashMap<Editable, WorkspaceView>();
        myTab2Workspace = new HashMap<WorkspaceView, Editable>();
        myLevelWriter = new LevelWriter();
        myLevelParser = new LevelParser();
        myLevelParser.setNameMap(myToolsManager.getNameMap());
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


    public void saveFile (File file2save, WorkspaceView t) {
        LEGrid grid = (LEGrid) getModelForWorkspace(t);
        myLevelWriter.createFile(file2save,grid);
    }

    public void loadFile (File file2open) {
        Editable m = myLevelParser.makeGridFromFile(file2open);
        int id = myWorkspace2Tab.size();
        createWorkspaceView(id, m);
    }

    /**
     * calls model to process the input string command
     * @param t - 
     * @param cmd - command to process
     * @return ret - return int from command process
     */
    public void process (WorkspaceView t, Object cmd) {
        Editable m = getModelForWorkspace(t);
        System.out.println("Controller got "+ cmd);
        if(cmd instanceof String) {
            myModel.processCommand(m, (String)cmd);
        }
        t.setRenderable((Renderable) m);
    }

    
    /**
     * Add a new workspace with id based on already existing workspaces.
     */
    public void initializeWorkspace(int numWidthBlocks, int numHeightBlocks) {
        int id = myWorkspace2Tab.size();
        initializeWorkspace(id, numWidthBlocks, numHeightBlocks);
    }
    
    /**
     * Add a new workspace with id based on already existing workspaces.
     */
    public void initializeWorkspace() {
        int id = myWorkspace2Tab.size();
        int [] size = getNumBlocks();
        initializeWorkspace(id, size[0], size[1]);
    }

    /**
     * TODO - get info via dialog box
     * @return
     */
    private int[] getNumBlocks () {
        int[] res = new int[2];
        res[0]= 60;
        res[1]= 30;
        return res;
    }

    /**
     * Initialize a room with the ID provided
     * also initialize a corresponding Tab in the view.
     * @param id
     */
    private void initializeWorkspace (int id) {
        Editable m = new LEGrid(DEFAULT_SPRITE_GRID_SIZE,DEFAULT_SPRITE_GRID_SIZE);;
        createWorkspaceView(id, m);
    }

    /**
     * @param id
     * @param m
     */
    private void createWorkspaceView (int id, Editable m) {
        WorkspaceView associatedWorkspaceView = 
                myView.initializeWorkspaceView(id, (Renderable) m);
        myWorkspace2Tab.put(m, associatedWorkspaceView);
        myTab2Workspace.put(associatedWorkspaceView, m);
        myView.showWorkspace(associatedWorkspaceView, (Renderable) m);
       }
    
    private void initializeWorkspace(int id, int numWidthBlocks, int numHeightBlocks) {
        Editable m = new LEGrid(numWidthBlocks, numHeightBlocks);
        createWorkspaceView(id, m);
    }

}
