package vooga.rts.action;

import vooga.rts.commands.Command;
import vooga.rts.gamedesign.sprite.gamesprites.interactive.InteractiveEntity;


public class InteractiveAction implements Action {

    private InteractiveEntity myEntity;

    public InteractiveAction (InteractiveEntity ie) {
        myEntity = ie;
    }

    public InteractiveEntity getEntity () {
        return myEntity;
    }

    public void apply(InteractiveEntity i) {
    	return;
    }
    
	@Override
	public void apply() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Command command) {
		// TODO Auto-generated method stub
		
	}
}
