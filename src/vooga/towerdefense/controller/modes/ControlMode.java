package vooga.towerdefense.controller.modes;

import java.awt.Point;
import vooga.towerdefense.controller.Controller;


/**
 * A class used to help the controller figure out how to handle input from the
 * view.
 * 
 * @author Jimmy Longley
 */
public abstract class ControlMode {

    public abstract void handleMapClick (Point p, Controller controller);
    
    public abstract void handleMapMouseDrag (Point p, Controller controller);
}
