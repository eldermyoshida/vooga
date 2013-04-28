package vooga.towerdefense.model.tiles.factories;

import vooga.towerdefense.model.GameMap;
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
    public static final String ID = "1";
    
    public PathTileFactory() {
        super();
    }

    @Override
    public Tile createTile (Location center, GameMap map) {
        return new PathTile(center, map.getTileSize());
    }
}
