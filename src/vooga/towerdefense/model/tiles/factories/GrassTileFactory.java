package vooga.towerdefense.model.tiles.factories;

import vooga.towerdefense.model.Tile;
import vooga.towerdefense.model.tiles.GrassTile;
import util.Location;

/**
 * A tile factory that creates GrassTile objects.
 * 
 * @author Erick Gonzalez
 * @author Leonard K. Ng'eno
 */
public class GrassTileFactory extends TileFactory {

    @Override
    public Tile createTile (Location center) {
        return new GrassTile(center, TileFactory.DEFAULT_TILE_DIMENSIONS);
    }
    
}
