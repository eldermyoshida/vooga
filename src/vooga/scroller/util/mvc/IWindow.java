
package vooga.scroller.util.mvc;

import vooga.scroller.util.Renderable;
import vooga.scroller.util.mvc.vcFramework.IDomainDescriptor;
import vooga.scroller.util.mvc.vcFramework.Tools;
import vooga.scroller.util.mvc.vcFramework.WindowComponent;
import vooga.scroller.util.mvc.vcFramework.WorkspaceView;

/**
 * This specific kind of view is intended to be the higher level view component
 * on a computer with GUI support. Its implementors are able to
 * <li>instantiate multiple workspaces</li>
 * <li>define a set of Tools to be used by all instances workspaces</li>
 * W is the defaut "WorkspaceView" for this window
 * 
 * @author Dagbedji Fagnisse
 *
 */
public interface IWindow<W extends WorkspaceView<D>, D extends IDomainDescriptor,
R extends WindowComponent, T extends Tools> extends IView {

    W initializeWorkspaceView (int id, Renderable<?> m);

    void showWorkspace (W associatedWorkspaceView, Renderable<R> m);
    
    void setDefaultWorkspaceTools(T t);

}