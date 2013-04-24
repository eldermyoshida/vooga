package vooga.towerdefense.factories.definitions;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import vooga.towerdefense.factories.AttributeManagerFactory;
import vooga.towerdefense.factories.actionfactories.ActionFactory;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;


/**
 * Class that defines a game element as created by the designer
 * Used as a replacement for an xml file
 * Functionally, it bundles the states the define an object
 * 
 * @author Matthew Roy
 * @author Xu Rui
 * 
 */
public abstract class GameElementDefinition {
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
    
    
    public abstract AttributeManagerFactory getAttributeManagerFactory();
    
    
    public List<ActionFactory> getActions() {
        return new ArrayList<ActionFactory>();
    }

}
