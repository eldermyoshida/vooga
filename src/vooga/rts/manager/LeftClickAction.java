package vooga.rts.manager;

import vooga.rts.action.ManagerAction;
import vooga.rts.commands.ClickCommand;
import vooga.rts.commands.Command;
import vooga.rts.util.Location3D;

public class LeftClickAction extends ManagerAction {

    private Location3D myLocation;
    
    public LeftClickAction (Manager manager) {
        super(manager);
    }
    
    @Override
    public void apply () {
        getManager().select(myLocation);
    }

    @Override
    public void update (Command command) {
        if (getManager().getSelected().size() != 0) {
            getManager().applyAction(command);
        }
        else{
            //ClickCommand click = (ClickCommand) command;
            // for some reason codes stops running after casting...???? but doesn't crash
            myLocation = new Location3D();//click.getPosition();
            apply();
        }
    }


}
