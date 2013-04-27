package vooga.towerdefense.model.tiles.factories;

import vooga.towerdefense.model.Tile;
import vooga.towerdefense.model.tiles.GrassTile;
import util.Location;
import util.Pixmap;

/**
 * A tile factory that creates GrassTile objects.
 * 
 * @author Erick Gonzalez
 */
public class GrassTileFactory extends TileFactory {
    /**
     * Image for a grass tile
     */
    public static final Pixmap GRASS_TILE_IMAGE = new Pixmap("/vooga/towerdefense/images/map/grass_tile.png");

    @Override
    public Tile createTile (Location center) {
        return new GrassTile(center, TileFactory.DEFAULT_TILE_DIMENSIONS);
    }
    
}
