package vooga.scroller.util.mvc.vcFramework;

import java.util.List;
import java.util.Map;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import vooga.scroller.level_editor.view.TabbedToolsView;
import vooga.scroller.util.mvc.IView;

/**
 * TO-DO defines a general tools class that is necessary for workspace
 * customization
 * @author Dagbedji Fagnisse
 *
 */
public abstract class Tools<T extends WindowComponent> {
    
//    public abstract Object getActionLibrary();
    
    public abstract JMenuBar getMenu(Window w);

    public abstract T initializeRenderer (IView parent);

    public abstract List<? extends Map<Object, String>> EditableDependents ();

    public abstract Map<Object, String> getEditableIndependents ();

    public abstract String EditableDependentsTitle ();

    public abstract String getEditableIndependentsTitle ();

    public abstract String getEditableIndependentsKeyword ();
}
