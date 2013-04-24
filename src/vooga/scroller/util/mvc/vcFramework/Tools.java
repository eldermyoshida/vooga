package vooga.scroller.util.mvc.vcFramework;

import java.awt.Image;
import java.util.List;
import java.util.Map;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import vooga.scroller.level_editor.view.TabbedToolsView;
import vooga.scroller.util.Renderable;
import vooga.scroller.util.mvc.IView;

/**
 * TO-DO defines a general tools class that is necessary for workspace
 * customization
 * V is a view able to render this tool
 * D is a domain descriptor
 * @author Dagbedji Fagnisse
 *
 */
public abstract class Tools<D extends IDomainDescriptor> implements Renderable<D> {
    
//    public abstract Object getActionLibrary();
    
    public abstract JMenuBar getMenu(Window<?, D, ?, ?> w);

//    public abstract V initializeRenderer (IView<D> parent);

    public abstract List<Map<Image, String>> EditableDependents ();

    public abstract Map<String, Map<Image, String>> getEditableIndependents ();

    public abstract String EditableDependentsTitle ();

    public abstract String getEditableIndependentsTitle ();
}
