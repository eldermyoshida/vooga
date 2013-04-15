
package vooga.scroller.level_editor;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vooga.scroller.viewUtil.Renderable;
import vooga.scroller.viewUtil.Tools;
import vooga.scroller.viewUtil.Window;
import vooga.scroller.viewUtil.WorkspaceView;


public class LEView extends Window {
    

    private static final long serialVersionUID = 1L;
    private static final String TITLE = "Level Editor";
    
    public LEView (String language, LEController lEController, ISpriteLibrary lib) {
        super(TITLE, language, lEController);
        // TODO Auto-generated constructor stub
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public WorkspaceView initializeWorkspaceView (int id, Renderable r) {
        LEWorkspaceView res = new LEWorkspaceView(this, id, r);
        return res;
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
    
    public void setDefaultWorkspaceTools(Tools t) {
        LEWorkspaceView.setTools(t);
    }
    
    /**
     * Get the active tab and simulate it if it is valid
     * @param tab
     */
    private void simulate (LEWorkspaceView tab) {
        if (tab.isValidForSimulation()) {
            //TODO
        }
        else 
            JOptionPane.showMessageDialog(this, 
                                          getLiteral("SimulationError"));
    }

    /**
     * Simulate the existing workspace data
     */
    public void simulate () {
        if (super.getActiveTab() instanceof LEWorkspaceView) {
            simulate((LEWorkspaceView)super.getActiveTab());
        }
    }

}
