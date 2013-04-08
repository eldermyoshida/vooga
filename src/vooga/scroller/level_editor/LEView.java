package level_editor;

import javax.swing.JFrame;
import viewUtil.Renderable;
import viewUtil.Window;
import viewUtil.WorkspaceView;


public class LEView extends Window {
    

    private static final long serialVersionUID = 1L;
    private static final String TITLE = "Level Editor";
    
    public LEView (String language, LEController lEController, SpriteLibrary lib) {
        super(TITLE, language, lEController);
        // TODO Auto-generated constructor stub
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public WorkspaceView initializeWorkspaceView (int id) {
        return new LEWorkspaceView(id, this);
    }

    @Override
    protected void setMenu () {
        super.setMenu(new LEMenuBar(this));
    }

    @Override
    public void showWorkspace (WorkspaceView associatedWorkspaceView, Renderable r) {
        // TODO Auto-generated method stub
        super.addTab(associatedWorkspaceView, r);
    }

    @Override
    public void render (Renderable r) {
        getActiveTab().setRenderable(r);
        
    }

}
