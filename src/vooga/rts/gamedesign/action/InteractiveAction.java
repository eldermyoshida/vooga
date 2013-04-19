package vooga.rts.gamedesign.action;

import vooga.rts.controller.Command;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;

public abstract class InteractiveAction implements Action {
    
    private InteractiveEntity myEntity;
    public InteractiveAction(InteractiveEntity ie) {
        myEntity = ie;
    }

    public abstract void update(Command command);
    
    public InteractiveEntity getEntity() {
        return myEntity;
    }
}
