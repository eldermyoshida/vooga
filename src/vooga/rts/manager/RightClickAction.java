package vooga.rts.manager;

import vooga.rts.action.ManagerAction;
import vooga.rts.commands.Command;
import vooga.rts.util.Location3D;

public class RightClickAction extends ManagerAction {

    private Location3D myLocation;
    
    public RightClickAction (Manager manager) {
        super(manager);
    }
    
    @Override
    public void apply () {
        getManager().deselect(myLocation);
    }

    @Override
    public void update (Command command) {
        

    }

}
