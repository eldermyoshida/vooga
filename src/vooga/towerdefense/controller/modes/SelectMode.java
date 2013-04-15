package vooga.towerdefense.controller.modes;

import java.awt.Point;
import vooga.towerdefense.controller.Controller;

/**
 * The default game mode used when nothing is selected.
 * 
 * @author Jimmy Longley
 * @author Angelica Schwartz
 */
public class SelectMode extends ControlMode {

    @Override
    public void handleMapClick (Point p, Controller controller) {
        controller.displayTileCoordinates(p);
    }

    @Override
    public void handleMapMouseDrag (Point p, Controller controller) {
        //do nothing
    }
}
