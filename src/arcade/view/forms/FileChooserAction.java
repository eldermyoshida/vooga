package arcade.view.forms;

import javax.swing.JFileChooser;

/**
 * An interface representing what can be done on a file chooser action.
 * 
 * This interface is expected to be implemented by an anonymous class.
 * 
 * @author Ellango
 *
 */
public interface FileChooserAction {
    /**
     * The action that should be done on approval of the file chooser.
     */
    abstract void approve(JFileChooser chooser);
}
