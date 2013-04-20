package vooga.towerdefense.model.tiles.factories;

import java.awt.Dimension;
import vooga.towerdefense.model.tiles.Tile;
import vooga.towerdefense.util.Location;
import vooga.towerdefense.util.Pixmap;

/**
 * An abstract TileFactory.
 * 
 * @author Erick Gonzalez
 */
public abstract class TileFactory {
    
    /**
     * 
     * @param id a tile id.
     * @param image a tile image
     * @param center the center of this tile on the map
     * @param size the size of the tile
     * @return
     */
    public abstract Tile createTile(int id, Pixmap image, Location center, Dimension size);
}
