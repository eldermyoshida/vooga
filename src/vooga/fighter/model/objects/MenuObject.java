package vooga.fighter.model.objects;

import java.util.Collection;
import java.util.Map;
import vooga.fighter.model.MenuMode;
import vooga.fighter.model.loaders.MenuLoader;
import vooga.fighter.model.utils.State;

/**
 * 
 * @author Jerry and Jack
 *
 */
public class MenuObject extends GameObject {


    private String myNext;
    private String myValue;
    MenuMode myDelegate;


    public MenuObject (String choice, MenuMode delegate) {
        setLoader(new MenuLoader(choice, this));
        myDelegate = delegate;
        //myChoice = choice;
    }

    @Override
    public boolean shouldBeRemoved () {
        return false;
    }

    @Override
    public void update () {
    }
    
    public String getValue() {
        return myValue;
    }
    
    public void setValue(String value) {
        myValue = value;
    }
    
    public void setNext(String next) {
        myNext = next;
    }
    
    public String getNext(){
    	return myNext;
    }
    
    public void tellDelegate(){
        System.out.println("<MenuObject.java><telldelegate> telling delegate");
    	myDelegate.setChoice(myValue);

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
