package vooga.scroller.viewUtil;


public interface IWindow {

    WorkspaceView initializeWorkspaceView (int id);

    void showWorkspace (WorkspaceView associatedWorkspaceView, Renderable m);

}