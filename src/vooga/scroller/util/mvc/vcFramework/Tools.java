package vooga.scroller.util.mvc.vcFramework;

import javax.swing.JMenuBar;
import vooga.scroller.level_editor.view.LEToolsView;
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

}
