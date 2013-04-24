
package vooga.scroller.level_editor.view;

import vooga.scroller.level_editor.LevelEditing;
import vooga.scroller.level_editor.controllerSuite.LEController;
import vooga.scroller.level_editor.controllerSuite.LEGrid;
import vooga.scroller.level_editor.controllerSuite.LETools;
import vooga.scroller.util.Renderable;
import vooga.scroller.util.mvc.vcFramework.Window;

/**
 * This class is a specialized Window (using the vcFramework) for LevelEditing.
 * As such it has the type parameters:
 * <li> LEWorkspaceView as the default workspace supported. </li>
 * <li> LevelEditing as the Domain Specific main resource. </li>
 * <li> LEGridView as the main renderer.</li>
 * <li> LETools as the toolbox that can be used to operate on the workspace items.</li>
 * @author Dagbedji Fagnisse
 */
public class LEView extends Window<LEWorkspaceView, LevelEditing, LEGridView, LETools> {


    private static final long serialVersionUID = 1L;
    private static final String SIMULATION_ERROR_MESSAGE = 
            LevelEditing.VIEW_CONSTANTS.SIMULATION_ERROR_MESSAGE;
    private static final String TITLE = 
            LevelEditing.VIEW_CONSTANTS.DOMAIN_NAME;

    /**
     * Default constructor - build a Window with the specified language and controller.
     * @param language - to be used for the GUI (and maybe domain keywords).
     * @param lEController - Specialized controller for level Editing.
     */
    public LEView (String language, LEController lEController, LETools t) {
        super(TITLE, language, lEController, t);
    }

    @Override
    public LEWorkspaceView initializeWorkspaceView (int id, Renderable<LevelEditing> r) {
        LEWorkspaceView res = new LEWorkspaceView(this, id, r, getTools());
        return res;
    }



    /**
     * Simulate the existing workspace data
     */
    public void simulate () {
        if (super.getActiveTab() instanceof LEWorkspaceView) {
            simulate((LEWorkspaceView)super.getActiveTab());
        }
    }


    /**
     * Get the active tab and simulate it if it is valid
     * @param tab
     */
    private void simulate (LEWorkspaceView tab) {
        if (tab.isValidForSimulation()) {
            ((LEGrid) tab.getRenderable()).simulate();
        }
        else 
            showMessageDialog(SIMULATION_ERROR_MESSAGE);
    }

    

    


}
