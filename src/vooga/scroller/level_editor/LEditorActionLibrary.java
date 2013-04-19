
package vooga.scroller.level_editor;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

/**
 * 
 * TODO: Make sure this is not redundant with @Command notation
 * This class is intended to collect relevant actions that can be taken on
 * an instance of LEWorkspace and make them available to menus and view items
 * through this library.
 *
 */
public class LEditorActionLibrary {
    
private LEView myWindow;
    
    /**
     * Instantiate a Library for a specific window
     * @param w - window specified
     */
    public LEditorActionLibrary(LEView w) {
        myWindow = w;
    }
    
    private String getLiteral (String s) {
        return LEView.getLiteral(s);
    }
    
    public class SimulateAction extends AbstractAction {
        
        public SimulateAction () {
            super(getLiteral("SimulateMenu"));
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                                     KeyEvent.VK_F5, ActionEvent.ALT_MASK));
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            // TODO Auto-generated method stub
            myWindow.simulate();
        }
    }

}
