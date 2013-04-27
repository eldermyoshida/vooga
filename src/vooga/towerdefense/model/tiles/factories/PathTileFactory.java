package vooga.towerdefense.model.tiles.factories;

import vooga.towerdefense.model.Tile;
import vooga.towerdefense.model.tiles.PathTile;
import java.awt.Dimension;
import util.Location;
import util.Pixmap;

/**
 * A tile factory that creates PathTile objects.
 * 
 * @author Erick Gonzalez
 */
public class PathTileFactory extends TileFactory {
    
    /**
     * Image for a path tile
     */
    public static final Pixmap PATH_TILE_IMAGE = new Pixmap("/vooga/towerdefense/images/map/path_tile.png");

    @Override
    public Tile createTile (Location center) {
        return new PathTile(center, TileFactory.DEFAULT_TILE_DIMENSIONS);
    }

}
