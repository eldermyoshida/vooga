
package vooga.scroller.level_editor.view;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vooga.scroller.level_editor.controllerSuite.LEController;
import vooga.scroller.level_editor.library.ISpriteLibrary;
import vooga.scroller.util.Renderable;
import vooga.scroller.util.mvc.vcFramework.Tools;
import vooga.scroller.util.mvc.vcFramework.Window;
import vooga.scroller.util.mvc.vcFramework.WorkspaceView;


public class LEView extends Window {
    

    private static final long serialVersionUID = 1L;
    private static final String TITLE = "Level Editor";
    
    public static class CONSTANTS {
        static final double DEFAULT_GRIDVIEW_HEIGHT_RATIO = .95;
        static final double DEFAULT_GRIDVIEW_WIDTH_RATIO = .7;
        static final double DEFAULT_TOOLSVIEW_HEIGHT_RATIO = .9;
        static final double DEFAULT_TOOLSVIEW_WIDTH_RATIO = .25;
    }
    
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
    
    public void setDefaultWorkspaceTools(Tools t) {
        LEWorkspaceView.setTools(t);
    }
    
    /**
     * Get the active tab and simulate it if it is valid
     * @param tab
     */
    private void simulate (LEWorkspaceView tab) {
        if (tab.isValidForSimulation()) { //TODO
            tab.getRenderable().simulate();
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

    @Override
    public void render (Renderable<?> r) {
        // TODO Auto-generated method stub
        
    }

}
