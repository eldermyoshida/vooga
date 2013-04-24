package vooga.towerdefense.factories.definitions;

import java.awt.Dimension;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;


/**
 * Class that defines a game element as created by the designer
 * Created from xml data parser, used to create the factory object
 * Functionally, it bundles the states the define an object
 * 
 * @author Matthew Roy
 * @author Xu Rui
 * 
 */
public class GameElementDefinition {
    private Pixmap myImage;
    private Location myCenter;
    private Dimension mySize;
    private String myType;

    public GameElementDefinition(){
    	
    }
    
    public GameElementDefinition (Pixmap image, Location center, Dimension size, String type) {
    	myImage = image;
    	mySize = size;
    	myCenter = center;
    	myType = type;
    }
    
    public Pixmap getImage () {
        return myImage;
    }

    public Location getCenter () {
        return myCenter;
    }

    public Dimension getSize () {
        return mySize;
    }
    
    public String getType (){
    	return myType;
    }

}
