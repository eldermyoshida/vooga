package vooga.towerdefense.factories;

import java.awt.Dimension;

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
	private static final String DEFAULT_TOWER_SHAPE = "1 1 1\n1 1 1";

	Pixmap myImage;
	Location myCenter;
	Dimension mySize;

	public TowerDefinition() {
		myImage = TOWER_IMAGE;
		myCenter = DEFAULT_TOWER_LOCATION;
		mySize = DEFAULT_TOWER_SIZE;
		myShape = DEFAULT_TOWER_SHAPE;
		setTowerSize(); 
	}

	protected void setTowerSize() {
		int width = (int) (mySize.getWidth()  * myShape.split("\n")[0].split(" ").length);
		int height = (int) (mySize.getHeight() * myShape.split("\n").length);
		mySize = new Dimension(width, height);
	}

}
