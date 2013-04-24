package vooga.scroller.level_editor.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JScrollPane;
import vooga.scroller.level_editor.Level;
import vooga.scroller.level_editor.LevelEditing;
import vooga.scroller.level_editor.commands.CommandConstants;
import vooga.scroller.level_editor.controllerSuite.LEGrid;
import vooga.scroller.level_editor.controllerSuite.LETools;
import vooga.scroller.util.Editable;
import vooga.scroller.util.Renderable;
import vooga.scroller.util.Renderer;
import vooga.scroller.util.mvc.IView;
import vooga.scroller.util.mvc.IWindow;
import vooga.scroller.util.mvc.vcFramework.Tools;
import vooga.scroller.util.mvc.vcFramework.WorkspaceView;
import vooga.scroller.viewUtil.EasyGridFactory;


/**
 * This class is a specialized Workspace for a Level Editor.
 * 
 * @author Dagbedji Fagnisse
 * 
 */
public class LEWorkspaceView extends WorkspaceView<LevelEditing> 
                            implements Renderer<LevelEditing>{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Renderer<LevelEditing> myGridView;
    private TabbedToolsView myToolsView;
    private JScrollPane myLevelGridScroller;
    private JScrollPane myToolsScroller;

    /**TODO - Redesign to get rid of casts...
     * Create a Workspace with the specified host, id, and renderable
     * 
     * @param host - parent containing this workspace, typically a Window
     * @param id - containing tab
     * @param r - Renderable to be loaded in this workspace.
     */
    public LEWorkspaceView (LEView host, int id, 
                            Renderable<LevelEditing> grid, Tools<LevelEditing> tools) {
        super(id, host);
        myGridView = grid.initializeRenderer(this);
        myToolsView = new TabbedToolsView<LevelEditing>(tools, this);
        myLevelGridScroller = new JScrollPane((LEGridView) myGridView,
                                              JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                              JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        myToolsScroller = new JScrollPane(myToolsView,
                                              JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                              JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        EasyGridFactory.layout(this, myLevelGridScroller, myToolsScroller);
    }

    @Override
    public void process (Object isn) {
        if (isn instanceof String) {
            String cmd = (String) isn;
            if (getCommand(cmd).equals(CommandConstants.CREATE_SPRITE)) {
                cmd = cmd + CommandConstants.SPACE + myToolsView.getSelectedEditableDependent();
            }
            super.process(cmd);
        }
        else {
            super.process(isn);
        }
    }

    private String getCommand (String cmd) {
        return cmd.split(CommandConstants.SPACE)[0];
    }


    public boolean isValidForSimulation () {
        return ((LEGridView) myGridView).isValidForSimulation();
    }


    @Override
    public void render (Renderable<LevelEditing> grid) {
        myGridView.render(grid);
    }

    @Override
    public void setRenderable (Renderable<LevelEditing> grid) {
        myGridView.setRenderable(grid);
        
    }

    @Override
    public Renderable<LevelEditing> getRenderable () {
        return myGridView.getRenderable();
    }

}
