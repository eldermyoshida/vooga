package vooga.towerdefense.model.tiles.factories;

import java.awt.Dimension;
import vooga.towerdefense.model.tiles.GrassTile;
import vooga.towerdefense.model.tiles.Tile;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

/**
 * A tile factory that creates GrassTile objects.
 * 
 * @author Erick Gonzalez
 */
public class GrassTileFactory extends TileFactory {
    /**
     * Default constructor.
     */
    public GrassTileFactory() {
        
    }

    @Override
    public Tile createTile (int id,
                            Pixmap image,
                            Location center,
                            Dimension size) {
        return new GrassTile(id, image, center, size);
    }
    
}
