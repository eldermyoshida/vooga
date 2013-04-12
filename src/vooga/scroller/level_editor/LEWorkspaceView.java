
package vooga.scroller.level_editor;

import java.awt.Container;
import java.awt.Point;
import vooga.scroller.util.Editable;
import vooga.scroller.viewUtil.EasyGridFactory;
import vooga.scroller.viewUtil.IView;
import vooga.scroller.viewUtil.IWindow;
import vooga.scroller.viewUtil.Renderable;
import vooga.scroller.viewUtil.Tools;
import vooga.scroller.viewUtil.WorkspaceView;

/**
 * This class is a specialized Workspace for a Level Editor.
 * @author Dagbedji Fagnisse
 *
 */
public class LEWorkspaceView extends WorkspaceView {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Renderable myRenderable;
    private LEGridView myLevelView;
    private LEToolsView myEditorView;

    public LEWorkspaceView (IView host) {
        super(host);
        // TODO Auto-generated constructor stub
    }

    public LEWorkspaceView (int id, IView host) {
        // TODO Auto-generated constructor stub
        super(id, host);
    }




    @Override
    protected void initializeVariables () {
        // TODO Auto-generated method stub
        myLevelView = new LEGridView(this, .8, 1.0);
        myEditorView = new LEToolsView(this, .2, 1.0);
    }

    @Override
    protected void addComponents () {
        // TODO Add other comp.
//        EasyGridFactory.layoutHorizontal(this, myLevelView, myEditorView);
        EasyGridFactory.layout(this, myLevelView, myEditorView);
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
//        myRenderableHistory.add(renderableRoom);
        render(myRenderable);
    }

    @Override
    public void process (Object isn) {
        // TODO - Need to refactor
        String res=new String();
        if (isn instanceof Point) {
            Point a = (Point)isn;
            res = "createSprite "+ myEditorView.getSelectedSpriteID()
                    +" "+a.x+" "+a.y;
        }
        super.process(res);
    }
    
    //TODO - Good design choice??
    public static void setTools(Tools t) {
        WorkspaceView.setTools(t);
    }

}