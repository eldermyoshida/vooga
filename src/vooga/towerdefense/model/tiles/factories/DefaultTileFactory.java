package vooga.towerdefense.model.tiles.factories;

import vooga.towerdefense.model.Tile;
import vooga.towerdefense.model.tiles.DefaultTile;
import java.awt.Dimension;
import util.Location;
import util.Pixmap;
import vooga.towerdefense.model.tiles.DefaultTile;
import vooga.towerdefense.model.Tile;

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
    public Tile createTile (Location center) {
        return new DefaultTile(center, TileFactory.DEFAULT_TILE_DIMENSIONS);
    }
    
    
    
    
}
