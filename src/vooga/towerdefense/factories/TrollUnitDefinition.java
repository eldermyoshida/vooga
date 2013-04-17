package vooga.towerdefense.factories;

import java.awt.Dimension;
import util.Pixmap;
import vooga.towerdefense.util.Location;

/**
 * Example unit class
 * @author Matthew Roy
 *
 */
public class TrollUnitDefinition extends GameElementDefinition {
    
    private static final Pixmap TOWER_IMAGE = new Pixmap("Troll_Sprite.png");
    private static final Location DEFAULT_TOWER_LOCATION = new Location(200, 100);
    private static final Dimension DEFAULT_TOWER_SIZE = new Dimension(50, 50);
    private static final double DEFAULT_MOVE_SPEED = 50;
    private static final double DEFAULT_DIRECTION = 50;
    
    public Pixmap myImage;
    public Location myCenter;
    public Dimension mySize;

    /**
     * 
     */
    public TrollUnitDefinition () {
        // TODO Auto-generated constructor stub
    }

    
    
}
