package vooga.towerdefense.model.tiles.factories;

import util.Location;
import vooga.towerdefense.model.Tile;
import vooga.towerdefense.model.tiles.PathTile;

public class SpawnTileFactory extends TileFactory { 

    @Override
    public Tile createTile (Location center) {
        return new PathTile(center, TileFactory.DEFAULT_TILE_DIMENSIONS);
    }

}
