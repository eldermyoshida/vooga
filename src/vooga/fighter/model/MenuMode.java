package vooga.fighter.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.fighter.model.objects.CharacterObject;
import vooga.fighter.model.objects.GameObject;
import vooga.fighter.model.objects.MenuObject;
import vooga.fighter.model.objects.MouseClickObject;
import vooga.fighter.model.utils.State;

/**
 * 
 * @author Jack Matteucci
 * @modified Jerry Li
 *
 */
public class MenuMode extends Mode {
    private String myMenuId;
    private List<MenuObject> myMenuObjects;
    private MouseClickObject myMouseClick;
    private MenuGrid myMenuGrid;
    private CollisionManager myCollisionManager = new CollisionManager();
    private String myChoice;
    private int myInputTicks;

    public MenuMode (String menuId) {
        super();
        myMenuId = menuId;
        myChoice = "";
        myInputTicks = 0;
    }

    @Override
    public void update(double stepTime, Dimension bounds) {
    	update();
    }

    @Override
    public void initializeMode () {
        myMenuGrid = new MenuGrid(myMenuId, this);
        myMenuObjects = myMenuGrid.getMenuObjects();
        for (MenuObject menu : myMenuObjects) {
            addObject(menu);
        }
        update();
        
    }
    
    public void update(){
    removeAppropriateObjects();
    List<GameObject> myObjects = getMyObjects();
    for (GameObject object : myObjects) {
        object.update();
    }
    for (GameObject object : myObjects) {
        object.updateState();
    }
    handleCollisions();
    myInputTicks++;
}

    public void handleCollisions() {
        myCollisionManager.checkCollisions(getMyObjects());
    }

    public String getMenusNext(String value){
    	for(MenuObject menu : myMenuObjects){
    		if(menu.getValue().equals(value)) return menu.getNext(); 
    	}
    	return "";
    }


    @Override
    public void addObject (GameObject object) {
        super.addObject(object);
        if (object instanceof MouseClickObject) {
            myMouseClick = (MouseClickObject) object;
        }
    }
    
    public void setChoice (String choice){
    	myChoice = choice;
    }
    
    public void left(){
    	myMenuGrid.left();
    }
    
    public void up(){
    	myMenuGrid.up();
    }
    
    public void down(){
    	myMenuGrid.down();
    }
    
    public void right(){
    	myMenuGrid.right();
    }
    
    public void resetChoice(){
    	myChoice = "";
    }
    
    public String peekChoice (){
    	return myChoice;
    }
    
    public MenuObject getCurrentMode(){
    	return myMenuGrid.getCurrentObject();
    }
    
    public boolean inputReady(){
    	return myInputTicks>6;
    }

}
