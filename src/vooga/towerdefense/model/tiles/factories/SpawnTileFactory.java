package vooga.towerdefense.model.tiles.factories;

import util.Location;
import vooga.towerdefense.model.GameMap;
import vooga.towerdefense.model.Tile;

/**
 * @author Erick Gonzalez
 * @author Leonard K. Ng'eno
 *
 */
public class SpawnTileFactory extends PathTileFactory { 
    
    private static final String ID = "s";
    
    public SpawnTileFactory() {
        super();
    }

    @Override
    public Tile createTile (Location center, GameMap map) {
        map.setSpawnLocation(center);
        return super.createTile(center, map);
    }

    @Override
    public String getTileId () {
        return ID;
    } 
}
