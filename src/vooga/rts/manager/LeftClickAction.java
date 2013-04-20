package vooga.rts.manager;

import vooga.rts.action.ManagerAction;
import vooga.rts.commands.ClickCommand;
import vooga.rts.commands.Command;
import vooga.rts.controller.PositionCommand;
import vooga.rts.util.Camera;
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
        if (getManager().getSelected().size() > 0) {
            getManager().applyAction(command);
        }
        else {
            PositionCommand click = (PositionCommand) command;
            System.out.println("leftclick");
            myLocation = Camera.instance().viewtoWorld(click.getPosition());
            apply();
        }
    }

}
