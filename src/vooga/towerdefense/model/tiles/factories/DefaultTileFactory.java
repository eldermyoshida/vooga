package vooga.towerdefense.model.tiles.factories;

import vooga.towerdefense.model.Tile;
import vooga.towerdefense.model.tiles.DefaultTile;
import util.Location;
import util.Pixmap;

/**
 * A tile factory that creates DefaultTile objects.
 * 
 * @author Jimmy Longley
 */
public class DefaultTileFactory extends TileFactory {
    
    /**
     * Image for a path tile
     */
    //public static final Pixmap PATH_TILE_IMAGE = new Pixmap("map/default_tile.png");
    public static final Pixmap PATH_TILE_IMAGE = new Pixmap("/vooga/towerdefense/images/map/blank_tile.png");
    
    @Override
    public Tile createTile (int id, Location center) {
        return new DefaultTile(center, TileFactory.TILE_DIMENSIONS);
    }
    
    
    
    
}
