package vooga.fighter.model.objects;

import vooga.fighter.model.MenuMode;
import vooga.fighter.model.loaders.MenuLoader;

/**
 * 
 * @author Jerry and Jack
 *
 */
public class MenuObject extends GameObject {


    private String myNext;
    private String myValue;
    private int myGridNum;
    private int myUp;
    private int myDown;
    private int myLeft;
    private int myRight;
    private boolean myCollideState;
    
    MenuMode myDelegate;
    


    public MenuObject (String choice, MenuMode delegate) {
        setLoader(new MenuLoader(choice, this));
        myDelegate = delegate;
        myCollideState = false;

    }

    @Override
    public boolean shouldBeRemoved () {
        return false;
    }

    @Override
    public void completeUpdate () {
        
    }
    
    
    
    public int getUp(){
    	return myUp;
    }
    
    public int getDown(){
    	return myDown;
    }
    public int getLeft(){
    	return myLeft;
    }
    
    public int getRight(){
    	return myRight;
    }
    
    public int getNum(){
    	return myGridNum;
    }
    
    public void setUp(int up){
    	myUp = up;
    }
    
    public void setDown(int down){
    	myDown = down;
    }
    
    public void setRight(int right){
    	myRight = right;
    }
    
    public void setLeft(int left){
    	myLeft = left;
    }
    
    public void setNum(int num){
    	myGridNum = num;
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
        myCollideState = true;
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
