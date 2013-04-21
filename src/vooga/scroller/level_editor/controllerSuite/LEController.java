
package vooga.scroller.level_editor.controllerSuite;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import vooga.scroller.level_editor.ILevelEditor;
import vooga.scroller.level_editor.library.IBackgroundLibrary;
import vooga.scroller.level_editor.library.ISpriteLibrary;
import vooga.scroller.level_editor.model.LevelEditor;
import vooga.scroller.level_editor.model.LevelParser;
import vooga.scroller.level_editor.model.LevelWriter;
import vooga.scroller.level_editor.view.LEGridView;
import vooga.scroller.level_editor.view.LEView;
import vooga.scroller.level_editor.view.LEWorkspaceView;
import vooga.scroller.level_editor.view.LevelEditing;
import vooga.scroller.sprites.test_sprites.MarioLib;
import vooga.scroller.util.Editable;
import vooga.scroller.util.Renderable;
import vooga.scroller.util.mvc.IController;
import vooga.scroller.util.mvc.IWindow;
import vooga.scroller.util.mvc.vcFramework.WorkspaceView;

/**
 * The controller is responsible for interfacing between an IView and an IModel.
 * Among other things, it is responsible for 
 * <LI> Instantiating a generic model and a view </LI>
 * <LI> Keeping track of multiple high-level domain-specific objects (eg. Room, Level...)</LI>
 * <LI> Send Renderable versions to the adequate IView workspace</LI>
 * <LI> Send an "Editable" versions to the Model</LI>
 * <LI> Ensuring that all high-level domain instances are kept in sync.
 * @author SLogo team 3, Dagbedji F.
 *
 */

public class LEController implements IController<LevelEditing> {

    private IWindow<LEWorkspaceView, LevelEditing, LEGridView, LETools> myView;
    private ILevelEditor myModel;
    private Map<Editable, WorkspaceView<LevelEditing>> myWorkspace2Tab;
    private Map<WorkspaceView<LevelEditing>, Editable> myTab2Workspace;
    private static final int DEFAULT_SPRITE_GRID_SIZE = 30;
    private ToolsManager myToolsManager;
    private LETools myTools;
    private LevelWriter myLevelWriter;
    private LevelParser myLevelReader;
    private LevelEditing myDomainInfo;
    
    /**
     * Constructor
     * @param backgroundLib 
     */
    public LEController(ISpriteLibrary lib, IBackgroundLibrary bgLib) {
        myDomainInfo = new LevelEditing();
        String language = getLanguage();
        myModel = new LevelEditor(language);
        myView = new LEView(language, this);
        myToolsManager = new ToolsManager(lib,bgLib, myView);
        myModel.setSpriteMap(myToolsManager.getSpriteMap());
        myModel.setBackgroundMap(bgLib.getBackgrounds());
        myTools = myToolsManager.getViewTools();
        myView.setDefaultWorkspaceTools(myTools);
        myWorkspace2Tab = new HashMap<Editable, WorkspaceView<LevelEditing>>();
        myTab2Workspace = new HashMap<WorkspaceView<LevelEditing>, Editable>();
        myLevelWriter = new LevelWriter();
        myLevelReader = new LevelParser();
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
    
    /* (non-Javadoc)
     * @see vooga.scroller.level_editor.controllerSuite.IController#start()
     */

    @Override
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

    
    /* (non-Javadoc)
     * @see vooga.scroller.level_editor.controllerSuite.IController#initializeWorkspace(int, int)
     */
    public void initializeWorkspace(int numWidthBlocks, int numHeightBlocks) {
        int id = myWorkspace2Tab.size();
        initializeWorkspace(id, numWidthBlocks, numHeightBlocks);
    }
    
    /* (non-Javadoc)
     * @see vooga.scroller.level_editor.controllerSuite.IController#initializeWorkspace()
     */
    @Override
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
        LEGrid m = new LEGrid(DEFAULT_SPRITE_GRID_SIZE,DEFAULT_SPRITE_GRID_SIZE);;
        createWorkspaceView(id, m);
    }

    /**
     * @param id
     * @param m
     */
    private void createWorkspaceView (int id, LEGrid m) {
        LEWorkspaceView associatedWorkspaceView = 
                myView.initializeWorkspaceView(id, (Renderable<LEGridView>) m);
        myWorkspace2Tab.put(m, associatedWorkspaceView);
        myTab2Workspace.put(associatedWorkspaceView, m);
        myView.showWorkspace(associatedWorkspaceView, (Renderable<LEGridView>) m);
       }
    
    private void initializeWorkspace(int id, int numWidthBlocks, int numHeightBlocks) {
        LEGrid m = new LEGrid(numWidthBlocks, numHeightBlocks);
        createWorkspaceView(id, m);
    }

    @Override
    public void saveFile (File file2save, WorkspaceView<LevelEditing> t) {
        LEGrid grid = (LEGrid) getModelForWorkspace(t);
        myLevelWriter.createFile(file2save, grid, myToolsManager.getSpriteLibPath());
        
    }

    @Override
    public LevelEditing getDomainInfo () {
        return myDomainInfo;
    }

    @Override
    public void loadFile (File file2open) {
        LEGrid m = myLevelReader.makeGridFromFile(file2open);
        int id = myWorkspace2Tab.size();
        createWorkspaceView(id, m);
    }

    @Override
    public void process (WorkspaceView<LevelEditing> t, Object cmd) {
        LEGrid m = (LEGrid) getModelForWorkspace(t);
        System.out.println("Controller got "+ cmd);
        if(cmd instanceof String) {
            myModel.processCommand(m, (String)cmd);
        }
        t.setRenderable((Renderable<?>) m);
    }

}
