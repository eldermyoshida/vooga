package vooga.towerdefense.model.tiles.factories;

import vooga.towerdefense.model.Tile;
import vooga.towerdefense.model.tiles.PathTile;
import util.Location;

/**
 * A tile factory that creates PathTile objects.
 * 
 * @author Erick Gonzalez
 * @author Leonard K. Ng'eno
 */
public class PathTileFactory extends TileFactory {

    @Override
    public Tile createTile (Location center) {
        return new PathTile(center, TileFactory.DEFAULT_TILE_DIMENSIONS);
    }

}
