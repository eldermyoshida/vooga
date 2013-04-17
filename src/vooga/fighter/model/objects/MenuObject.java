package vooga.fighter.model.objects;

import java.util.Collection;

import vooga.fighter.controller.ModelDelegate;
import vooga.fighter.model.loaders.CharacterLoader;
import vooga.fighter.model.loaders.MenuLoader;

public class MenuObject extends GameObject {

	private String myChoice;
	ModelDelegate myDelegate;
	public MenuObject(String choice, ModelDelegate delegate) {
		setLoader(new MenuLoader(choice, this));
        myDelegate = delegate;
        myChoice = choice;
	}

	@Override
	public boolean shouldBeRemoved() {
		return false;
	}

	@Override
	public void update(){
	}
	
    public Collection getStates(){
    	return super.getStates();
    }
    
    public void tellDelegate(){
    	myDelegate.notifyEndCondition(myChoice);
    }
}
