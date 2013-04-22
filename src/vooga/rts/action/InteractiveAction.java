package vooga.rts.action;

import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;


public abstract class InteractiveAction implements Action {

    private InteractiveEntity myEntity;

    public InteractiveAction (InteractiveEntity ie) {
        myEntity = ie;
    }

    public InteractiveEntity getEntity () {
        return myEntity;
    }
}
