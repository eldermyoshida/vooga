package vooga.towerdefense.factories;

import java.awt.Dimension;

import vooga.towerdefense.factories.definitions.GameElementDefinition;
import vooga.towerdefense.model.tiles.factories.TileFactory;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

public class TowerDefinition extends GameElementDefinition {

	private static final Pixmap TOWER_IMAGE = new Pixmap("tower.gif");
	private static final Location DEFAULT_TOWER_LOCATION = new Location(200,
			100);
	private static final Dimension DEFAULT_TOWER_SIZE = new Dimension(
			(int) TileFactory.TILE_DIMENSIONS.getWidth(),
			(int) TileFactory.TILE_DIMENSIONS.getHeight());

	Pixmap myImage;
	Location myCenter;
	Dimension mySize;

	public TowerDefinition() {
		myImage = TOWER_IMAGE;
		myCenter = DEFAULT_TOWER_LOCATION;
		mySize = DEFAULT_TOWER_SIZE;
	}

	@Override
	public AttributeManagerFactory getAttributeManagerFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
