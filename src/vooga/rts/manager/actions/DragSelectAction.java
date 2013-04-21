package vooga.rts.manager.actions;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import vooga.rts.action.ManagerAction;
import vooga.rts.commands.Command;
import vooga.rts.commands.DragCommand;
import vooga.rts.manager.Manager;

public class DragSelectAction extends ManagerAction {
    
    private Shape myRectangle;

    public DragSelectAction (Manager manager) {
        super(manager);
    }
    
    @Override
    public void apply () {
        getManager().select(myRectangle);             
    }

    @Override
    public void update (Command command) {
       DragCommand drag = (DragCommand) command;
       myRectangle = drag.getWorldRectangle();
       apply();
    }

}
