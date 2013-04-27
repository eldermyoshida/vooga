package vooga.towerdefense.model.tiles.factories;

import vooga.towerdefense.model.Tile;
import vooga.towerdefense.model.tiles.DefaultTile;
import util.Location;

/**
 * A tile factory that creates DefaultTile objects.
 * 
 * @author Jimmy Longley
 * @author Leonard K. Ng'eno
 */
public class DefaultTileFactory extends TileFactory {

    @Override
    public Tile createTile (Location center) {
        return new DefaultTile(center, TileFactory.DEFAULT_TILE_DIMENSIONS);
    }
    
    
    
    
}
