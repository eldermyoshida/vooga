package vooga.towerdefense.factories.definitions;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import vooga.towerdefense.action.Action;
import vooga.towerdefense.attributes.AttributeConstants;
import vooga.towerdefense.attributes.AttributeManager;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

public class ProjectileDefinition extends GameElementDefinition {

	
	private static final int DEFAULT_WIDTH = 20;
	private static final Pixmap DEFAULT_PROJECTILE_IMAGE = new Pixmap("fireball.gif");
	private static final Dimension DEFAULT_PROJECTILE_SIZE = new Dimension(DEFAULT_WIDTH,
			DEFAULT_WIDTH);
	private static final String DEFAULT_PROJECTILE_NAME = "projectile";
	private static final Location DEFAULT_PROJECTILE_LOCATION = new Location(200, 100);

	Pixmap myImage;
	Location myCenter;
	Dimension mySize;
	String myType;

	public ProjectileDefinition() {
		myImage = DEFAULT_PROJECTILE_IMAGE;
		myCenter = DEFAULT_PROJECTILE_LOCATION;
		mySize = DEFAULT_PROJECTILE_SIZE;
		myType = DEFAULT_PROJECTILE_NAME;
	}
	
	public Pixmap getImage(){
		return myImage;
	}
	
	
}
