package vooga.towerdefense.model.tiles.factories;

import java.awt.Dimension;

import util.Location;
import util.Pixmap;
import vooga.towerdefense.model.tiles.PathTile;
import vooga.towerdefense.model.tiles.Tile;

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
    public Tile createTile (int id, Location center, Dimension tileSize) {
        return new PathTile(id, PATH_TILE_IMAGE, center, tileSize);
    }

}
