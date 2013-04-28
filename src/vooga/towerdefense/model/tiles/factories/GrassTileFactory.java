package vooga.towerdefense.model.tiles.factories;

import vooga.towerdefense.model.GameMap;
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
    public Tile createTile (Location center, GameMap map) {
        return new GrassTile(center, map.getTileSize());
    }
    
}
