package vooga.fighter.model;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.List;

import util.Location;
import vooga.fighter.controller.GameManager;
import vooga.fighter.model.loaders.MapLoader;
import vooga.fighter.model.loaders.MenuGridLoader;
import vooga.fighter.model.objects.MenuObject;
import vooga.fighter.model.utils.State;
import vooga.fighter.model.utils.UpdatableLocation;

public class MenuGrid {
	private final static String UNSELECTED = "Unselected";
	private final static String SELECTED = "Selected";
	private List<MenuObject> myMenuObjects;
	private MenuMode myDelegate;
	private MenuObject myCurrentMenuObject;
	
	public MenuGrid(String Id, MenuMode delegate) {
	    myDelegate = delegate;
		MenuGridLoader menuGrid = new MenuGridLoader(Id, this, delegate);
		myMenuObjects = menuGrid.getMenuObjects();
		myCurrentMenuObject = menuGrid.getFirstMenuObject();
		myCurrentMenuObject.getState(SELECTED);
	}
	
	public List<MenuObject> getMenuObjects(){
		return myMenuObjects;
	}
	
	public MenuObject getCurrentObject(){
		return myCurrentMenuObject;
	}
	
	public void left(){
		myCurrentMenuObject.setCurrentState(UNSELECTED);
		for(MenuObject menu: myMenuObjects){
			if(myCurrentMenuObject.getLeft() == menu.getNum()){
				myCurrentMenuObject = menu;
				myCurrentMenuObject.setCurrentState(SELECTED);
			}
		}
	}
	
	public void right(){
		myCurrentMenuObject.setCurrentState(UNSELECTED);
		for(MenuObject menu: myMenuObjects){
			if(myCurrentMenuObject.getRight() == menu.getNum()){
				myCurrentMenuObject = menu;
				myCurrentMenuObject.setCurrentState(SELECTED);
			}
		}
	}
	
	public void up(){
		myCurrentMenuObject.setCurrentState(UNSELECTED);
		for(MenuObject menu: myMenuObjects){
			if(myCurrentMenuObject.getUp() == menu.getNum()){
				myCurrentMenuObject = menu;
				myCurrentMenuObject.setCurrentState(SELECTED);
			}
		}
	}
	
	public void down(){
		myCurrentMenuObject.setCurrentState(UNSELECTED);
		for(MenuObject menu: myMenuObjects){
			if(myCurrentMenuObject.getDown() == menu.getNum()){
				myCurrentMenuObject = menu;
				myCurrentMenuObject.setCurrentState(SELECTED);
			}
		}
	}
	
}
