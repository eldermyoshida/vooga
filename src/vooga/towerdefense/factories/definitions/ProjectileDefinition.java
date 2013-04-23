package vooga.towerdefense.factories.definitions;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;


/**
 * Default ProjectileDefinition used for testing projectiles; 
 * only GameElementDefinition and GameElement will be made and used at the end.
 * 
 * @author XuRui
 *
 */
public class ProjectileDefinition extends GameElementDefinition {
	
	private Pixmap myImage;
	private Location myCenter;
	private Dimension mySize;
	private String myType;

	public ProjectileDefinition() {
		myImage = DefinitionConstants.DEFAULT_PROJECTILE_IMAGE;
		myCenter = DefinitionConstants.DEFAULT_PROJECTILE_LOCATION;
		mySize = DefinitionConstants.DEFAULT_PROJECTILE_SIZE;
		myType = DefinitionConstants.DEFAULT_PROJECTILE_NAME;
	}
	
	public Pixmap getImage(){
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
