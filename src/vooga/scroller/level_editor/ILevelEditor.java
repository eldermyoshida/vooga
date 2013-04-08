package level_editor;

import util.Editable;

/**
 * Interface between a LevelEditor model and a Level Editor view.
 * This interface defines the behavior that any external component should
 * expect from a Level Editor entity (domain-specific).
 * 
 *  
 * Initial implementation: View can only pass a command to the LevelEditor.
 * 
 * @author Danny Goodman, Dagbedji Fagnisse
 *
 */
public interface ILevelEditor {

    
    public void processCommand (Editable m, String cmd);
    
}
