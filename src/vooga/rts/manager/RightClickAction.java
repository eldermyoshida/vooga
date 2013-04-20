package vooga.rts.manager;

import vooga.rts.action.ManagerAction;
import vooga.rts.commands.Command;
import vooga.rts.controller.PositionCommand;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.util.Camera;
import vooga.rts.util.Location3D;


public class RightClickAction extends ManagerAction {

    private Location3D myLocation;

    public RightClickAction (Manager manager) {
        super(manager);
    }

    @Override
    public void apply () {
        for (InteractiveEntity ie : getManager().getSelected()) {
            ie.move(myLocation);
        }
    }

    @Override
    public void update (Command command) {
        PositionCommand click = (PositionCommand) command;
        myLocation = Camera.instance().viewtoWorld(click.getPosition());
        apply();
    }

}
