package util;

import viewUtil.Renderable;
import viewUtil.WorkspaceView;

public interface IWindow {

    WorkspaceView initializeWorkspaceView (int id);

    void showWorkspace (WorkspaceView associatedWorkspaceView, Renderable m);

}