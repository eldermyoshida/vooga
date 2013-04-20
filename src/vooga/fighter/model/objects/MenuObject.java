package vooga.fighter.model.objects;

import java.util.Collection;
import vooga.fighter.controller.ModelDelegate;
import vooga.fighter.model.loaders.MenuLoader;
import vooga.fighter.model.utils.State;


public class MenuObject extends GameObject {

    private String myChoice;
    ModelDelegate myDelegate;

    public MenuObject (String choice, ModelDelegate delegate) {
        setLoader(new MenuLoader(choice, this));
        myDelegate = delegate;
        myChoice = choice;
    }

    @Override
    public boolean shouldBeRemoved () {
        return false;
    }

    @Override
    public void update () {
    }
    
    public String getChoice(){
    	return myChoice;
    }

    public Collection<State> getStates () {
        return super.getStates();
    }

    
    public void tellDelegate(){
        System.out.println("<MenuObject.java><telldelegate> telling delegate");
    	myDelegate.notifyEndCondition(myChoice);
    }
    @Override
    public void dispatchCollision (GameObject other) {
        // TODO Auto-generated method stub

    }

    @Override
    public void handleCollision (CharacterObject other) {
        // TODO Auto-generated method stub

    }

    @Override
    public void handleCollision (AttackObject other) {
        // TODO Auto-generated method stub

    }

    @Override
    public void handleCollision (EnvironmentObject other) {
        // TODO Auto-generated method stub


    }
}
