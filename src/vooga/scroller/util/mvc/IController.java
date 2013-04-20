package vooga.scroller.util.mvc;

import java.io.File;
import vooga.scroller.util.mvc.vcFramework.WorkspaceView;


public interface IController {

    /**
     * Initialize the GUI.
     */

    public abstract void start ();

    public abstract void saveFile (File file2save, WorkspaceView t);

    public abstract void loadFile (File file2open);

    /**
     * calls model to process the input string command
     * @param t - 
     * @param cmd - command to process
     * @return ret - return int from command process
     */
    public abstract void process (WorkspaceView t, Object cmd);

    /**
     * Add a new workspace with id based on already existing workspaces.
     */
    public abstract void initializeWorkspace (int numWidthBlocks, int numHeightBlocks);

    /**
     * Add a new workspace with id based on already existing workspaces.
     */
    public abstract void initializeWorkspace ();

}
