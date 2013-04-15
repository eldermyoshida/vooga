package vooga.scroller.level_editor;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JScrollPane;
import vooga.scroller.level_editor.commands.CommandConstants;
import vooga.scroller.util.Editable;
import vooga.scroller.viewUtil.EasyGridFactory;
import vooga.scroller.viewUtil.IView;
import vooga.scroller.viewUtil.IWindow;
import vooga.scroller.viewUtil.Renderable;
import vooga.scroller.viewUtil.Tools;
import vooga.scroller.viewUtil.WorkspaceView;


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
    private Dimension myOriginalGridSize;
    private LEGridView myLevelView;
    private LEToolsView myEditorView;
    private JScrollPane myLevelGridScroller;

    public LEWorkspaceView (IView host, double numHBlocks, double numVBlocks) {
        super(host);
        myOriginalGridSize = new Dimension(
                                 (int)numHBlocks*LEGrid.DEFAULT_SPRITE_SIZE,
                                 (int)numVBlocks*LEGrid.DEFAULT_SPRITE_SIZE);
    }

    public LEWorkspaceView (int id, IView host) {
        // TODO Auto-generated constructor stub
        super(id, host);
    }

    public LEWorkspaceView (LEView host, int id, Renderable r) {
        // TODO Auto-generated constructor stub
        super(id, host);
        myRenderable = r;
        myLevelView = new LEGridView(this, r);
        myEditorView = new LEToolsView(this, .2, 1.0);
        myLevelGridScroller = new JScrollPane(myLevelView, 
                                  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        EasyGridFactory.layout(this, myLevelGridScroller, myEditorView);
    }

    @Override
    protected void initializeVariables () {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void addComponents () {
        // TODO Add other comp.
        // EasyGridFactory.layoutHorizontal(this, myLevelView, myEditorView);
        
//        add(myLevelGridScroller);
        
    }

    @Override
    public void render (Renderable r) {
        // TODO Auto-generated method stub !!!
        myLevelView.render(r);
    }

    @Override
    public void setRenderable (Renderable r) {
        // TODO Auto-generated method stub
        myRenderable = r;
        // myRenderableHistory.add(renderableRoom);
        render(myRenderable);
    }

    @Override
    public void process (Object isn) {
        if (isn instanceof String) {
            String cmd = (String) isn;
            switch (getCommand(cmd)) {
                case CommandConstants.CREATE_SPRITE:
                    cmd = cmd + CommandConstants.SPACE + myEditorView.getSelectedSpriteID();
                    break;
                default: // TODO add more cases for other commands
                    break;
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

}
