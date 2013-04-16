
package vooga.scroller.viewUtil;


public interface IWindow {

    WorkspaceView initializeWorkspaceView (int id, Renderable m);

    void showWorkspace (WorkspaceView associatedWorkspaceView, Renderable m);
    
    void setDefaultWorkspaceTools(Tools t);

}