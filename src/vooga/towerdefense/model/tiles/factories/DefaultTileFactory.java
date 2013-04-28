package vooga.towerdefense.model.tiles.factories;

import vooga.towerdefense.model.GameMap;
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
    
    private static final String ID = "0";
    private static final String NAME = "blank_tile.png";

    public DefaultTileFactory() {
        super();
    }

    @Override
    public Tile createTile (Location center, GameMap map) {
        return new DefaultTile(center, map.getTileSize());
    }    
    
    public String getName(){
        return NAME;
    }

    @Override
    public String getTileId () {
        return ID;
    }
}
