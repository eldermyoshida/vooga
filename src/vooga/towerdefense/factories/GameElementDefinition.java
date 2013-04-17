package vooga.towerdefense.factories;

import java.awt.Dimension;

import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

/**
 * Class that defines a game element as created by the designer
 * Created from xml data parser, used to create the factory object
 * Functionally, it bundles the states the define an object
 * @author Matthew Roy
 *
 */
public class GameElementDefinition {
	private Pixmap myImage;
	private Location myCenter;
	private Dimension mySize;
	
    public GameElementDefinition() {
        
    }
    
	public Pixmap getImage(){
		return myImage;
	}
	
	public Location getCenter(){
		return myCenter;
	}
	
	public Dimension getSize(){
		return mySize;
	}
	

}
