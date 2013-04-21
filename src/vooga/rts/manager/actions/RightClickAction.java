package vooga.rts.manager.actions;

import vooga.rts.action.ManagerAction;
import vooga.rts.commands.Command;
import vooga.rts.commands.PositionCommand;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;
import vooga.rts.manager.Manager;
import vooga.rts.state.GameState;
import vooga.rts.util.Camera;
import vooga.rts.util.Location3D;


public class RightClickAction extends ManagerAction {

    private Location3D myLocation;

    public RightClickAction (Manager manager) {
        super(manager);
    }

    @Override
    public void apply () {
        if (myLocation != null) {
            for (InteractiveEntity ie : getManager().getSelected()) {
                ie.move(myLocation);
            }
        }
    }

    @Override
    public void update (Command command) {
        PositionCommand click = (PositionCommand) command;
        myLocation = Camera.instance().viewtoWorld(click.getPosition());
        // TODO : Check outside of bounds of map
        if (myLocation.getX() < 0 || myLocation.getY() < 0) {
            myLocation = null;
        }
        apply();
    }

}