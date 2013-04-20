
package vooga.scroller.util.mvc;

import vooga.scroller.util.Renderable;
import vooga.scroller.util.mvc.vcFramework.Tools;
import vooga.scroller.util.mvc.vcFramework.WorkspaceView;

/**
 * This specific kind of view is intended to be the higher level view component
 * on a computer with GUI support. Its implementors are able to
 * <li>instantiate multiple workspaces</li>
 * <li>define a set of Tools to be used by all instances workspaces</li>
 * @author Dagbedji Fagnisse
 *
 */
public interface IWindow extends IView {

    WorkspaceView initializeWorkspaceView (int id, Renderable m);

    void showWorkspace (WorkspaceView associatedWorkspaceView, Renderable m);
    
    void setDefaultWorkspaceTools(Tools t);

}