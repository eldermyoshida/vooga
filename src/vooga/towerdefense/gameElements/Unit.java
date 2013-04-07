package gameElements;

import java.awt.Dimension;

import model.Path;
import util.Location;
import util.Pixmap;
import util.Sprite;
import util.Vector;


public class Unit extends Sprite {
    private Path myPath;
    private Location myDestination;

    public Unit (Location destination, Pixmap image, Location center, Dimension size, Vector velocity) {
        super(image, center, size, velocity);
        myDestination = destination;
    }

    public void updatePath(Location destination) {
        
    }
    
}
