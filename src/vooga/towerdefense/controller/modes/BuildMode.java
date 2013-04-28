package vooga.towerdefense.controller.modes;

import java.awt.Dimension;
import java.awt.Point;

import util.Location;
import vooga.towerdefense.controller.Controller;
import vooga.towerdefense.gameelements.GameElement;

/**
 * A build mode used to aid in the placing and building of towers.
 * 
 * @author Jimmy Longley
 * @author Angelica Schwartz
 */
public class BuildMode extends ControlMode {

	/**
	 * item that the user wants to build.
	 */
	private GameElement myItemToBuild;

	/**
	 * sets the item the user is trying to build.
	 * 
	 * @param item
	 *            , gotten from shop
	 */
	public void setItemToBuild(GameElement item) {
		myItemToBuild = item;
	}

	/**
	 * handles a click on the map screen in Build mode.
	 * 
	 * @param p
	 * @param controller
	 */
	@Override
	public void handleMapClick(Point p, Controller controller) {
		Dimension tileSize = controller.getTileSize();
		int tilesWide = (int) Math.ceil(myItemToBuild.getSize().getWidth()
				/ tileSize.getWidth());
		int tilesTall = (int) Math.ceil(myItemToBuild.getSize().getHeight()
				/ tileSize.getHeight());

		if (controller.canBuildHere(p, tilesWide, tilesTall))
			controller.fixItemOnMap(myItemToBuild, p);
	}

	/**
	 * handles mouse dragging on the map screen in Build mode.
	 * 
	 * @param p
	 * @param controller
	 */
	@Override
	public void handleMapMouseDrag(Point p, Controller controller) {
		Location snappedLocation = controller
				.getPointSnappedToGrid(new Location(p.getX(), p.getY()));

		Dimension tileSize = controller.getTileSize();
		int tilesWide = (int) Math.ceil(myItemToBuild.getSize().getWidth()
				/ tileSize.getWidth());
		int tilesTall = (int) Math.ceil(myItemToBuild.getSize().getHeight()
				/ tileSize.getHeight());

		if (controller.canBuildHere(p, tilesWide, tilesTall))
			controller.paintGhostImage(myItemToBuild.getPixmap(),
					snappedLocation, myItemToBuild.getSize());
	}
}
