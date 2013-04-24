package vooga.scroller.level_editor.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vooga.scroller.level_editor.LevelEditing;
import vooga.scroller.level_editor.commands.CommandConstants;
import vooga.scroller.level_editor.controllerSuite.GridSpinner;
import javax.swing.JButton;
import vooga.scroller.util.mvc.IView;
import vooga.scroller.util.mvc.vcFramework.Tools;

/**
 * EditorView is responsible for presenting editing tools to the user.
 * It provides a UI for the user to select various kind of sprites or
 * environment elements and add them to the actual level being edited.
 * 
 * @author Dagbedji Fagnisse
 * 
 */
public class LEToolsView extends TabbedToolsView<LevelEditing> {

    public class UpdateGridSizeListener implements ActionListener {
        
        @Override
        public void actionPerformed (ActionEvent e) {
            process(CommandConstants.CHANGE_GRID_SIZE + " " + 
                    myGridSpinner.getGridWidth() + ", " +
                    myGridSpinner.getGridHeight());
        }

    }

    /**
     * 
     */
    private static final long serialVersionUID = 143364586610264714L;
    

    private GridSpinner myGridSpinner;

    public LEToolsView (Tools<LevelEditing> leTools, IView<LevelEditing> parent) {
        super(leTools, parent);
        myGridSpinner = setGridSpinner();
        super.addSpecializedToolUI(myGridSpinner);
    }
    
    private GridSpinner setGridSpinner() {
        GridSpinner result = new GridSpinner();
        JButton validator = new JButton("Update Grid Size");
        validator.addActionListener(new UpdateGridSizeListener());
        result.add(validator);
        return result;
    }

    
    

}
