package vooga.towerdefense.factories;

import java.awt.Dimension;

import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

public class ProjectileDefinition extends GameElementDefinition {

	private static final Pixmap PROJECTILE_IMAGE = new Pixmap("fireball.gif");
	private static final Location DEFAULT_PROJECTILE_LOCATION = new Location(200, 100);
	private static final Dimension DEFAULT_PROJECTILE_SIZE = new Dimension(25, 25);
	
	Pixmap myImage;
	Location myCenter;
	Dimension mySize;

	public ProjectileDefinition() {
		myImage = PROJECTILE_IMAGE;
		myCenter = DEFAULT_PROJECTILE_LOCATION;
		mySize = DEFAULT_PROJECTILE_SIZE;
	}
	
	
}
