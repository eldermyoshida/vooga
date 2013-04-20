package vooga.scroller.level_editor.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JScrollPane;
import vooga.scroller.level_editor.commands.CommandConstants;
import vooga.scroller.util.Editable;
import vooga.scroller.util.mvc.IView;
import vooga.scroller.util.mvc.IWindow;
import vooga.scroller.util.mvc.vcFramework.Renderable;
import vooga.scroller.util.mvc.vcFramework.Tools;
import vooga.scroller.util.mvc.vcFramework.WorkspaceView;
import vooga.scroller.viewUtil.EasyGridFactory;


/**
 * This class is a specialized Workspace for a Level Editor.
 * 
 * @author Dagbedji Fagnisse
 * 
 */
public class LEWorkspaceView extends WorkspaceView {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Renderable myRenderable;
    private LEGridView myGridView;
    private LEToolsView myToolsView;
    private JScrollPane myLevelGridScroller;

    /**
     * Create a Workspace with the specified host, id, and renderable
     * 
     * @param host - parent containing this workspace, typically a Window
     * @param id - containing tab
     * @param r - Renderable to be loaded in this workspace.
     */
    public LEWorkspaceView (LEView host, int id, Renderable r) {
        // TODO Auto-generated constructor stub
        super(id, host);
        myRenderable = r;
        myGridView = new LEGridView(this, r);
        myToolsView = new LEToolsView(this);
        myLevelGridScroller = new JScrollPane(myGridView,
                                              JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                              JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        EasyGridFactory.layout(this, myLevelGridScroller, myToolsView);
    }

    @Override
    public void render (Renderable r) {
        // TODO Auto-generated method stub !!!
        myGridView.render(r);
    }

    @Override
    public void setRenderable (Renderable r) {
        // TODO Auto-generated method stub
        myRenderable = r;
        render(myRenderable);
    }

    @Override
    public void process (Object isn) {
        if (isn instanceof String) {
            String cmd = (String) isn;
            if (getCommand(cmd).equals(CommandConstants.CREATE_SPRITE)) {
                cmd = cmd + CommandConstants.SPACE + myToolsView.getSelectedSpriteID();
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

    // TODO - Good design choice??
    public static void setTools (Tools t) {
        WorkspaceView.setTools(t);
    }

    public boolean isValidForSimulation () {
        return myGridView.isValidForSimulation();
    }

}
