package vooga.towerdefense.controller.modes;

import java.awt.Point;

import vooga.towerdefense.model.GameModel;

/**
 * The default game mode used when nothing is selected.
 * 
 * @author Jimmy Longley
 */
public class SelectMode extends ControlMode {

	public void handleMapClick(Point p, GameModel model) {
		model.displayTileCoordinates(p);
	}
}
