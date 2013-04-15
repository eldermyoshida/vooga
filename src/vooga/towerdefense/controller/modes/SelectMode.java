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

    /**
     * handles a click on the map screen in Select mode.
     * @param p
     * @param controller
     */
    @Override
    public void handleMapClick (Point p, Controller controller) {
        //controller.displayTileCoordinates(p);
        controller.displayElementInformation(p);
    }

    /**
     * handles mouse dragging on the map screen in Select mode.
     * @param p
     * @param controller
     */
    @Override
    public void handleMapMouseDrag (Point p, Controller controller) {
        //do nothing
    }
}
